package com.bootcamp.demo.demo_sb_customer.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_customer.dto.UserDTO;
import com.bootcamp.demo.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.bootcamp.demo.demo_sb_customer.service.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private UserDTOMapper userDTOMapper;

  @GetMapping(value = "/jsonplaceholder/users")
  public List<UserDTO> getUsers() {
    // List of UserDto -> List of UserDTO
    return this.userService.getUsers().stream() //
        .map(e -> userDTOMapper.map(e)) //
        .collect(Collectors.toList());
  }

  // @GetMapping(value = "/jsonplaceholder/users")
  // public List<UserDTO> getUsers() {
  // Generate all attributes info at List of UserDto
  // return this.userService.getUsers();
  // }

}
