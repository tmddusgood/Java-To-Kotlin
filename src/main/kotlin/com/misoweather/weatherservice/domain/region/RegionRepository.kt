package com.misoweather.weatherservice.domain.region

import org.springframework.data.jpa.repository.JpaRepository

interface RegionRepository : JpaRepository<Region, Long> {
    fun findByBigScale(bigScale: String): List<Region>
    fun findByBigScaleAndMidScale(bigScale: String, midScale: String): List<Region>
}