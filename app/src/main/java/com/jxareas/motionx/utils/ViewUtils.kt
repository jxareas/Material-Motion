package com.jxareas.motionx.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.viewbinding.ViewBinding

inline infix fun<reified VB : ViewBinding> ViewGroup.bind(
    crossinline bindingInflater : LayoutInflater.(parent : ViewGroup, attachToParent : Boolean) -> VB
) : VB = LayoutInflater.from(context).let { inflater ->
    bindingInflater.invoke(inflater, this, false)
}

fun NavController.safeNavigate(direction: NavDirections, extras: FragmentNavigator.Extras? = null) {

    currentDestination?.getAction(direction.actionId)?.run {
        if(extras != null) navigate(direction, extras) else navigate(direction)
    }
}

fun NavController.safeNavigate(
    @IdRes currentDestinationId: Int,
    @IdRes id: Int,
    args: Bundle? = null
) {
    if (currentDestinationId == currentDestination?.id) {
        navigate(id, args)
    }
}