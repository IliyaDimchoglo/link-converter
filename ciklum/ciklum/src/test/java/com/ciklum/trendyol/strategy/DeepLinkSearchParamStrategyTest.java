package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl.DeepLinkSearchParamStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeepLinkSearchParamStrategyTest {

    @InjectMocks
    private DeepLinkSearchParamStrategy deepLinkSearchParamStrategy;

    @Test
    public void executeTest() {
        String longQuery = "q=elbise";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put(Q_PARAM, longQuery);

        String search = deepLinkSearchParamStrategy.execute(DeepLinkStrategyMapperDto.of(S_PARAM, queryParams, longQuery));

        assertAll(
                () -> assertNotNull(search),
                () -> assertEquals(search, SEARCH_DEEPLINK.concat(longQuery.substring(2)))
        );
    }
}
