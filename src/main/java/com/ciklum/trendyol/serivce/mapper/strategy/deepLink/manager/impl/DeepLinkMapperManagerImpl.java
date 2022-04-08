package com.ciklum.trendyol.serivce.mapper.strategy.deepLink.manager.impl;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.DeepLinkMapperStrategy;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.manager.DeepLinkMapperManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Strategy control manager
 */
@Component
public class DeepLinkMapperManagerImpl implements DeepLinkMapperManager {

    private final Map<String, DeepLinkMapperStrategy> map;

    /**
     * Strategies initialization
     *
     * @param strategies as list of DeepLinkMapperStrategy
     */
    public DeepLinkMapperManagerImpl(List<DeepLinkMapperStrategy> strategies) {
        this.map = strategies.stream().collect(toMap(DeepLinkMapperStrategy::getType, Function.identity()));
    }

    /**
     * Strategies router
     *
     * @param dto contains required Params
     * @return link
     */
    @Override
    public String process(DeepLinkStrategyMapperDto dto) {
        return map.get(dto.getKey()).execute(dto);
    }
}
