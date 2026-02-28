package com.toure.mehedi.style_generator_ai.domain.exception

sealed class DomainException(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class NotFound(message: String) : DomainException(message)
    class Unauthorized(message: String) : DomainException(message)
    class Forbidden(message: String) : DomainException(message)
    class Validation(message: String) : DomainException(message)
    class Unknown(message: String, cause: Throwable? = null) : DomainException(message, cause)
}