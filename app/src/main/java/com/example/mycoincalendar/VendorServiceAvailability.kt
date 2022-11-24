package com.example.mycoincalendar

data class VendorServiceAvailability(
    val from_time: String,
    val from_time_meridiem: String,
    val id: Int,
    val to_time: String,
    val to_time_meridiem: String,
    val vendor_service_id: Int,
    val week_day: Int
)
