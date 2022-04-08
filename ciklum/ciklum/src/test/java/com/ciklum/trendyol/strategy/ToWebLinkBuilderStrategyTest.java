package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.manager.WebUrlMapperManager;
import com.ciklum.trendyol.serivce.srtategy.impl.ToWebLinkBuilderStrategy;
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
public class ToWebLinkBuilderStrategyTest {

    @Mock
    private WebUrlMapperManager webUrlMapperManager;

    @InjectMocks
    private ToWebLinkBuilderStrategy toWebLinkBuilderStrategy;

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
        when(webUrlMapperManager.process(any())).thenReturn(webUrlTest);

        String webUrl = toWebLinkBuilderStrategy.execute(deepLinkTest);

        assertAll(
                () -> assertNotNull(webUrl),
                () -> assertTrue(webUrl.contains(webUrlTest))
        );
    }

    @Test
    public void executeTurkishDeepLink() {
        when(webUrlMapperManager.process(any())).thenReturn(webUrlTurkishTest);

        String webUrl = toWebLinkBuilderStrategy.execute(deepLinkTurkishTest);

        assertAll(
                () -> assertNotNull(webUrl),
                () -> assertTrue(webUrl.contains(webUrlTurkishTest))
        );
    }
}
