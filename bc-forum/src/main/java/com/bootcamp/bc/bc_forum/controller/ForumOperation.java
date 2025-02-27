package com.bootcamp.bc.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.bc.bc_forum.codewave.ApiResp;
import com.bootcamp.bc.bc_forum.dto.UserCommentDTO;
import com.bootcamp.bc.bc_forum.dto.UserDTO;
import com.bootcamp.bc.bc_forum.entity.UserEntity;

public interface ForumOperation {
  @GetMapping(value = "/users")
  List<UserDTO> getForumUsers();

  @GetMapping(value = "/comments")
  List<UserCommentDTO> getCommentsByUserId(@RequestParam String userId);

  @GetMapping(value = "/db/users")
  ApiResp<UserEntity> getAllUsersFromDb(@RequestBody UserEntity userEntity);
}
