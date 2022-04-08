package com.ciklum.trendyol.serivce.srtategy.manager;

import com.ciklum.trendyol.domain.enums.LinkType;

/**
 * Link strategy manager
 */
public interface LinkStrategyManager {

    /**
     * @param linkType as enum
     * @param link     as String
     * @return converted Link as String
     */
    String processLink(LinkType linkType, String link);
}
