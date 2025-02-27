package com.bootcamp.bc.bc_forum.codewave;

import java.sql.SQLNonTransientConnectionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ApiResp<Void> handleBusinessException(BusinessException e) {
    return ApiResp.<Void>builder() //
        .syscode(e.getSysCode()) //
        .build();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ApiResp<Void> handleApiException() {
    return ApiResp.<Void>builder() //
        .syscode(SysCode.NOT_AVAIL) //
        .build();
  }

  @ExceptionHandler(SQLNonTransientConnectionException.class)
  public ApiResp<Void> failedConnectDbException() {
    return ApiResp.<Void>builder() //
        .syscode(SysCode.NOT_AVAIL) //
        .build();
  }
}
