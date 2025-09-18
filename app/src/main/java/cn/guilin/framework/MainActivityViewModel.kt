package cn.guilin.framework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.guilin.framework.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
) : ViewModel() {
}