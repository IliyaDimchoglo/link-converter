package com.ciklum.trendyol.serivce.mapper.strategy.deepLink;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;

/**
 * Deep link mapper interface
 */
public interface DeepLinkMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped link as String
     */
    String execute(DeepLinkStrategyMapperDto dto);

    /**
     * @return Type of param as String
     */
    String getType();
}
