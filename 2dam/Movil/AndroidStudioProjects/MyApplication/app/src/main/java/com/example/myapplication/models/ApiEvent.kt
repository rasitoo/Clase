package com.example.myapplication.models


data class ApiEvent(
    val id: String,
    val name: String,
    val images: List<Image>,
    val dates: Dates,
    val info: String?,
    val classifications: List<Classification>,
    val _embedded: ApiEmbedded
)

data class Dates(val start: Start)
data class Start(val date: String, val time: String?)
data class Image(val url: String)
data class Classification(val segment: Segment)
data class Segment(val name: String)
data class ApiEmbedded(val venues: List<Venue>)
data class Venue(val name: String, val city: City)
data class City(val name: String)