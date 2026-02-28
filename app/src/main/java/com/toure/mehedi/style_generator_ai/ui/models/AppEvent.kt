package com.toure.mehedi.style_generator_ai.ui.models

import androidx.annotation.StringRes

sealed class AppEvent(@param:StringRes open val messageRes: Int) {
    data class Error(@param:StringRes override val messageRes: Int) : AppEvent(messageRes)
    data class Warning(@param:StringRes override val messageRes: Int) : AppEvent(messageRes)
    data class Info(@param:StringRes override val messageRes: Int) : AppEvent(messageRes)
    data class Success(@param:StringRes override val messageRes: Int) : AppEvent(messageRes)
}
