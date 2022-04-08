package com.ciklum.trendyol.exception.handler;

import com.ciklum.trendyol.dto.ExceptionMessageDto;
import com.ciklum.trendyol.exception.ConverterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 * Exception handler controller
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionControllerHandler {
    /***
     * Handler for converter exceptions
     * @param exception as ConverterException
     * @return ExceptionMessageDto contains response message as String
     */
    @ExceptionHandler(ConverterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageDto converterExceptionHandler(final ConverterException exception) {
        log.error(exception.getMessage() + "\n" + exception.getLocalizedMessage());
        return new ExceptionMessageDto(exception.getMessage());
    }

    /***
     * Handler for other exceptions
     * @param exception as Throwable
     * @return ExceptionMessageDto contains response message as String
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionMessageDto exceptionHandler(final Exception exception) {
        log.error(exception.getMessage() + "\n" + exception.getLocalizedMessage());
        return new ExceptionMessageDto(exception.getMessage());
    }
}
