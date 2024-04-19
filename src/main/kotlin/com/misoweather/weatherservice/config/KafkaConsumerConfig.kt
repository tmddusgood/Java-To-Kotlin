package com.misoweather.weatherservice.config

import com.misoweather.weatherservice.kafka.KafkaProperty
import com.misoweather.weatherservice.kafka.MemberEvent
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class ConsumerConfiguration constructor(
    private val kafkaProperty: KafkaProperty
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, MemberEvent> {
        return DefaultKafkaConsumerFactory(getConfig(), StringDeserializer(), JsonDeserializer(MemberEvent::class.java, false))
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, MemberEvent> {
        val concurrentKafkaListenerContainerFactory = ConcurrentKafkaListenerContainerFactory<String, MemberEvent>()
        concurrentKafkaListenerContainerFactory.consumerFactory = consumerFactory()
        return concurrentKafkaListenerContainerFactory
    }

    @Bean
    fun getConfig(): Map<String, Any> =
        mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.getFullIp(),
            ConsumerConfig.GROUP_ID_CONFIG to kafkaProperty.getGroupId(),
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java, // 메시지 key에 대한 역직렬화 설정
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java, // 메시지 value에 대한 역직렬화 설정
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest", // offest이 없거나 오류가 발생했을때 처리할 작업에 대한 설정
        )
}