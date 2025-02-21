package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.CommentDto;
import com.bootcamp.demo.bc_forum.model.PostDto;
import com.bootcamp.demo.bc_forum.model.UserDto;

public interface ForumService {
  List<UserDto> getUsers();
  List<PostDto> getPosts();
  List<CommentDto> getComments();

}