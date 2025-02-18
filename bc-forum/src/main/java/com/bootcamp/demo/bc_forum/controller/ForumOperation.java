package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum;

public interface ForumOperation {

  @GetMapping(value = "/forum")
  List<Forum> getPostsAndComments();
  
  @GetMapping(value = "/comments")
  Map<String, Object> userResponse(@RequestParam Long userId);
  
}
