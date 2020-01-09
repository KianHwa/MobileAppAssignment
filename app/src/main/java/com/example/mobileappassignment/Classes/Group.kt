package com.example.mobileappassignment.Classes

import java.io.Serializable

data class Group(var groupID : String = "", var groupName : String = "", var groupDescription : String = "", var peopleJoined : Int = 0) : Serializable