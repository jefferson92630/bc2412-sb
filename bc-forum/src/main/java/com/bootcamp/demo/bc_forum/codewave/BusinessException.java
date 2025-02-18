package com.bootcamp.demo.bc_forum.codewave;

public class BusinessException extends RuntimeException {
  private SysCode sysCode;

  public static BusinessException of(SysCode sysCode) {
    return new BusinessException(sysCode);
  }

  private BusinessException(SysCode sysCode) {
    super(sysCode.getMessage());
    this.sysCode = sysCode;
  }

  public SysCode getSysCode() {
    return this.sysCode;
  }
}
