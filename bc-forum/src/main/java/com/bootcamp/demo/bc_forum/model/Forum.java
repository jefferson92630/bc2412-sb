package com.bootcamp.demo.bc_forum.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Forum {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  private List<Post> posts;

@Getter
@Builder
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @Builder
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Builder
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Getter
  @Setter
  @Builder
  public static class Post {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;
    private Long id;
    private String title;
    private String body;
    private List<Comment> comments;

    @Getter
    @Setter
    @Builder
    public static class Comment {
      @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
      private Long postId;
      private Long id;
      private String name;
      private String email;
      private String body;
    }
  }
}
