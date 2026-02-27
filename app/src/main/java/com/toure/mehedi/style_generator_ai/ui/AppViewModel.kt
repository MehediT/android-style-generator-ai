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

    fun ensureSession() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            runCatching { ensureAnonymousAuth() }
                .onSuccess { _authState.value = AuthState.Authenticated }
                .onFailure {
                    Log.e(TAG, "ensureSession error: ${it::class.simpleName} — ${it.message}", it)
                    _authState.value = AuthState.Error(it.message ?: "Unknown error")
                }
            Log.d(TAG, "ensureSession: ${_authState.value}")
        }
    }

    companion object {
        private const val TAG = "AppViewModel"
    }
}
