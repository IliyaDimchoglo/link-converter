package com.ciklum.trendyol.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Converter exception messages class.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessageHelper {

    public static final String LINK_VALIDATION_EX_MESSAGE = "Invalid deep link.";
    public static final String WEB_URL_EX_MESSAGE = "Web url can't be converted. ";
    public static final String WEB_URL_VALIDATION_EX_MESSAGE = "Invalid web url. ";
    public static final String LINK_CONVERTED_EX_MESSAGE = "Deep link can't be converted. ";
}
