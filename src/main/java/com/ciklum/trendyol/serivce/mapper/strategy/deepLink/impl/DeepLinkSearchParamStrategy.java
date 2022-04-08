package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.DeepLinkMapperStrategy;
import com.ciklum.trendyol.utils.Constants;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.Q_PARAM;
import static com.ciklum.trendyol.utils.Constants.SEARCH_DEEPLINK;

/**
 * Search param strategy
 */
@Component
public class DeepLinkSearchParamStrategy implements DeepLinkMapperStrategy {
    /**
     * @param dto with REQUIRED params
     * @return mapped SEARCH DEEPLINK
     */
    @Override
    public String execute(DeepLinkStrategyMapperDto dto) {
        String query = dto.getQueryParams().get(Q_PARAM);
        return !(dto.getLongQuery().substring(2)).equals(query) ?
                SEARCH_DEEPLINK.concat(dto.getLongQuery().substring(2))
                : SEARCH_DEEPLINK.concat(query);
    }

    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return Constants.S_PARAM;
    }
}
