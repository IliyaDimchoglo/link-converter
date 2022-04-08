package com.ciklum.trendyol.serivce.validator.deepLink;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.ciklum.trendyol.exception.ExceptionMessageHelper.LINK_VALIDATION_EX_MESSAGE;
import static java.lang.annotation.ElementType.*;

/**
 * Custom annotation for deep link validation
 */
@Documented
@Constraint(validatedBy = DeepLinkValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DeepLinkConstraint {
    String message() default LINK_VALIDATION_EX_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}