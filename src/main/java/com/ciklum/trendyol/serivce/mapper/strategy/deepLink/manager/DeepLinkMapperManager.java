package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.manager;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;

/**
 * Strategy control manager
 */
public interface DeepLinkMapperManager {
    /**
     * Strategies router
     *
     * @param dto required Params
     * @return link
     */
    String process(DeepLinkStrategyMapperDto dto);

}
