package com.bootcamp.bc.bc_forum.model.dto;

import lombok.Getter;

@Getter
public class PostDto {
  private Long id;
  private Long userId;
  private String title;
  private String body;
}
