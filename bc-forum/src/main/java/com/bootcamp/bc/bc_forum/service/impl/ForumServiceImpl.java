package com.bootcamp.bc.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc.bc_forum.entity.AddressEntity;
import com.bootcamp.bc.bc_forum.entity.CommentEntity;
import com.bootcamp.bc.bc_forum.entity.CompanyEntity;
import com.bootcamp.bc.bc_forum.entity.GeoEntity;
import com.bootcamp.bc.bc_forum.entity.PostEntity;
import com.bootcamp.bc.bc_forum.entity.UserEntity;
import com.bootcamp.bc.bc_forum.entity.mapper.EntityMapper;
import com.bootcamp.bc.bc_forum.lib.XUriBuilder;
import com.bootcamp.bc.bc_forum.model.dto.CommentDto;
import com.bootcamp.bc.bc_forum.model.dto.PostDto;
import com.bootcamp.bc.bc_forum.model.dto.UserDto;
import com.bootcamp.bc.bc_forum.repository.AddressRepository;
import com.bootcamp.bc.bc_forum.repository.CommentRepository;
import com.bootcamp.bc.bc_forum.repository.CompanyRepository;
import com.bootcamp.bc.bc_forum.repository.GeoRepository;
import com.bootcamp.bc.bc_forum.repository.PostRepository;
import com.bootcamp.bc.bc_forum.repository.UserRepository;
import com.bootcamp.bc.bc_forum.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private GeoRepository geoRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Value("${api.jph.host}")
  private String host;

  @Value("${api.jph.endpoints.users}")
  private String userEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentEndpoint;

  @Override
  public List<UserDto> getUsers() {
    String url = XUriBuilder.create() //
        .https() //
        .host(host) //
        .path(userEndpoint) //
        .build();

    List<UserDto> userDtos = 
      Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class));

      this.geoRepository.deleteAll();
      this.addressRepository.deleteAll();
      this.companyRepository.deleteAll();
      this.userRepository.deleteAll();
    
        userDtos.stream().forEach(e -> {
      UserEntity userEntity = this.userRepository.save(this.entityMapper.map(e));

      AddressEntity addressEntity = this.entityMapper.map(e.getAddress());
      addressEntity.setUserEntity(userEntity);
      this.addressRepository.save(addressEntity);

      CompanyEntity companyEntity = this.entityMapper.map(e.getCompany());
      companyEntity.setUserEntity(userEntity);
      this.companyRepository.save(companyEntity);

      GeoEntity geoEntity = this.entityMapper.map(e.getAddress().getGeo());
      geoEntity.setAddressEntity(addressEntity);
      this.geoRepository.save(geoEntity);
    });
    return userDtos;
  }

  @Override
  public List<PostDto> getPosts() {
    String url = XUriBuilder.create() //
        .https() //
        .host(host) //
        .path(postEndpoint) //
        .build();
    List<PostDto> postDtos = 
      Arrays.asList(this.restTemplate.getForObject(url, PostDto[].class));
    
    this.postRepository.deleteAll();

    postDtos.stream().forEach(e -> {
      PostEntity postEntity = this.postRepository.save(this.entityMapper.map(e));
      this.postRepository.save(postEntity);
    });
    return postDtos;
  }

  @Override
  public List<CommentDto> getComments() {
    String url = XUriBuilder.create() //
        .https() //
        .host(host) //
        .path(commentEndpoint) //
        .build();
    List<CommentDto> commentDtos =  
      Arrays.asList(this.restTemplate.getForObject(url, CommentDto[].class));
    
      this.commentRepository.deleteAll();

      commentDtos.stream().forEach(e -> {
        CommentEntity commentEntity = this.commentRepository.save(this.entityMapper.map(e));
        this.commentRepository.save(commentEntity);
      });
      return commentDtos;
  }
}
