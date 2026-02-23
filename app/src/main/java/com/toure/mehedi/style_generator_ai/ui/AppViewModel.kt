package com.toure.mehedi.style_generator_ai.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toure.mehedi.style_generator_ai.domain.model.AuthState
import com.toure.mehedi.style_generator_ai.domain.usecase.EnsureAnonymousAuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val ensureAnonymousAuth: EnsureAnonymousAuthUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        ensureSession()
    }

    fun ensureSession() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            runCatching { ensureAnonymousAuth() }
                .onSuccess {
                    Log.d(TAG, "ensureSession: success (Authenticated)")
                    _authState.value = AuthState.Authenticated
                }
                .onFailure {
                    Log.d(TAG, "ensureSession: failure (Unknown error)")
                    _authState.value = AuthState.Error(it.message ?: "Unknown error")
                }
        }
    }
    companion object {
        const val  TAG = "AppViewModel"
    }
}
