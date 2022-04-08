package com.ciklum.trendyol.serivce.srtategy;

import com.ciklum.trendyol.domain.enums.LinkType;

public interface LinkBuilderStrategy {

    /**
     * @param link as String
     * @return response link as String
     */
    String execute(String link);

    /**
     * @return LinkType as enum
     */
    LinkType getType();
}
