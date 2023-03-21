package com.emmanuelarango.converter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConverterViewModel : ViewModel() {

    val conversionCoin: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    val isErrorValidation: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun convertPesosToDolares(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert) / 4800
    }

    fun convertPesosToPesos(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert)
    }

    fun convertPesosToEuros(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert) / 5000
    }

    fun convertDolaresToPesos(ammountToConvert: Double) {
        conversionCoin.value= (ammountToConvert) * 4700
    }

    fun convertDolaresToEuros(ammountToConvert: Double) {
        conversionCoin.value= (ammountToConvert) * 0.94
    }

    fun convertDolaresToDolares(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert)
    }

    fun convertEurosToPesos(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert) * 5000
    }

    fun convertEurosToDolares(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert) * 1.7
    }

    fun convertEurosToEuros(ammountToConvert: Double) {
        conversionCoin.value = (ammountToConvert)
    }

    fun validations(ammountToConvert: Double, Pesos: Boolean, Dolares: Boolean, Euros: Boolean, ToPesos: Boolean, ToEuros: Boolean, ToDolares: Boolean) {
        if (ammountToConvert > 0) {

            if (Pesos && ToDolares) {

                convertPesosToDolares(ammountToConvert)

            } else if (Pesos && ToPesos) {

                convertPesosToPesos(ammountToConvert)

            } else if (Pesos && ToEuros) {

                convertPesosToEuros(ammountToConvert)

            } else if (Dolares && ToPesos) {

                convertDolaresToPesos(ammountToConvert)

            } else if (Dolares && ToEuros) {

                convertDolaresToEuros(ammountToConvert)
            } else if (Dolares && ToDolares) {

                convertDolaresToDolares(ammountToConvert)
            } else if (Euros && ToPesos) {

                convertEurosToPesos(ammountToConvert)
            } else if (Euros && ToDolares) {

                convertEurosToDolares(ammountToConvert)
            } else {
                convertEurosToEuros(ammountToConvert)
            }
        }else{

            isErrorValidation.value = true

        }
    }


}