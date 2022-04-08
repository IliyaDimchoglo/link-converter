package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl.DeepLinkMerchantStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.MERCHANT_ID_PARAM_LOWER_SIMPLE;
import static com.ciklum.trendyol.utils.Constants.MERCHANT_ID_PARAM_UPPER;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeepLinkMerchantStrategyTest {

    @InjectMocks
    private DeepLinkMerchantStrategy deepLinkMerchantStrategy;

    @Test
    public void executeTest() {
        String merchantId = "123123";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put(MERCHANT_ID_PARAM_LOWER_SIMPLE, merchantId);

        String merchant = deepLinkMerchantStrategy.execute(DeepLinkStrategyMapperDto.of(MERCHANT_ID_PARAM_LOWER_SIMPLE, queryParams));

        assertAll(
                () -> assertNotNull(merchant),
                () -> assertEquals(merchant, MERCHANT_ID_PARAM_UPPER.concat(merchantId))
        );
    }
}
