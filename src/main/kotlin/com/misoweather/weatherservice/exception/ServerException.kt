package com.misoweather.weatherservice.exception

sealed class ServerException(
    val code: Int,
    override val message: String
) : RuntimeException(message)

data class NotFoundException(
    override val message: String = "Not Found"
) : ServerException(404, message)

data class UnauthorizedException(
    override val message: String = "Unauthorized"
) : ServerException(401, message)