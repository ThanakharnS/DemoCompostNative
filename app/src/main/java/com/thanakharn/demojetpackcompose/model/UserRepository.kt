package com.thanakharn.demojetpackcompose.model

import kotlinx.coroutines.delay


class UserRepository {
   suspend fun fetchUserData() : UserData {
        delay(1000)
        return UserData("Thanakharn","34")
    }

}