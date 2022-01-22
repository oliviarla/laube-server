package com.teamk.laube.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //컨트롤러 전역에서 발생할 수 있는 예외 catch -> throw
@Slf4j //자동으로 로그 객체 생성 -> log 메소드 사용 가능
public class GlobalExceptionHandler {
    /*
     * Developer Custom Exception
     */
    @ExceptionHandler(CustomException.class) //특정 클래스에서 발생할 수 있는 예외 catch -> throw
    protected ResponseEntity<ErrorResponse> handleCustomException(final CustomException e) { //CustomException 발생 시 실행되는 함수
        // ResponseEntity<Type>: HTTP request에 대한 응답 데이터를 포함하는 클래스, Type에 해당하는 데이터와 상태 코드 반환
        log.error("handleCustomException: {}", e.getErrorCode());
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(new ErrorResponse(e.getErrorCode()));
    }
    /*
     * HTTP 405 Exception
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException: {}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value())
                .body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
    }

    /*
     * HTTP 500 Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(final Exception e) {
        log.error("handleException: {}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
                .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
