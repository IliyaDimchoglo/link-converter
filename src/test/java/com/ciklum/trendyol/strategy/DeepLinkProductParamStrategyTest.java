package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.DeepLinkStrategyMapperDto;
import com.ciklum.trendyol.serivce.mapper.strategy.deepLink.impl.DeepLinkProductParamStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ciklum.trendyol.utils.Constants.PRODUCT_DEEPLINK;
import static com.ciklum.trendyol.utils.Constants.P_PARAM;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeepLinkProductParamStrategyTest {

    @InjectMocks
    private DeepLinkProductParamStrategy deepLinkProductParamStrategy;

    @Test
    public void executeTest() {
        String productId = "1925865";
        String path = "https://www.trendyol.com/casio/mtp-1374d-2avdf-erkek-kol-saati-celik-p-" + productId;

        String product = deepLinkProductParamStrategy.execute(DeepLinkStrategyMapperDto.of(P_PARAM, path));

        assertAll(
                () -> assertNotNull(product),
                () -> assertEquals(product, (PRODUCT_DEEPLINK).concat(productId))
        );
    }
}
