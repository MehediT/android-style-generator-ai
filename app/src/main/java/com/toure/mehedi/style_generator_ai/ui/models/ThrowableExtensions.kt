package com.toure.mehedi.style_generator_ai.ui.models

import androidx.annotation.StringRes
import com.toure.mehedi.style_generator_ai.R
import com.toure.mehedi.style_generator_ai.domain.exception.DataException
import com.toure.mehedi.style_generator_ai.domain.exception.DomainException

@StringRes
fun Throwable.toErrorResId(): Int = when (this) {
    is DataException.Network -> R.string.error_network
    is DataException.Http -> R.string.error_server
    is DataException.Serialization -> R.string.error_serialization
    is DataException.Storage -> R.string.error_storage
    is DataException.Unknown -> R.string.error_unknown
    is DomainException.Unauthorized -> R.string.error_unauthorized
    is DomainException.NotFound -> R.string.error_not_found
    is DomainException.Forbidden -> R.string.error_forbidden
    is DomainException.Validation -> R.string.error_invalid_image
    is DomainException.Unknown -> R.string.error_unknown
    else -> R.string.error_unknown
}
