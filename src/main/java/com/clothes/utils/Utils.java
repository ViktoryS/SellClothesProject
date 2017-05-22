package com.clothes.utils;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Enumeration;

public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class);

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

    public static boolean userExists(Enumeration<String> enumeration){
        while (enumeration.hasMoreElements()){
            if(enumeration.nextElement().equals("user")){
                return true;
            }
        }
        return false;
    }

}
