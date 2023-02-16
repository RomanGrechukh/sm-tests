package com.savvymoney.smtests.cucumber.utils;

import java.util.Random;

public class CommonUtils {
    public static String getRandomString()
    {
        Random rand = new Random();
        return Integer.toString(rand.nextInt());
    }
}
