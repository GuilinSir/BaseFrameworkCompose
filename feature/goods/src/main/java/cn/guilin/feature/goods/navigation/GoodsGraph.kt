package cn.guilin.feature.goods.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
 * 商品模块导航图
 */
fun NavGraphBuilder.goodsGraph(navController: NavHostController) {
    goodsDetailScreen()
}

