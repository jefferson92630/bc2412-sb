package com.bootcamp.bc.bc_forum.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;
  private List<PostDTO> posts;

@Getter
@Builder
@AllArgsConstructor
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class GeoDTO {
      private Double lat;
      private Double lng;
    }
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  public static class PostDTO {
    private Long id;
    private String title;
    private String body;
    @JsonProperty(value = "comments")
    private List<CommentDTO> commentDtos;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CommentDTO {
      private Long id;
      private String name;
      private String email;
      private String body;
    }
  }
}
