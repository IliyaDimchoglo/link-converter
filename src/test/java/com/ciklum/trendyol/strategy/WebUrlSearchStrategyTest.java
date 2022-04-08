package com.ciklum.trendyol.strategy;

import com.ciklum.trendyol.dto.WebUrlStrategyMapperDro;
import com.ciklum.trendyol.serivce.mapper.strategy.webUrl.impl.WebUrlSearchStrategy;
import com.ciklum.trendyol.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WebUrlSearchStrategyTest {

    @InjectMocks
    private WebUrlSearchStrategy webUrlSearchStrategy;

    @Test
    public void executeTest(){
    String reqLink = "ty://?Page=Search&Query=elbise";
    String respLink = "https://www.trendyol.com/sr?q=elbise";
        String searchLink = webUrlSearchStrategy.execute(WebUrlStrategyMapperDro.of(Constants.SEARCH_PARAM, reqLink));

        assertAll(
                ()-> assertNotNull(searchLink),
                () -> assertEquals(respLink, searchLink)
        );
    }
}
