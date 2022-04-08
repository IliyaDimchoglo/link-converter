package com.ciklum.trendyol.dto;

import com.ciklum.trendyol.serivce.validator.webUrl.WebUrlConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Request dto to deep link
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDeepLinkRequest {

    @NotBlank
    @WebUrlConstraint
    private  String link;

}
