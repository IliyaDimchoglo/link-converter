package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl.WebUrlMerchantStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WebUrlMerchantStrategyTest {

    @InjectMocks
    private WebUrlMerchantStrategy webUrlMerchantStrategy;

    @Test
    public void executeTest() {
        HashMap<String, String> queryParams = new HashMap<>();
        String merchantId = "123123";
        String longQuery = "longQuery";
        queryParams.put(MERCHANT_ID_PARAM_UPPER_SIMPLE, merchantId);

        String merchant = webUrlMerchantStrategy.execute(WebUrlStrategyMapperDro.of(MERCHANT_ID_PARAM_UPPER_SIMPLE, queryParams, longQuery, ""));

        assertAll(
                () -> assertNotNull(merchant),
                () -> assertEquals(merchant, QUESTION_MARK_PARAM.concat(MERCHANT_ID_PARAM_LOWER).concat(merchantId))
        );
    }
}
