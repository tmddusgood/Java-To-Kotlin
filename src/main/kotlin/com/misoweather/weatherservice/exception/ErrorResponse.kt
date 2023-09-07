package com.misoweather.weatherservice.exception

// 모든 에러 케이스 HttpStatus로 커버가 힘든 것 같아서, 커스텀 메시지로 바꿔보겠다
data class ErrorResponse(
    val code: Int,
    val message: String
)
