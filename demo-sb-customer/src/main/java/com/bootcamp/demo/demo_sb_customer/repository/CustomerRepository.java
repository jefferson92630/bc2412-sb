package com.bootcamp.demo.demo_sb_customer.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;

// JPA + Driver (Postgresql)
// ! Hiberate generates the implementation class, which implements "CustomerRepository"

@Repository // bean
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
  // ! During maven compilation, the implementation class is generated by Hiberate 
  // save()....etc


  // controller -> service -> 
  // how about return List? -> still ok. Will return empty list if not found
  // select * from customers where name = "John";
  List<CustomerEntity>findByName(String name);
  List<CustomerEntity>findByNameAndEmail(String name, String email);
}
