package com.toure.mehedi.style_generator_ai.ui.models

sealed class AppEvent(open val message: String) {
    data class Error(override val message: String) : AppEvent(message)
    data class Warning(override val message: String) : AppEvent(message)
    data class Info(override val message: String) : AppEvent(message)
    data class Success(override val message: String) : AppEvent(message)
}
