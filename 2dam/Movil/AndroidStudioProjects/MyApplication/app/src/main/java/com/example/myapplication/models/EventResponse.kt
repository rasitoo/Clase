package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("_embedded") val embedded: Embedded?
)