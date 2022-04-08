package com.ciklum.trendyol.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryParametersMapper {

    /**
     * @param url as String
     * @return query params as HashMap
     */
    public static HashMap<String, String> map(String url) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(url).build();
        return new HashMap<>(uriComponents.getQueryParams().toSingleValueMap());
    }
}
