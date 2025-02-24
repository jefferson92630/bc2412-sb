package com.bootcamp.bc.bc_forum.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDto {
  private Long userId;
  private Long id;
  private String title;
  private String body;

}