package com.jxareas.motionx.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

fun View.visible() = apply { visibility = View.VISIBLE }

fun View.gone() = apply { visibility = View.GONE }

fun View.invisible() = apply { visibility = View.INVISIBLE }

internal inline infix fun <reified VB : ViewBinding> ViewGroup.bind(
    crossinline bindingInflater: LayoutInflater.(parent: ViewGroup, attachToParent: Boolean) -> VB,
): VB = LayoutInflater.from(context).let { layoutInflater ->
    bindingInflater.invoke(layoutInflater, this, false)
}

fun NavController.safeNavigate(direction: NavDirections, extras: FragmentNavigator.Extras? = null) {

    currentDestination?.getAction(direction.actionId)?.run {
        if (extras != null) navigate(direction, extras) else navigate(direction)
    }
}

fun NavController.safeNavigate(
    @IdRes currentDestinationId: Int,
    @IdRes id: Int,
    args: Bundle? = null,
) {
    if (currentDestinationId == currentDestination?.id) {
        navigate(id, args)
    }
}

typealias void = (NavHostFragment) -> Unit

fun FragmentManager.findNavHostFragmentById(@IdRes id: Int): NavHostFragment =
    findFragmentById(id) as NavHostFragment


