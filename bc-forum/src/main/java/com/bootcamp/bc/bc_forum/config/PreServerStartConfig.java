package com.bootcamp.bc.bc_forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.bc.bc_forum.service.ForumService;

@Component
public class PreServerStartConfig implements CommandLineRunner {

  @Autowired
  private ForumService forumService;

@Override
  public void run(String... args) throws Exception {
    this.forumService.getUsers();
    this.forumService.getPosts();
    this.forumService.getComments();
  }
}
