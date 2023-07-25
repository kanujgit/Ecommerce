package com.kdroid.ecommerce.api

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val e: Any) : ApiState()
    class Success(val data: Any) : ApiState()
}