package com.example.sparshclassesadvance.Network

class AppConstants {
    companion object {
        const val BASE_URL = "https://cdm.a3charge.com/app/"

        const val EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)\$"
        const val PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[A-Z]).{8,255}\$"
        const val NUMBER_PATTERN = "^[0-9]*$"
        const val RUPEE = "₹"
        const val PREFRENCE_NAME = "charger"
        const val PERSISTABLE_PREFRENCE_NAME = "PERSISTABLE_PREFRENCE_NAME"


    }
}