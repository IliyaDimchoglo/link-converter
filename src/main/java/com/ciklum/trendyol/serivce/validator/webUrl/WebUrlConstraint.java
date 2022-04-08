package com.ciklum.trendyol.serivce.validator.webUrl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.ciklum.trendyol.exception.ExceptionMessageHelper.WEB_URL_VALIDATION_EX_MESSAGE;
import static java.lang.annotation.ElementType.*;

/**
 * Custom annotation for web url validation
 */
@Documented
@Constraint(validatedBy = WebUrlValidator.class)
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @ interface WebUrlConstraint {
    String message() default WEB_URL_VALIDATION_EX_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
