package com.bootcamp.demo.demo_sb_customer.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_sb_customer.entity.AddressEntity;
import com.bootcamp.demo.demo_sb_customer.entity.CompanyEntity;
import com.bootcamp.demo.demo_sb_customer.entity.GeoEntity;
import com.bootcamp.demo.demo_sb_customer.entity.UserEntity;
import com.bootcamp.demo.demo_sb_customer.model.dto.UserDto;

@Component
public class EntityMapper {
  public UserEntity map(UserDto dto) {
    return UserEntity.builder()
    .name(dto.getName())
    .username(dto.getUsername())
    .email(dto.getEmail())
    .website(dto.getWebsite())
    .phone(dto.getPhone())
    .build();
  }

  public AddressEntity map(UserDto.Address address) {
    return AddressEntity.builder()
    .street(address.getStreet())
    .city(address.getCity())
    .suite(address.getSuite())
    .zipcode(address.getZipcode())
    .build();
  }

  public GeoEntity map(UserDto.Address.Geo geo) {
    return GeoEntity.builder()
    .latitude(Double.valueOf(geo.getLatitude()))
    .longitude(Double.valueOf(geo.getLongitude()))
    .build();
  
  }

  public CompanyEntity map(UserDto.Company company) {
    return CompanyEntity.builder()
    .name(company.getName())
    .catchPhrase(company.getCatchPhrase())
    .bs(company.getBs())
    .build();
  }
    
}

