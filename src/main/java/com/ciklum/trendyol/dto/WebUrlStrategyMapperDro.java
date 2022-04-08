package com.ciklum.trendyol.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;

/**
 * Dto layer for Web URL strategy mapper
 */
@Builder
@Getter
public class WebUrlStrategyMapperDro {

    private String key;
    private String link;
    private String longQuery;
    private HashMap<String, String> queryParams;

    public static WebUrlStrategyMapperDro of(String key, HashMap<String, String> queryParams, String longQuery, String link) {
        return WebUrlStrategyMapperDro.builder()
                .key(key)
                .longQuery(longQuery)
                .queryParams(queryParams)
                .link(link)
                .build();
    }

    public static WebUrlStrategyMapperDro of(String key, String link) {
        return WebUrlStrategyMapperDro.builder()
                .key(key)
                .link(link)
                .build();
    }

    public static WebUrlStrategyMapperDro of(String key, HashMap<String, String> queryParams) {
        return WebUrlStrategyMapperDro.builder()
                .key(key)
                .queryParams(queryParams)
                .build();
    }
}
