package com.ciklum.trendyol.web;

import com.ciklum.trendyol.dto.ConverterResponse;
import com.ciklum.trendyol.dto.ToDeepLinkRequest;
import com.ciklum.trendyol.dto.ToWebUrlRequest;
import com.ciklum.trendyol.serivce.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConverterController {

    private final ConverterService converterService;

    /**
     * @param request contains WEB URL as String
     * @return Deep Link as String
     */
    @PostMapping(value = "/convert_to_deep", produces = MediaType.APPLICATION_JSON_VALUE)
    public ConverterResponse convertToDeepLink(@Valid @RequestBody ToDeepLinkRequest request) {
        return this.converterService.convertToDeepLink(request);
    }

    /**
     * @param request contains DEEP LINK as String
     * @return Web Url as String
     */
    @PostMapping(value = "/convert_ to_web", produces = MediaType.APPLICATION_JSON_VALUE)
    public ConverterResponse convertToWebUrl(@Valid @RequestBody ToWebUrlRequest request) {
        return this.converterService.convertToWebUrl(request);
    }
}
