package com.ciklum.trendyol.serivce.validator.deepLink;

import com.ciklum.trendyol.domain.enums.LinkType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation of deep link checking
 */
public class DeepLinkValidator implements ConstraintValidator<DeepLinkConstraint, String> {

    @Override
    public void initialize(DeepLinkConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String deepLink, ConstraintValidatorContext context) {
        return deepLink.contains(LinkType.DEEP_LINK.getKey());
    }
}
