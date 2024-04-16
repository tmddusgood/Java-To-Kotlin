package com.misoweather.weatherservice.domain.region

import com.misoweather.weatherservice.domain.TimeStamped
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime

@Entity
@DynamicUpdate
@Table(name = "REGION_TB")
class Region(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "BIGSCALE", nullable = false, columnDefinition = "varchar(45)")
    var bigScale: String,

    @Column(name = "MIDSCALE", nullable = false, columnDefinition = "varchar(45)")
    var midScale: String,

    @Column(name = "SMALLSCALE", nullable = false, columnDefinition = "varchar(45)")
    var smallScale: String,

    @Column(name = "LOCATION_X", nullable = false, columnDefinition = "varchar(45)")
    var LOCATION_X: Int,

    @Column(name = "LOCATION_Y", nullable = false, columnDefinition = "varchar(45)")
    var LOCATION_Y: Int,

    @Column(name = "LATITUDE", nullable = false, columnDefinition = "varchar(45)")
    var LATITUDE: Int,

    @Column(name = "LONGITUDE", nullable = false, columnDefinition = "varchar(45)")
    var LONGITUDE: Int,

    @Column(name = "LAST_WEATHER_UPDATE")
    var lastWeatherUpdate: LocalDateTime? = null
) : TimeStamped()
{
    fun update(modifiedDateTime: LocalDateTime): Region {
        this.lastWeatherUpdate = modifiedDateTime
        return this
    }
}