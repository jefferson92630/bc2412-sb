package com.bootcamp.demo.bc_forum.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.service.ForumService;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum.Post;
import com.bootcamp.demo.bc_forum.service.impl.model.Forum.Post.Comment;

@Service
public class ForumServiceImpl implements ForumService {
  @Autowired
  private RestTemplate restTemplate;

  
  @Override
  public List<Forum> getPostsAndComments() {
    List<Forum> forums = getForums();
    List<Post> posts = getPosts();
    List<Comment> comments = getComments();

    Map<Long, List<Post>> postsByUserId = posts.stream().collect(Collectors.groupingBy(post -> post.getUserId()));
    Map<Long, List<Comment>> commentsByPostId = comments.stream().collect(Collectors.groupingBy(comment -> comment.getPostId()));

    forums.forEach(forum -> {
      List<Post> userPosts = postsByUserId.get(forum.getId());
      if (userPosts != null) {
          userPosts.forEach(post -> {
              List<Comment> postComments = commentsByPostId.get(post.getId());
              post.setComment(postComments != null ? postComments : List.of());
          });
          forum.setPost(userPosts);
      } else {
          forum.setPost(List.of()); // Set an empty list if no posts
      }
  });
  return forums;
}

  @Override
  public Map<String, Object> userResponse(Long userId) {
    List<Comment> userComments = getCommentsByUserId(userId);
    String username = getUserNameById(userId);

    Map<String, Object> response = new HashMap<>();
    response.put("id", userId);
    response.put("username", username);
    response.put("comments", userComments);

    return response;
  } 

  @Override
  public List<Comment> getCommentsByUserId(Long userId) {
    List<Comment> allComments = getComments();
    List<Post> allPosts = getPosts();

     return allPosts.stream().filter(post -> post.getUserId() == userId)
    .flatMap(post -> allComments.stream().filter(comment -> comment.getPostId() == (post.getId())))
    .collect(Collectors.toList());
    
  }

  @Override
  public String getUserNameById(Long userId) {
    return getForums().stream().filter(forum -> forum.getId().equals(userId))
      .map(forum -> forum.getUsername()).findFirst().orElse("Unknown User");
  }


  @Override
  public List<Forum> getForums() {
   String url = "https://jsonplaceholder.typicode.com/users";
  return Arrays.asList(this.restTemplate.getForObject(url, Forum[].class));
  }

  @Override
  public List<Post> getPosts() {
   String url = "https://jsonplaceholder.typicode.com/posts";
  return Arrays.asList(this.restTemplate.getForObject(url, Post[].class));
  }

  @Override
  public List<Comment> getComments() {
   String url = "https://jsonplaceholder.typicode.com/comments";
  return Arrays.asList(this.restTemplate.getForObject(url, Comment[].class));
  }
}
