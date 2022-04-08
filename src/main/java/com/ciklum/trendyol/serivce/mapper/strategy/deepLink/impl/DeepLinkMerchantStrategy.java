package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.DeepLinkMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.MERCHANT_ID_PARAM_LOWER_SIMPLE;
import static com.ciklum.trendyol.utils.Constants.MERCHANT_ID_PARAM_UPPER;

/**
 * Merchant param strategy
 */
@Component
public class DeepLinkMerchantStrategy implements DeepLinkMapperStrategy {
    /**
     * @param dto with REQUIRED params
     * @return mapped MERCHANT_ID
     */
    @Override
    public String execute(DeepLinkStrategyMapperDto dto) {
        String merchantId = dto.getQueryParams().get(MERCHANT_ID_PARAM_LOWER_SIMPLE);
        return MERCHANT_ID_PARAM_UPPER.concat(merchantId);
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return MERCHANT_ID_PARAM_LOWER_SIMPLE;
    }
}
