package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.ForumOperation;
import com.bootcamp.demo.bc_forum.model.Forum;
import com.bootcamp.demo.bc_forum.service.ForumService;


@RestController
public class ForumOperationImpl implements ForumOperation {
  @Autowired
  private ForumService forumService;


  @Override
  public List<Forum> getPostsAndComments() {
    return this.forumService.getPostsAndComments();
  }

  @Override 
  public Map<String, Object> userResponse(Long userId) {
    return null;
 }

}

