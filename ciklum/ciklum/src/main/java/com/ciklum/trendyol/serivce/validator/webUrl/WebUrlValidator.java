package com.ciklum.trendyol.serivce.validator.webUrl;

import com.ciklum.trendyol.domain.enums.LinkType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of web url checking
 */
public class WebUrlValidator implements ConstraintValidator<WebUrlConstraint, String> {

    @Override
    public void initialize(WebUrlConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String webUrl, ConstraintValidatorContext context) {
        return webUrl.contains(LinkType.WEB_URL.getKey());
    }
}
