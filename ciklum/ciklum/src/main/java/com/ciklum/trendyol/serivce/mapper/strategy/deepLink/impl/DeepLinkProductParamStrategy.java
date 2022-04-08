package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.DeepLinkMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.*;

/**
 * Product param strategy
 */
@Component
public class DeepLinkProductParamStrategy implements DeepLinkMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped PRODUCT DEEPLINK
     */
    @Override
    public String execute(DeepLinkStrategyMapperDto dto) {
        String productId = dto.getPath().substring(dto.getPath().lastIndexOf(DASH_PARAM) + 1);
        return (PRODUCT_DEEPLINK).concat(productId);
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return P_PARAM;
    }
}
