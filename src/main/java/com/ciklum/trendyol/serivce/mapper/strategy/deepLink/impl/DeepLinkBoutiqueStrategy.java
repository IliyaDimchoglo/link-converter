package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.DeepLinkMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.BOUTIQUE_ID_PARAM_SIMPLE;
import static com.ciklum.trendyol.utils.Constants.CAMPAIGN_ID_PARAM_UPPER;

/**
 * Boutique param strategy
 */
@Component
public class DeepLinkBoutiqueStrategy implements DeepLinkMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped BOUTIQUE_ID
     */
    @Override
    public String execute(DeepLinkStrategyMapperDto dto) {
        String boutiqueId = dto.getQueryParams().get(BOUTIQUE_ID_PARAM_SIMPLE);
        return CAMPAIGN_ID_PARAM_UPPER.concat(boutiqueId);
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return BOUTIQUE_ID_PARAM_SIMPLE;
    }
}
