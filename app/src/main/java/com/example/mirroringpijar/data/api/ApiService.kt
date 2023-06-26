package com.example.mirroringpijar.data.api

import com.example.mirroringpijar.data.model.Data
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getData(): Data
}