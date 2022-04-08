package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl.DeepLinkBoutiqueStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.BOUTIQUE_ID_PARAM_SIMPLE;
import static com.ciklum.trendyol.utils.Constants.CAMPAIGN_ID_PARAM_UPPER;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeepLinkBoutiqueStrategyTest {

    @InjectMocks
    private DeepLinkBoutiqueStrategy deepLinkBoutiqueStrategy;

    @Test
    public void executeTest() {
        String boutiqueId = "12312";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put(BOUTIQUE_ID_PARAM_SIMPLE, boutiqueId);

        String boutiqueResp = deepLinkBoutiqueStrategy.execute(DeepLinkStrategyMapperDto.of(BOUTIQUE_ID_PARAM_SIMPLE, queryParams));

        assertAll(
                () -> assertNotNull(boutiqueResp),
                ()->assertEquals(boutiqueResp, CAMPAIGN_ID_PARAM_UPPER.concat(boutiqueId))
        );
    }
}
