package com.app.trendingrepositorykmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform