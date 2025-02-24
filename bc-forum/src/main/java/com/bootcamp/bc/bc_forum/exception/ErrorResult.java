package com.bootcamp.bc.bc_forum.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResult {
  private Long code;
  private String message;
}
