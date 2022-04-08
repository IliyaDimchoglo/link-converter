package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.WebUrlMapperStrategy;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.SEARCH_LINK;
import static com.ciklum.trendyol.utils.Constants.SEARCH_PARAM;

/**
 * Search param strategy
 */
@Component
public class WebUrlSearchStrategy implements WebUrlMapperStrategy {

    private static final String SEPARATOR = "Query=";

    /**
     * @param dto with REQUIRED params
     * @return mapped Search
     */
    @Override
    public String execute(WebUrlStrategyMapperDro dto) {
        return SEARCH_LINK.concat(StringUtils.substringAfter(dto.getLink(), SEPARATOR));
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return SEARCH_PARAM;
    }
}
