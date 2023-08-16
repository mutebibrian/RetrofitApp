package com.mastercoding.retrofitapp

import com.google.gson.annotations.SerializedName


// 1- Data Classes (POJO)
data class AlbumItem(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String
)