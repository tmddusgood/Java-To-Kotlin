package com.misoweather.weatherservice.domain.weather

import com.misoweather.weatherservice.global.constants.BigScaleEnum
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash("currentAir")
data class CurrentAir(
    @Id
    @Indexed
    val key: Long,

    val pm10: Int,
    val pm25: Int,
    val pm10Grade: String,
    val pm25Grade: String,
    val bigScale: String,

    @TimeToLive
    val expiration: Long = 3600L
) {
    companion object {
        fun create(
            pm10: Int,
            pm25: Int,
            pm10Grade: String,
            pm25Grade: String,
            bigScale: String
        ): CurrentAir {
            val key = BigScaleEnum.getEnumByShortValues(bigScale).redisKey
            return CurrentAir(
                key = key,
                pm10 = pm10,
                pm25 = pm25,
                pm10Grade = pm10Grade,
                pm25Grade = pm25Grade,
                bigScale = bigScale
            )
        }
    }
}
