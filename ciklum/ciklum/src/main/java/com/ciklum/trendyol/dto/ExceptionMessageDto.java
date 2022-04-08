package com.ciklum.trendyol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exception response dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessageDto {

    private String message;
}
