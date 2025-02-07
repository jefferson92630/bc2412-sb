package com.bootcamp.demo.demo_sb_restful.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.model.CatDatabase;

// Person.class -> name -> setName() -> getNmae()

@Service //Bean
public class CatService {
// stateless

  public boolean put(Cat cat) {
    for (int i = 0; i < CatDatabase.HOME.length; i++) {
      if (CatDatabase.HOME[i] == null) {
        CatDatabase.HOME[i] = cat;
        return true;
      }
    }
    return false;
  }
}
