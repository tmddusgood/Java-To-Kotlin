package com.misoweather.weatherservice.global.constants

enum class BigScaleEnum(val value: String, val redisKey: Long, val shortValue: String) {
    서울("서울특별시", 0L, "서울"),
    경기("경기도", 1L, "경기"),
    인천("인천광역시", 2L, "인천"),
    대전("대전광역시", 3L, "대전"),
    세종("세종특별자치시", 4L, "세종"),
    충북("충청북도", 5L, "충북"),
    충남("충청남도", 6L, "충남"),
    광주("광주광역시", 7L, "광주"),
    전북("전라북도", 8L, "전북"),
    전남("전라남도", 9L, "전남"),
    대구("대구광역시", 10L, "대구"),
    부산("부산광역시", 11L, "부산"),
    울산("울산광역시", 12L, "울산"),
    경북("경상북도", 13L, "경북"),
    경남("경상남도", 14L, "경남"),
    강원("강원도", 15L, "강원"),
    제주("제주도", 16L, "제주");

    companion object {
        fun getEnum(value: String): BigScaleEnum {
            return values().firstOrNull { it.value.equals(value, ignoreCase = true) }
                ?: throw IllegalArgumentException()
        }

        fun getEnumByShortValues(shortValue: String): BigScaleEnum {
            return values().firstOrNull { it.shortValue.equals(shortValue, ignoreCase = true) }
                ?: throw IllegalArgumentException()
        }
    }
}
