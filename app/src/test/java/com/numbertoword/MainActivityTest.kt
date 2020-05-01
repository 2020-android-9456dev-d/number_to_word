package com.numbertoword

import org.junit.Assert
import org.junit.Test

class MainActivityTest {

    @Test
    fun testOneDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(1)

        Assert.assertEquals(" One", result);


    }

    @Test
    fun testTwoDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(10)

        Assert.assertEquals(" Ten", result);


    }

    @Test
    fun testThreeDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(100)

        Assert.assertEquals(" One Hundred", result);


    }

    @Test
    fun testFourDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(1000)

        Assert.assertEquals(" One Thousand", result);


    }

    @Test
    fun testFiveDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(10000)

        Assert.assertEquals(" Ten Thousand", result);


    }

    @Test
    fun testSixDigit(){

        var numberUtils = NumberUtils()

        var result = numberUtils.convertNumberToWords(100000)

        Assert.assertEquals(" One Lakh", result);


    }
}