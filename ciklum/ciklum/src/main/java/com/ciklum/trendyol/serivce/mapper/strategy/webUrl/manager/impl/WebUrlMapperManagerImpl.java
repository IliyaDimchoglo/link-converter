package com.ciklum.trendyol.serivce.mapper.strategy.webUrl.manager.impl;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.WebUrlMapperStrategy;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.manager.WebUrlMapperManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Strategy control manager
 */

@Component
public class WebUrlMapperManagerImpl implements WebUrlMapperManager {

    private final Map<String, WebUrlMapperStrategy> map;

    /**
     *  Strategies initialization
     * @param strategies as list of WebUrlMapperStrategy
     */
    public WebUrlMapperManagerImpl(List<WebUrlMapperStrategy> strategies) {
        this.map = strategies.stream().collect(toMap(WebUrlMapperStrategy::getType, Function.identity()));
    }

    /**
     * Strategies router
     * @param dto contains required Params
     * @return link
     */
    @Override
    public String process(WebUrlStrategyMapperDro dto) {
        return map.get(dto.getKey()).execute(dto);
    }
}
