package com.bootcamp.demo.demo_sb_helloworld;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_helloworld.ShoppingMall.Cinema;
import com.bootcamp.demo.demo_sb_helloworld.ShoppingMall.Cinema.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;

// Java Object -> JSON (Serialization)
// JSON -> Java Object (Deserialization)

// List & Array (JSON)

// Attribute has no ordering in JSON

@Controller // @GetMapping
@ResponseBody // JSON
public class HelloworldController {

  @Getter // Serialization (Object -> JSON)
  @AllArgsConstructor
  public static class Cat {
    private String name;
    private int age;
}
  // An API for Getting Resource
  @GetMapping(value = "/greeting")
  public String hello() {
    return "Hello World !";
  }

  // Create another API to return an Integer
  @GetMapping(value = "/integer")
    public Integer getInteger() {
      return 10;
  }
  // Create another API to return Integer array
  @GetMapping(value = "/integerarray")
  public Integer[] getIntArray() {
    return new Integer[] {1,2,3,4};
  }
  // Create another API to return List of String
  @GetMapping(value = "/string")
  public List<String> getString() {
      return List.of("Peter", "Paul", "Mary");
  }

  // Create another API to return a Cat
  @GetMapping(value = "/cat")
  public Cat getCat() {
    return new Cat("John", 10);
  }
  // Create another API to return a List of Cat
  @GetMapping(value = "/catlist")
  public List<Cat> getCatList() {
    return List.of(new Cat("Steve", 8), new Cat("Jason", 67));
  }

  // Create another API to return a List of LocalDate
  @GetMapping(value = "/date")
  public LocalDate getDate() {
    return LocalDate.now();
  }

  @GetMapping(value = "/datelist")
  public List<LocalDate> getDateList() {
    return List.of(LocalDate.of(1989, 6, 4), LocalDate.of(1992, 6, 30));
  }

 @GetMapping(value = "/shoppingmall")
  public ShoppingMall getShopmall() {
    ShoppingMall.Cinema.Film film1 = Film.builder() 
      .name("123")
      .releaseDate(LocalDate.of(2024, 10, 2))
      .build();
    ShoppingMall.Cinema.Film film2 = Film.builder() 
      .name("234")
      .releaseDate(LocalDate.of(2025, 10, 2))
      .build();
    ShoppingMall.Cinema cinema = Cinema.builder()
      .releasedFilms(new Film[] {film1, film2})
      .name("ABC")
      .build();
    return ShoppingMall.builder()
      .name("K11")
      .area(100000)
      .cinema(cinema)
      .shopCategory(new String[] {"Clothing", "Sport"})
      .build();
  }

}
