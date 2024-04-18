package com.misoweather.weatherservice.global.constants

// TODO companion object 최적화 요소 살펴보기 - 중복 코드?
enum class AirEnum(
    val icon: String,
    val findDustCriteria: Int,
    val ultraFineDustCriteria: Int,
    val grade: String
) {
    GOOD("\uD83D\uDE0A", 30, 15, "좋음"),
    NORMAL("\uD83D\uDE10", 80, 35, "보통"),
    BAD("☹️", 150, 75, "나쁨"),
    VERYVBAD("\uD83D\uDE21", 99999, 99999, "매우나쁨");

    companion object {
        fun getEnumForFineDust(value: Int): AirEnum {
            for (v in values()) {
                if (value < v.findDustCriteria) return v
            }
            throw IllegalArgumentException()
        }

        fun getEnumForUltraDust(value: Int): AirEnum {
            for (v in values()) {
                if (value < v.ultraFineDustCriteria) return v
            }
            throw IllegalArgumentException()
        }
    }
}