package com.ciklum.trendyol.serivce.impl;

import com.ciklum.trendyol.domain.enums.LinkType;
import com.ciklum.trendyol.dto.ConverterResponse;
import com.ciklum.trendyol.dto.ToDeepLinkRequest;
import com.ciklum.trendyol.dto.ToWebUrlRequest;
import com.ciklum.trendyol.serivce.ConverterService;
import com.ciklum.trendyol.serivce.db.ConverterDBService;
import com.ciklum.trendyol.serivce.mapper.LinkMapper;
import com.ciklum.trendyol.serivce.srtategy.manager.LinkStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.ciklum.trendyol.domain.enums.LinkType.DEEP_LINK;
import static com.ciklum.trendyol.domain.enums.LinkType.WEB_URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConverterServiceImpl implements ConverterService {

    private final LinkStrategyManager linkStrategyManager;
    private final ConverterDBService converterDBService;
    private final LinkMapper mapper;

    /***
     *  Create deep link from web url
     *
     * @param request source dto from request
     * @return converted link
     */
    @Override
    public ConverterResponse convertToDeepLink(ToDeepLinkRequest request) {
        String webUrl = request.getLink();
        log.info("[x] URL conversion  to deep link started. Req link: {}", request.getLink());
        ConverterResponse converterResponse = ConverterResponse.of(linkStrategyManager.processLink(DEEP_LINK, webUrl));
        this.saveAndLog(request.getLink(), converterResponse.getLink(), DEEP_LINK);
        log.info("[x] URL conversion  to deep link finished. Resp link: {}", converterResponse.getLink());
        return converterResponse;
    }

    /***
     *  Create web url from deep link
     *
     * @param request source dto from request
     * @return converted link
     */
    @Override
    public ConverterResponse convertToWebUrl(ToWebUrlRequest request) {
        String deepLink = request.getLink();
        log.info("[x] Deep link conversion  to web url started. Req link: {}", deepLink);
        ConverterResponse converterResponse = ConverterResponse.of(linkStrategyManager.processLink(WEB_URL, deepLink));
        this.saveAndLog(request.getLink(), converterResponse.getLink(), WEB_URL);
        log.info("[x] Deep Link conversion to web finished. Resp link: {}", converterResponse.getLink());
        return converterResponse;
    }

    /**
     * Save request/response links
     *
     * @param reqLink  as String
     * @param respLink as String
     * @param linkType as Enum
     */
    private void saveAndLog(String reqLink, String respLink, LinkType linkType) {
        try {
            converterDBService.save(mapper.toEntity(reqLink, respLink, linkType));
            log.info("[x] Converted link was saved successfully.");
        } catch (Exception e) {
            log.error("[x] Failed to save. ReqLink {}, Ex message {}", reqLink, e.getMessage());
        }
    }
}
