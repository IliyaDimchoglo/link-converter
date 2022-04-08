package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl.WebUrlProductStrategy;
import com.ciklum.trendyol.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static com.ciklum.trendyol.utils.Constants.CONTENT_ID_PARAM;
import static com.ciklum.trendyol.utils.Constants.PRODUCT_LINK;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WebUrlProductStrategyTest {

    @InjectMocks
    private WebUrlProductStrategy webUrlProductStrategy;

    @Test
    public void executeTest() {
        String productId = "1321123";
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put(CONTENT_ID_PARAM, productId);

        String product = webUrlProductStrategy.execute(WebUrlStrategyMapperDro.of(Constants.PRODUCT_PARAM, queryParams));

        assertAll(
                () -> assertNotNull(product),
                () -> assertEquals(product, PRODUCT_LINK.concat(queryParams.get(CONTENT_ID_PARAM)))
        );
    }
}
