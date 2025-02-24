package com.bootcamp.bc.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.bc.bc_forum.dto.UserCommentDTO;
import com.bootcamp.bc.bc_forum.dto.UserDTO;

public interface UserOperation {
  @GetMapping(value = "/jph/users")
  List<UserDTO> getJPHUsers();

  @GetMapping(value = "/jph/comments")
  List<UserCommentDTO> getUserComments(@RequestParam String userId);
}
