package com.bootcamp.demo.bc_forum.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
