package cn.guilin.framework.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.guilin.framework.core.common.result.Result
import cn.guilin.framework.core.common.result.asResult
import cn.guilin.framework.core.data.repository.BannerRepository
import cn.guilin.framework.core.model.Banner
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.navigation.AppNavigator
import cn.guilin.framework.navigation.routes.GoodsRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * 首页ViewModel
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: AppNavigator,
    private var bannerRepository: BannerRepository
) : ViewModel() {
    private val _datum = MutableStateFlow<List<Banner>>(emptyList())
    val datum: StateFlow<List<Banner>> = _datum

    init {
        getBannerList()
    }

    /**
     * 导航到商品详情页
     */
    fun navigateToGoodsDetail(goodsId: String) {
        viewModelScope.launch {
            navigator.navigateTo("${GoodsRoutes.DETAIL}/$goodsId")
        }
    }

    private fun getBannerList() {
        viewModelScope.launch {
            bannerRepository.getBannerList()
                .asResult()
                .collectLatest { result: Result<BaseResponse<BasePageData<Banner>>> ->
                    when (result) {
                        is Result.Loading -> {

                        }

                        is Result.Success -> {
                            val bannerList = result.data.data?.list
                            Timber.d("Banner list data: $bannerList")
                            _datum.value = bannerList ?: emptyList()
                        }

                        is Result.Error -> {
                            Timber.e(result.exception)
                        }
                    }
                }
        }
    }
}
