package com.ciklum.trendyol.dto;

import lombok.Value;

/**
 *Converter response ( contains link as String)
 */

@Value(staticConstructor = "of")
public class ConverterResponse {

     String link;
}
