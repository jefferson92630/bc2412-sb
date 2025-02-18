package com.bootcamp.demo.bc_forum.codewave;

public enum SysCode {
  USER_NOT_FOUND("1", "User Not Found."),
  INVALID_INPUT("2", "Invalid Input."),
  REST_ERROR("3", "RestTemplate Error - Json Placeholder"),;

  private final String code;
  private final String message;
  private SysCode (String code, String message) {
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
