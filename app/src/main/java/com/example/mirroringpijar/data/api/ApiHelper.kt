package com.example.mirroringpijar.data.api

import com.example.mirroringpijar.data.model.Data

interface ApiHelper {
    suspend fun getData(): Data
}