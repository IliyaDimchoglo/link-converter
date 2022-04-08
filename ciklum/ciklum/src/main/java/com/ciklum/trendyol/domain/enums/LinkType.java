package com.ciklum.trendyol.domain.enums;

import com.ciklum.trendyol.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 *  Type of links enum
 */

@Getter
@AllArgsConstructor
public enum LinkType {

    DEEP_LINK(Constants.DEEP_LINK),
    WEB_URL(Constants.HOMEPAGE_LINK);

    private final String key;
}
