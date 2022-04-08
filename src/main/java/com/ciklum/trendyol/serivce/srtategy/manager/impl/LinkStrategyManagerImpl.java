package com.ciklum.trendyol.serivce.srtategy.manager.impl;

import com.ciklum.trendyol.domain.enums.LinkType;
import com.ciklum.trendyol.serivce.srtategy.LinkBuilderStrategy;
import com.ciklum.trendyol.serivce.srtategy.manager.LinkStrategyManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Link strategy manager
 */
@Slf4j
@Component
public class LinkStrategyManagerImpl implements LinkStrategyManager {

    private final Map<LinkType, LinkBuilderStrategy> map;

    /**
     * Strategies initialization
     *
     * @param linkStrategies as list of LinkBuilderStrategy
     */
    public LinkStrategyManagerImpl(List<LinkBuilderStrategy> linkStrategies) {
        this.map = linkStrategies.stream().collect(toMap(LinkBuilderStrategy::getType, Function.identity()));
    }

    /***
     *  Choosing the right conversion strategy
     *
     * @param linkType  key used to search for the desired strategy as LinkType enum
     * @param link from request source as String
     * @return converted link as String
     */
    @Override
    public String processLink(LinkType linkType, String link) {
        return map.get(linkType).execute(link);
    }
}
