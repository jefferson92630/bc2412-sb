package com.bootcamp.demo.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.demo.demo_sb_customer.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
  @MockBean
  private UserRepository userRepository;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void TestGetAllUsers() throws Exception {

  }
}
