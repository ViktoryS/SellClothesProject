package com.clothes.utils;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class UtilCloth {

    private static Logger logger = Logger.getLogger(UtilCloth.class);

    public static boolean ParamsVerification(String... params) {
        logger.debug("Params Verification: " + Arrays.toString(params));
        for (String parameter : params) {
            if (parameter == null || parameter.equals("")) {
                logger.warn("Some parameter is null");
                return true;
            }
        }
        logger.debug("Parameters OK!");
        return false;
    }

}
