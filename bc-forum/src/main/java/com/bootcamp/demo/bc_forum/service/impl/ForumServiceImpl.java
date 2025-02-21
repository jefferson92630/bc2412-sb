package com.bootcamp.demo.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.lib.XUriBuilder;
import com.bootcamp.demo.bc_forum.model.CommentDto;
import com.bootcamp.demo.bc_forum.model.PostDto;
import com.bootcamp.demo.bc_forum.model.UserDto;
import com.bootcamp.demo.bc_forum.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.jph.host}")
  private String host;

  @Value("${api.jph.endpoint.users}")
  private String userEndpoint;

  @Value("${api.jph.endpoint.posts}")
  private String postEndpoint;

  @Value("${api.jph.endpoint.comments}")
  private String commentEndpoint;

  @Override
  public List<UserDto> getUsers() {
    String url = XUriBuilder.create()
    .https() 
    .host(host) 
    .path(userEndpoint) 
    .build();
  return Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class));
  }

  @Override
  public List<PostDto> getPosts() {
    String url = XUriBuilder.create() 
    .https() 
    .host(host) 
    .path(postEndpoint) 
    .build();
  return Arrays.asList(this.restTemplate.getForObject(url, PostDto[].class));
  }

  @Override
  public List<CommentDto> getComments() {
    String url = XUriBuilder.create() 
    .https() 
    .host(host) 
    .path(commentEndpoint) 
    .build();
  return Arrays.asList(this.restTemplate.getForObject(url, CommentDto[].class));
  }
}
