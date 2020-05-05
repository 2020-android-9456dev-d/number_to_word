package com.numbertoword

class MainActivityPresenter(val view: MainActivityView) {

    fun getNumberToWord(parseInt: Int) {
        try {
            var numberUtils = NumberUtils()
            view.onSuccess(parseInt, numberUtils.convertNumberToWords(parseInt))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}