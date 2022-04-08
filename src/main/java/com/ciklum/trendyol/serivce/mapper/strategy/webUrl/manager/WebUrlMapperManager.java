package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.manager;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;

/**
 * Strategy control manager
 */
public interface WebUrlMapperManager {
    /**
     * Strategies router
     * @param dto required Params
     * @return link
     */
    String process(WebUrlStrategyMapperDro dto);

}
