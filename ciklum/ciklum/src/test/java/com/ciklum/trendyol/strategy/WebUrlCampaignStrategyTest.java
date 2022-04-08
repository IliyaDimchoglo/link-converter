package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl.WebUrlCampaignStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WebUrlCampaignStrategyTest {

    @InjectMocks
    private WebUrlCampaignStrategy webUrlCampaignStrategy;

    @Test
    public void executeTest() {
        HashMap<String, String> queryParams = new HashMap<>();
        String campaignId = "439892";
        queryParams.put(CAMPAIGN_ID_PARAM_UPPER_SIMPLE, campaignId);

        String campaign = webUrlCampaignStrategy.execute(WebUrlStrategyMapperDro.of(CAMPAIGN_ID_PARAM_UPPER_SIMPLE, queryParams));

        assertAll(
                () -> assertNotNull(campaign),
                () -> assertEquals(campaign,  QUESTION_MARK_PARAM.concat(BOUTIQUE_ID_PARAM).concat(campaignId))
        );
    }
}
