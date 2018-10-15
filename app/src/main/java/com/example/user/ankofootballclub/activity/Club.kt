package com.example.user.ankofootballclub.activity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(var name : String, var description : String, var image : String) : Parcelable