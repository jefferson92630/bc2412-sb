package com.bootcamp.demo.bc_forum.dto.mapper;

import com.bootcamp.demo.bc_forum.dto.ForumDto;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum;

public class ForumDtoMapper {
    public ForumDto map(Forum forum) {
    
    ForumDto.Post.Comment forumPostComment = ForumDto.Post.Comment.builder()
      .name(forum.getPost().getComment().getName())
      .email(forum.getPost().getComment().getEmail())
      .body(forum.getPost().getComment().getBody())
      .build();

    ForumDto.Post forumPost = Forum.Post.builder().comment(forumPostComment)
      .build();
    
    return ForumDto.builder().id(forum.getId()).username(forum.getUsername())
     .post(forumPost)
     .build();
  }
}
