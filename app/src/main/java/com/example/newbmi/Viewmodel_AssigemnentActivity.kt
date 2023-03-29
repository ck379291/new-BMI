package com.example.newbmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.round

class Viewmodel_AssigemnentActivity:ViewModel() {
    var value01:MutableLiveData<Float> = MutableLiveData()
    var text:MutableLiveData<String> = MutableLiveData()
    fun calculation(hi:Double,wi:Int){
        val height:Double=hi/100
        var  BMI = wi / (height * height)
        var total=(round(BMI*100)/100.0)
        value01.value=total.toFloat()
        if (total < 18) {
            text.value = "you are under weight"
        } else if (total >= 18 && total < 25) {
            text.value = "you are healthy"
        } else  {
            text.value = "you are over weight"
        }
    }
}