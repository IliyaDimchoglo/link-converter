package com.ciklum.trendyol.serivce.mapper.strategy.webUrl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;

/**
 *  Web Url mapper abstract strategy
 */
public interface WebUrlMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped link as String
     */
    String execute(WebUrlStrategyMapperDro dto);

    /**
     * @return Type of param as String
     */
    String getType();
}
