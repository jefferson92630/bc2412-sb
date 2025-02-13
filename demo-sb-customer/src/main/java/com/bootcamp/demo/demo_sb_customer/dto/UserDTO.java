package com.bootcamp.demo.demo_sb_customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// Features of DTO
// ! 1. Different numbers of fields for the API
// ! 2. Different field names
// This DTO is for serialization (Object -> JSON)
@Getter
@Builder
@AllArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;

@Getter
@Builder
@AllArgsConstructor
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Geo {
      @JsonProperty(value = "latitude")
      private String latitude;
      @JsonProperty(value = "longitude")
      private String longitude;
    }
  }
}
