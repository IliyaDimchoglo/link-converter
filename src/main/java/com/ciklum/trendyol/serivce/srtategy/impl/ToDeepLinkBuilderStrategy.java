package com.ciklum.trendyol.serivce.srtategy.impl;

import com.ciklum.trendyol.domain.enums.LinkType;
import com.ciklum.trendyol.exception.ConverterException;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.manager.DeepLinkMapperManager;
import com.ciklum.trendyol.serivce.srtategy.LinkBuilderStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto.of;
import static com.ciklum.trendyol.exception.ExceptionMessageHelper.WEB_URL_EX_MESSAGE;
import static com.ciklum.trendyol.utils.Constants.HOMEPAGE_DEEPLINK;
import static com.ciklum.trendyol.utils.Constants.ToDeepLinkQueryParametersConstants.FIRST_LAYER_PARAMS;
import static com.ciklum.trendyol.utils.Constants.ToDeepLinkQueryParametersConstants.SECOND_LAYER_PARAMS;
import static com.ciklum.trendyol.utils.QueryParametersMapper.map;
import static java.util.Objects.nonNull;


@Slf4j
@Component
@RequiredArgsConstructor
public class ToDeepLinkBuilderStrategy implements LinkBuilderStrategy {

    private final DeepLinkMapperManager deepLinkMapperManager;

    /**
     * @param webUrl as String
     * @return deep link as String
     * @throws ConverterException if link can't be converted
     */
    @Override
    public String execute(String webUrl) {
        try {
            URL convertedUrl = new URL(webUrl);
            String longQuery = convertedUrl.getQuery();
            String path = convertedUrl.getPath();
            return buildLink(map(webUrl), longQuery, path);
        } catch (MalformedURLException e) {
            log.error(WEB_URL_EX_MESSAGE + "Web url: {}", webUrl);
            throw new ConverterException(WEB_URL_EX_MESSAGE);
        }
    }

    /**
     * Build deep link from web URL
     *
     * @param queryParams as HashMap
     * @param longQuery   as String
     * @param path        as String
     * @return deep link as String
     */
    private String buildLink(HashMap<String, String> queryParams, String longQuery, String path) {
        StringBuilder responseLink = new StringBuilder();

        FIRST_LAYER_PARAMS.stream()
                .filter(path::contains)
                .forEach(key ->
                        responseLink.append(deepLinkMapperManager.process(of(key, queryParams, longQuery, path))));

        SECOND_LAYER_PARAMS.stream()
                .filter(query -> nonNull(longQuery) && longQuery.contains(query))
                .forEach(key ->
                        responseLink.append(deepLinkMapperManager.process(of(key, queryParams, longQuery, path))));

        return responseLink.length() == 0 ? HOMEPAGE_DEEPLINK : responseLink.toString();
    }

    /**
     * @return LinkType as enum
     */
    @Override
    public LinkType getType() {
        return LinkType.DEEP_LINK;
    }
}
