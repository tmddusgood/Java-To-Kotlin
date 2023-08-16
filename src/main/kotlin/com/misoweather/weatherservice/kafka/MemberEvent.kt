package com.misoweather.weatherservice.kafka

import com.fasterxml.jackson.annotation.JsonProperty

data class MemberEvent(
    @JsonProperty("memberId") val memberId: Long?,
    @JsonProperty("socialId") val socialId: String?,
    @JsonProperty("socialType") val socialType: String?,
    @JsonProperty("nickname") val nickname: String?,
    @JsonProperty("emoji") val emoji: String?,
    @JsonProperty("defaultRegion") val defaultRegion: Long?
)