package com.example.mirroringpijar.data.repository

import com.example.mirroringpijar.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getData()
}