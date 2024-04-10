package com.example.myapplication.domain.usecases.appEntry

import com.example.myapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()
}