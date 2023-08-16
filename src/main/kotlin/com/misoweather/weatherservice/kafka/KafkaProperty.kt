package com.misoweather.weatherservice.kafka

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "kafka")
data class KafkaProperty constructor(
    private var ip: String = "3.38.166.215",
    private var port: String = "9092",
    private var groupId: String = "weather"
) {
    fun getFullIp() = "${this.ip}:${this.port}"
    fun getGroupId() = this.groupId
}