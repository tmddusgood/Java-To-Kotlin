package com.misoweather.weatherservice.domain.weather

import com.fasterxml.jackson.annotation.JsonIgnore
import com.misoweather.weatherservice.domain.TimeStamped
import com.misoweather.weatherservice.domain.region.Region
import org.hibernate.annotations.DynamicUpdate
import jakarta.persistence.*

@DynamicUpdate
@Entity(name = "CURRENT_WEATHER_TB")
class CurrentWeather(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CURRENT_WEATHER_SEQ")
    val seq: Long? = null,

    @Column(name = "TEMPERATURE", nullable = false)
    var temperature: Float = 0f,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "REGION_ID")
    var region: Region? = null,

    @Column(name = "WEATHER", nullable = false)
    var weather: String = "",

    @JsonIgnore
    @Column(name = "WIND_SPEED", nullable = false)
    var windSpeed: Float = 0f,

    @JsonIgnore
    @Column(name = "HUMIDITY", nullable = false)
    var humidity: Int = 0
) : TimeStamped()
{
    fun update(temperature: Float, weather: String): CurrentWeather {
        this.temperature = temperature
        this.weather = weather
        return this
    }
}