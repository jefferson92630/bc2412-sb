package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.ForumOperation;
import com.bootcamp.demo.bc_forum.dto.UserCommentDTO;
import com.bootcamp.demo.bc_forum.dto.UserDTO;
import com.bootcamp.demo.bc_forum.dto.UserDTO.PostDTO;
import com.bootcamp.demo.bc_forum.dto.UserDTO.PostDTO.CommentDTO;
import com.bootcamp.demo.bc_forum.exception.UserNotFoundException;
import com.bootcamp.demo.bc_forum.model.CommentDto;
import com.bootcamp.demo.bc_forum.model.PostDto;
import com.bootcamp.demo.bc_forum.model.UserDto;
import com.bootcamp.demo.bc_forum.service.ForumService;

@RestController
public class ForumOperationImpl implements ForumOperation {

  @Autowired
  private ForumService forumService;
  
  @Override
  public List<UserDTO> getForumUsers() {
    List<UserDto> userDtos = this.forumService.getUsers();
    List<PostDto> postDtos = this.forumService.getPosts();
    List<CommentDto> commentDtos = this.forumService.getComments();

    return userDtos.stream().map(u -> {
      List<PostDTO> postDTOs = postDtos.stream().filter(p -> p.getUserId() == u.getId()).map(p -> {
        List<CommentDTO> commentDTOs = commentDtos.stream().filter(c -> c.getPostId() == p.getId())
        .map(c -> new CommentDTO(c.getId(), c.getName(), c.getBody(), c.getEmail()))
        .collect(Collectors.toList());
        
        return PostDTO.builder().id(p.getId()).title(p.getTitle())
        .body(p.getBody()).commentDtos(commentDTOs).build();
      }).collect((Collectors.toList()));

        UserDTO.AddressDTO.GeoDTO geoDTO = UserDTO.AddressDTO.GeoDTO.builder()
        .lat(u.getAddress().getGeo().getLat())
        .lng(u.getAddress().getGeo().getLng()).build();

        UserDTO.AddressDTO addressDTO = UserDTO.AddressDTO.builder()
        .street(u.getAddress().getStreet()).suite(u.getAddress().getSuite())
        .city(u.getAddress().getCity()).zipcode(u.getAddress().getZipcode())
        .geo(geoDTO).build();

        UserDTO.CompanyDTO companyDTO = UserDTO.CompanyDTO.builder()
        .name(u.getCompany().getName()).catchPhrase(u.getCompany().getCatchPhrase())
        .bs(u.getCompany().getBs())
        .build();

        return UserDTO.builder().id(u.getId()).name(u.getName()).username(u.getUsername())
          .email(u.getEmail()).address(addressDTO).phone(u.getPhone()).website(u.getWebsite())
          .company(companyDTO).posts(postDTOs)
          .build();
      }).collect(Collectors.toList());
  
    }

    @Override
    public List<UserCommentDTO> getCommentsByUserId(String userId) {
      Long uid = Long.valueOf(userId);
      List<UserDto> userDtos = this.forumService.getUsers();

      // Check if user exists
      userDtos.stream()
      .filter((u -> u.getId() == uid))
      .findAny()
      .orElseThrow(() -> new UserNotFoundException());

      List<PostDto> postDtos = this.forumService.getPosts();
      List<CommentDto> commentDtos = this.forumService.getComments();

      List<UserCommentDTO.CommentDTO> commentDTOs =  new ArrayList<>();

      for (PostDto postDto : postDtos) {
        if (postDto.getUserId() == uid) {
          for (CommentDto commentDto : commentDtos) {
            if (commentDto.getPostId() == postDto.getId()) {
              commentDTOs.add(new UserCommentDTO.CommentDTO(commentDto.getName(), 
                commentDto.getBody(), commentDto.getEmail()));
            }
          }
        }
      }
      return userDtos.stream()
      .filter(u -> u.getId() == uid)
      .map(u -> new UserCommentDTO(u.getId(), u.getUsername(), commentDTOs))
      .collect(Collectors.toList());
    }

  }

