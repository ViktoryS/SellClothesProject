package com.clothes.utils;

public class UtilCloth {

    public static boolean ParamsVerification(String... params) {
        for (String parameter : params) {
            if (parameter == null || parameter.equals(""))
                return false;
        }
        return true;
    }

}
