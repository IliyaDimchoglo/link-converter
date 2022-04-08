package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.WebUrlMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.*;

/**
 * Merchant param strategy
 */
@Component
public class WebUrlMerchantStrategy implements WebUrlMapperStrategy {
    /**
     * @param dto with REQUIRED params
     * @return mapped Merchant
     */
    @Override
    public String execute(WebUrlStrategyMapperDro dto) {
        String merchantId = dto.getQueryParams().get(MERCHANT_ID_PARAM_UPPER_SIMPLE);
        if (dto.getLongQuery().contains(CAMPAIGN_ID_PARAM_UPPER_SIMPLE) && dto.getLongQuery().contains(MERCHANT_ID_PARAM_UPPER_SIMPLE))
            return AND_PARAM.concat(QUESTION_MARK_PARAM.concat(MERCHANT_ID_PARAM_LOWER).concat(merchantId));
        else return QUESTION_MARK_PARAM.concat(MERCHANT_ID_PARAM_LOWER).concat(merchantId);
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return MERCHANT_ID_PARAM_UPPER_SIMPLE;
    }
}
