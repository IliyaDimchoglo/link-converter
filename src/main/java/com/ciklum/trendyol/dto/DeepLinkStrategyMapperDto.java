package com.ciklum.trendyol.dto;

import lombok.*;

import java.util.HashMap;

/**
 * Dto layer for deep link strategy mapper
 */

@Builder
@Getter
public class DeepLinkStrategyMapperDto {

    private String key;
    private HashMap<String, String> queryParams;
    private String longQuery;
    private String path;

    public static DeepLinkStrategyMapperDto of(String key, HashMap<String, String> queryParams){
        return DeepLinkStrategyMapperDto.builder()
                .key(key)
                .queryParams(queryParams)
                .build();
    }
    public static DeepLinkStrategyMapperDto of(String key,HashMap<String, String> queryParams, String longQuery){
        return DeepLinkStrategyMapperDto.builder()
                .key(key)
                .queryParams(queryParams)
                .longQuery(longQuery)
                .build();
    }
    public static DeepLinkStrategyMapperDto of(String key,HashMap<String, String> queryParams, String longQuery, String path){
        return DeepLinkStrategyMapperDto.builder()
                .key(key)
                .path(path)
                .queryParams(queryParams)
                .longQuery(longQuery)
                .build();
    }

    public static DeepLinkStrategyMapperDto of(String key, String path){
        return DeepLinkStrategyMapperDto.builder()
                .key(key)
                .path(path)
                .build();
    }
}
