package com.toure.mehedi.style_generator_ai.domain.exception

sealed class DataException(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class Network(message: String, cause: Throwable? = null) : DataException(message, cause)
    class Http(val code: Int, message: String) : DataException(message)
    class Serialization(message: String, cause: Throwable? = null) : DataException(message, cause)
    class Storage(message: String, cause: Throwable? = null) : DataException(message, cause)
    class Unknown(message: String, cause: Throwable? = null) : DataException(message, cause)
}