package dev.android.myapplication_superest.graphs

import dev.android.myapplication_superest.R

sealed class BottomNavItem
      (var route:String, var icon:Int, var title:String){
        object Shop: BottomNavItem("shop", R.drawable.ic_shop,"Shop")
        object Explore: BottomNavItem("explore",R.drawable.ic_explore,"Explore")
        object Cart: BottomNavItem("cart",R.drawable.ic_cart,"Cart")
        object Favourite: BottomNavItem("favorite",R.drawable.ic_baseline_favorite_border_24,"Favourite")
        object Account:  BottomNavItem("Account",R.drawable.ic_account,"Account")
}
