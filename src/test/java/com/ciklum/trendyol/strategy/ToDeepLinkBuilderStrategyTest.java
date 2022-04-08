package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.manager.DeepLinkMapperManager;
import com.ciklum.trendyol.serivce.srtategy.impl.ToDeepLinkBuilderStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDeepLinkBuilderStrategyTest {

    @Mock
    private DeepLinkMapperManager deepLinkMapperManager;

    @InjectMocks
    private ToDeepLinkBuilderStrategy toDeepLinkBuilderStrategy;
    private String webUrlTest;
    private String deepLinkTest;
    private String deepLinkTurkishTest;
    private String webUrlTurkishTest;

    @BeforeEach
    void setUp() {
        webUrlTest = "https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064";
        deepLinkTest = "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";
        deepLinkTurkishTest = "ty://?Page=Product&ContentId=ÜRÜNÜN&CampaignId=DİĞER&MerchantId=SATICILARI";
        webUrlTurkishTest = "https://www.trendyol.com/brand/name-p-ÜRÜNÜN?boutiqueId=DİĞER&merchantId=SATICILARI";
    }

    @Test
    public void executeDeepLinkTest() {
        when(deepLinkMapperManager.process(any())).thenReturn(deepLinkTest);

        String deepLink = toDeepLinkBuilderStrategy.execute(webUrlTest);

        assertAll(
                () -> assertNotNull(deepLink),
                () -> assertTrue(deepLink.contains(deepLinkTest))
        );
    }

    @Test
    public void executeTurkishDeepLink() {
        when(deepLinkMapperManager.process(any())).thenReturn(deepLinkTurkishTest);

        String deepLink = toDeepLinkBuilderStrategy.execute(webUrlTurkishTest);

        assertAll(
                () -> assertNotNull(deepLink),
                () -> assertTrue(deepLink.contains(deepLinkTurkishTest))
        );
    }
}
