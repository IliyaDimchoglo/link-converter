package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.WebUrlMapperStrategy;
import org.springframework.stereotype.Component;

import static com.ciklum.trendyol.utils.Constants.*;

/**
 * Product param strategy
 */
@Component
public class WebUrlProductStrategy implements WebUrlMapperStrategy {

    /**
     * @param dto with REQUIRED params
     * @return mapped Product
     */
    @Override
    public String execute(WebUrlStrategyMapperDro dto) {
        return PRODUCT_LINK.concat(dto.getQueryParams().get(CONTENT_ID_PARAM));
    }
    /**
     * @return Type of param as String
     */
    @Override
    public String getType() {
        return PRODUCT_PARAM;
    }
}
