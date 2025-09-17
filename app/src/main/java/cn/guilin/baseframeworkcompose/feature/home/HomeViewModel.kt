package cn.guilin.baseframeworkcompose.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.guilin.baseframeworkcompose.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val navigator: AppNavigator) : ViewModel() {

    /**
     * 导航到商品详情页
     */
    fun navigateToGoodsDetail(goodsId: String) {
        viewModelScope.launch {
            navigator.navigateTo("goods_detail/$goodsId")
        }
    }
}
