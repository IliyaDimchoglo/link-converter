package com.ciklum.trendyol.serivce;

import com.ciklum.trendyol.dto.ConverterResponse;
import com.ciklum.trendyol.dto.ToDeepLinkRequest;
import com.ciklum.trendyol.dto.ToWebUrlRequest;
import org.springframework.transaction.annotation.Transactional;

public interface ConverterService {
    /***
     *  Create deep link from web url
     *
     * @param request source dto from request
     * @return converted link
     */
    @Transactional
    ConverterResponse convertToDeepLink(ToDeepLinkRequest request);

    /***
     *  Create web url from deep link
     *
     * @param request source dto from request
     * @return converted link
     */
    @Transactional
    ConverterResponse convertToWebUrl(ToWebUrlRequest request);
}
