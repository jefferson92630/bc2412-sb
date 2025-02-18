package com.bootcamp.demo.bc_forum.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ForumDto {
  private Long id;
  private String username;
  private Post post;

  @Getter
  @Setter
  @Builder
  public static class Post {
    private Comment comment;

    @Getter
    @Setter
    @Builder
    public static class Comment {
      private String name;
      private String email;
      private String body;
    }
  }
}
