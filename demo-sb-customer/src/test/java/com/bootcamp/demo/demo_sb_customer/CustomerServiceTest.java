package com.bootcamp.demo.demo_sb_customer;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.demo.demo_sb_customer.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {
  @Autowired
  private CustomerService customerService;

  @MockBean
  private CustomerRepository customerRepository;


  @Test
  void testGetAllCustomers() {
       CustomerEntity customerEntity1 = CustomerEntity.builder()
        .email("john@gmail.com").name("john").id(1L).build();
    CustomerEntity customerEntity2 = CustomerEntity.builder()
        .email("mary@gmail.com").name("mary").id(2L).build();
    List<CustomerEntity> dbResult =
        Arrays.asList(customerEntity1, customerEntity2);

    Mockito.when(customerRepository.findAll()).thenReturn(dbResult);

    // test
    List<CustomerEntity> customerEntities = customerService.getCustomers();

    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder( //
      Matchers.hasProperty("name", Matchers.equalTo("John")), //
      Matchers.hasProperty("name", Matchers.equalTo("Mary"))
    ));
    
    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder( //
      Matchers.hasProperty("id", Matchers.equalTo(1L)), //
      Matchers.hasProperty("id", Matchers.equalTo(2L))
  ));
  
 }

}
