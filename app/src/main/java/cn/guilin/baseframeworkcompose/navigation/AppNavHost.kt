package cn.guilin.baseframeworkcompose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import cn.guilin.feature.goods.navigation.goodsGraph
import cn.guilin.main.navigation.MAIN_ROUTE
import cn.guilin.main.navigation.mainGraph
import cn.guilin.navigation.AppNavigator
import cn.guilin.navigation.handleNavigationEvent
import kotlinx.coroutines.flow.collectLatest

/**
 * 应用导航宿主
 * 配置整个应用的导航图和动画
 */
@Composable
fun AppNavHost(
    navigator: AppNavigator,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    // 监听导航事件
    LaunchedEffect(navController) {
        navigator.navigationEvents.collectLatest { event ->
            navController.handleNavigationEvent(event)
        }
    }

    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE,
        modifier = modifier,
        // 页面进入动画
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        // 页面退出动画
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        // 返回时页面进入动画
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        // 返回时页面退出动画
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        // 只调用模块级Graph函数，大大减少了冲突可能性
        mainGraph(navController)
        goodsGraph(navController)
    }
}