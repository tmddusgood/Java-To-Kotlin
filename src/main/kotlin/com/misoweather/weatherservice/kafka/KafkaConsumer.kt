package com.misoweather.weatherservice.kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class SampleTopicListener {

    val log = LoggerFactory.getLogger(SampleTopicListener::class.java)

    @KafkaListener(topics = ["misoweather-weather"], groupId = "weather")
    fun consume(@Payload data: MemberEvent) {
        log.info("Message $data")
    }
}