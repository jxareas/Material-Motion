package com.jxareas.motionx.ui.common.listener

import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.ui.common.events.OnClick

@FunctionalInterface
fun interface ExhibitionAdapterListener : OnClick<Exhibition>