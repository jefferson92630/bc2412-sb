package com.bootcamp.bc.bc_forum.codewave;

public enum SysCode {
  OK("000000", "Success."),
  NOT_AVAIL("999998", "Json PlaceHolder API unavailable."),
  RTE_NPE("999997", "Database Connection Fail."),;

  private final String code;
  private final String message;
  private SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }
  public String getMessage() {
    return this.message;
  }
}
