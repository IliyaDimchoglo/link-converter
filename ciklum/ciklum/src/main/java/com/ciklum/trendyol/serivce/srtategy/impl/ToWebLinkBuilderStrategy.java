package com.ciklum.trendyol.serivce.srtategy.impl;

import com.ciklum.trendyol.domain.enums.LinkType;
import com.ciklum.trendyol.exception.ConverterException;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.manager.WebUrlMapperManager;
import com.ciklum.trendyol.serivce.srtategy.LinkBuilderStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import static com.ciklum.trendyol.dto.WebUrlStrategyMapperDro.of;
import static com.ciklum.trendyol.exception.ExceptionMessageHelper.LINK_CONVERTED_EX_MESSAGE;
import static com.ciklum.trendyol.utils.Constants.HTTPS_HOMEPAGE_LINK;
import static com.ciklum.trendyol.utils.Constants.PAGE_PARAM;
import static com.ciklum.trendyol.utils.Constants.ToWebURlLinkQueryParametersConstants.FIRST_LAYER_PARAMS;
import static com.ciklum.trendyol.utils.Constants.ToWebURlLinkQueryParametersConstants.SECOND_LAYER_PARAMS;
import static com.ciklum.trendyol.utils.QueryParametersMapper.map;
import static java.util.Objects.nonNull;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToWebLinkBuilderStrategy implements LinkBuilderStrategy {

    private final WebUrlMapperManager webUrlMapperManager;

    /***
     * Build web URL from Deep Link
     *
     * @param deepLink as String
     * @return web URL as String
     * @throws ConverterException if link can't be converted
     */
    @Override
    public String execute(String deepLink) {
        try {
            URI convertedDeepLink = new URI(deepLink);
            String longQuery = convertedDeepLink.getQuery();
            return buildLink(map(convertedDeepLink.toString()), longQuery, deepLink);
        } catch (URISyntaxException e) {
            log.error(LINK_CONVERTED_EX_MESSAGE + "Deep link: {}", deepLink);
            throw new ConverterException(LINK_CONVERTED_EX_MESSAGE);
        }
    }

    /**
     * Build Web URL from deep link
     *
     * @param queryParams as HashMap
     * @param longQuery   as String
     * @param deepLink    as String
     * @return Web URl as String
     */
    private String buildLink(HashMap<String, String> queryParams, String longQuery, String deepLink) {
        StringBuilder responseLink = new StringBuilder();

        FIRST_LAYER_PARAMS.stream()
                .filter(key -> queryParams.get(PAGE_PARAM).equals(key))
                .forEach(key ->
                        responseLink.append(this.webUrlMapperManager.process(of(key, queryParams, longQuery, deepLink))));

        SECOND_LAYER_PARAMS.stream()
                .filter(key -> nonNull(longQuery) && longQuery.contains(key))
                .forEach(key ->
                        responseLink.append(this.webUrlMapperManager.process(of(key, queryParams, longQuery, deepLink))));

        return responseLink.length() == 0 ? HTTPS_HOMEPAGE_LINK : responseLink.toString();
    }

    /**
     * @return LinkType as enum
     */
    @Override
    public LinkType getType() {
        return LinkType.WEB_URL;
    }
}
