package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.WebUrlMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.*;

/**
 * Campaign param strategy
 */
@Component
public class WebUrlCampaignStrategy implements WebUrlMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped campaign
     */
    @Override
    public String execute(WebUrlStrategyMapperDro dto) {
        String boutiqueId = dto.getQueryParams().get(CAMPAIGN_ID_PARAM_UPPER_SIMPLE);
        return QUESTION_MARK_PARAM.concat(BOUTIQUE_ID_PARAM).concat(boutiqueId);
    }
    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return CAMPAIGN_ID_PARAM_UPPER_SIMPLE;
    }
}
