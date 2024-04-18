package com.misoweather.weatherservice.domain.weather

import com.misoweather.weatherservice.domain.region.Region
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface CurrentWeatherRepository : JpaRepository<CurrentWeather, Long> {
    fun findByRegion(region: Region): CurrentWeather?
    fun findFirstByCreatedAtIsAfterAndRegion(startTime: LocalDateTime, region: Region): CurrentWeather?
    fun findLocalDateTimeByRegion(region: Region): LocalDateTime?
}
