package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import java.util.Map;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum.Post;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum.Post.Comment;

public interface ForumService {
  List<Forum> getPostsAndComments();
  List<Forum> getForums();
  List<Post> getPosts();
  List<Comment> getComments();
  Map<String, Object> userResponse(Long userId);
  List<Comment> getCommentsByUserId(Long userId);
  String getUserNameById(Long userId);
}
