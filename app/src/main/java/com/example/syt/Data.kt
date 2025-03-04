package com.example.syt

data class VideoYT (
    val videoTitle: String,
    val views: Int,
    val timeAgo: String
)

data class VideoCategory (
    val id: Int,
    val name: String
)