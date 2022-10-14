package com.example.randomcatfactapp

import java.lang.reflect.Array.get
import javax.inject.Inject

class MainRepository @Inject constructor(val catInterface: CatInterface){
    suspend fun getCatFacts()=
        catInterface.getAllCatFacts()
}