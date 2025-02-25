package com.bootcamp.bc.bc_forum.entity.mapper;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;
import com.bootcamp.bc.bc_forum.entity.AddressEntity;
import com.bootcamp.bc.bc_forum.entity.CommentEntity;
import com.bootcamp.bc.bc_forum.entity.CompanyEntity;
import com.bootcamp.bc.bc_forum.entity.GeoEntity;
import com.bootcamp.bc.bc_forum.entity.PostEntity;
import com.bootcamp.bc.bc_forum.entity.UserEntity;
import com.bootcamp.bc.bc_forum.model.dto.CommentDto;
import com.bootcamp.bc.bc_forum.model.dto.PostDto;
import com.bootcamp.bc.bc_forum.model.dto.UserDto;

@Component
public class EntityMapper {
  
  public UserEntity map(UserDto dto) {
    return UserEntity.builder()
    .name(dto.getName()).username(dto.getUsername())
    .email(dto.getEmail()).phone(dto.getPhone())
    .website(dto.getWebsite()).build();
  }

  public CompanyEntity map(UserDto.Company company) {
    return CompanyEntity.builder().name(company.getName())
    .bs(company.getBs()).catchPhrase(company.getCatchPhrase())
    .build();
  }

  public AddressEntity map(UserDto.Address address) {
    return AddressEntity.builder().city(address.getCity())
    .street(address.getStreet()).suite(address.getSuite())
    .zipcode(address.getZipcode()).build();
  }

  public GeoEntity map(UserDto.Address.Geo geo) {
    return GeoEntity.builder().lat(geo.getLat())
    .lng(geo.getLng()).build();
  }

  public PostEntity map(PostDto post) {
    return PostEntity.builder().userId(post.getUserId())
    .title(post.getTitle()).body(post.getBody())
    .build();
  }

  public CommentEntity map(CommentDto comment) {
    return CommentEntity.builder().postId(comment.getPostId())
    .name(comment.getName()).email(comment.getEmail())
    .body(comment.getBody()).build();
  }
}
