package com.bootcamp.bc.bc_forum.service;

import java.util.List;
import com.bootcamp.bc.bc_forum.model.dto.CommentDto;
import com.bootcamp.bc.bc_forum.model.dto.PostDto;
import com.bootcamp.bc.bc_forum.model.dto.UserDto;

public interface ForumService {
  List<UserDto> getUsers();
  List<PostDto> getPosts();
  List<CommentDto> getComments();
}
