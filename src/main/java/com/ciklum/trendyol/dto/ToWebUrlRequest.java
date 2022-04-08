package com.ciklum.trendyol.dto;

import com.ciklum.trendyol.serivce.validator.deepLink.DeepLinkConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Request dto to web URL
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToWebUrlRequest {

    @NotBlank
    @DeepLinkConstraint
    private String link;
}
