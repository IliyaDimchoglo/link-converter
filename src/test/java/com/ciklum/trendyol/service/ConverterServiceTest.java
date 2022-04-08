package com.ciklum.trendyol.service;

import com.ciklum.trendyol.domain.LinkConverterEntity;
import com.ciklum.trendyol.domain.enums.LinkType;
import com.ciklum.trendyol.dto.ConverterResponse;
import com.ciklum.trendyol.dto.ToDeepLinkRequest;
import com.ciklum.trendyol.dto.ToWebUrlRequest;
import com.ciklum.trendyol.serivce.db.ConverterDBService;
import com.ciklum.trendyol.serivce.impl.ConverterServiceImpl;
import com.ciklum.trendyol.serivce.mapper.LinkMapper;
import com.ciklum.trendyol.serivce.srtategy.manager.LinkStrategyManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConverterServiceTest {

    @Mock
    private LinkStrategyManager linkStrategyManager;

    @Mock
    private ConverterDBService converterDBService;

    @Mock
    private LinkMapper mapperl;

    @InjectMocks
    private ConverterServiceImpl converterService;

    @Test
    void toDeepLinkTest() {
        convertToDeepLinkTest("https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064",
                "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");
    }

    @Test
    void toWebURL() {
        convertToWebLinkTest("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064",
                "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064");
    }

    @Test
    void testTurkishCharactersToWebUrl() {
        convertToWebLinkTest("ty://?Page=Product&ContentId=ÜRÜNÜN&CampaignId=DİĞER&MerchantId=SATICILARI",
                "https://www.trendyol.com/brand/name-p-ÜRÜNÜN?boutiqueId=DİĞER&merchantId=SATICILARI");
    }

    private void convertToDeepLinkTest(String webLink, String deepLink) {
        when(converterDBService.save(any())).thenReturn(new LinkConverterEntity());
        when(mapperl.toEntity(anyString(), anyString(), any())).thenReturn(new LinkConverterEntity());
        when(linkStrategyManager.processLink(LinkType.DEEP_LINK, webLink)).thenReturn(deepLink);

        ConverterResponse converterResponse = converterService.convertToDeepLink(new ToDeepLinkRequest(webLink));

        assertAll(
                () -> assertNotNull(converterResponse),
                () -> assertEquals(deepLink, converterResponse.getLink())
        );
    }

    private void convertToWebLinkTest(String deepLink, String webLink) {
        when(converterDBService.save(any())).thenReturn(new LinkConverterEntity());
        when(mapperl.toEntity(anyString(), anyString(), any())).thenReturn(new LinkConverterEntity());
        when(linkStrategyManager.processLink(LinkType.WEB_URL, deepLink)).thenReturn(webLink);

        ConverterResponse converterResponse = converterService.convertToWebUrl(new ToWebUrlRequest(deepLink));

        assertAll(
                () -> assertNotNull(converterResponse),
                () -> assertEquals(webLink, converterResponse.getLink())
        );
    }
}
