package com.ciklum.trendyol.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String HOMEPAGE_LINK = "trendyol.com";
    public static final String HTTPS_HOMEPAGE_LINK = "https://www.trendyol.com";
    public static final String SEARCH_LINK = "https://www.trendyol.com/sr?q=";
    public static final String PRODUCT_LINK = "https://www.trendyol.com/brand/name-p-";
    public static final String DEEP_LINK = "ty";
    public static final String HOMEPAGE_DEEPLINK = "ty://?Page=Home";
    public static final String SEARCH_DEEPLINK = "ty://?Page=Search&Query=";
    public static final String PRODUCT_DEEPLINK = "ty://?Page=Product&ContentId=";

    public static final String DASH_PARAM = "-";
    public static final String S_PARAM = "sr";
    public static final String Q_PARAM = "q";
    public static final String P_PARAM = "-p-";
    public static final String QUESTION_MARK_PARAM = "?";
    public static final String AND_PARAM = "&";
    public static final String PAGE_PARAM = "Page";
    public static final String SEARCH_PARAM = "Search";
    public static final String PRODUCT_PARAM = "Product";
    public static final String CONTENT_ID_PARAM = "ContentId";
    public static final String BOUTIQUE_ID_PARAM_SIMPLE = "boutiqueId";
    public static final String BOUTIQUE_ID_PARAM = "boutiqueId=";
    public static final String MERCHANT_ID_PARAM_LOWER_SIMPLE = "merchantId";
    public static final String MERCHANT_ID_PARAM_LOWER = "merchantId=";
    public static final String CAMPAIGN_ID_PARAM_UPPER = "&CampaignId=";
    public static final String CAMPAIGN_ID_PARAM_UPPER_SIMPLE = "CampaignId";
    public static final String MERCHANT_ID_PARAM_UPPER = "&MerchantId=";
    public static final String MERCHANT_ID_PARAM_UPPER_SIMPLE = "MerchantId";

    public static class ToDeepLinkQueryParametersConstants {
        public static List<String> FIRST_LAYER_PARAMS = Arrays.asList(P_PARAM, S_PARAM);
        public static List<String> SECOND_LAYER_PARAMS = Arrays.asList(BOUTIQUE_ID_PARAM_SIMPLE, MERCHANT_ID_PARAM_LOWER_SIMPLE);
    }

    public static class ToWebURlLinkQueryParametersConstants {
        public static List<String> FIRST_LAYER_PARAMS = Arrays.asList(PRODUCT_PARAM, SEARCH_PARAM);
        public static List<String> SECOND_LAYER_PARAMS = Arrays.asList(CAMPAIGN_ID_PARAM_UPPER_SIMPLE, MERCHANT_ID_PARAM_UPPER_SIMPLE);
    }
}
