package com.bootcamp.demo.demo_sb_customer.codewave;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
  @ExceptionHandler(BusinessException.class)
  public ApiResp<Void> handleBusinessException(BusinessException e) {
    return ApiResp.<Void>builder()
    .syscode(e.getSysCode())
    .build();
  }

  @ExceptionHandler(NullPointerException.class)
  public ApiResp<Void> handleNullPointerException() {
    return ApiResp.<Void>builder() 
        .syscode(SysCode.RTE_NPE) 
        .build();
  }
}
