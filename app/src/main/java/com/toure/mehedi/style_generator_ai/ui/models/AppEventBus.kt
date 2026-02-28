package com.toure.mehedi.style_generator_ai.ui.models

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppEventBus @Inject constructor() {
    private val _events = MutableStateFlow<List<AppEvent>>(emptyList())
    val events = _events.asStateFlow()

    fun emit(event: AppEvent) {
        _events.update { it + event }
    }

    fun dismiss(event: AppEvent) {
        _events.update { it - event }
    }
}