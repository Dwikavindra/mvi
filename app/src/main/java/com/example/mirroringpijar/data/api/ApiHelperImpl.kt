package com.example.mirroringpijar.data.api

import com.example.mirroringpijar.data.model.Data

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getData(): Data {
        return apiService.getData()
    }
}