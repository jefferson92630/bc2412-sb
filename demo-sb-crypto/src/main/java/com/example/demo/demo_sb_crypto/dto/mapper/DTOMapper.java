package com.example.demo.demo_sb_crypto.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.demo_sb_crypto.dto.CryptoWebDTO;
import com.example.demo.demo_sb_crypto.model.Crypto;

@Component
public class DTOMapper {
  @Autowired
  private ModelMapper modelMapper;

  public CryptoWebDTO map(Crypto crypto) {
    return this.modelMapper.map(crypto, CryptoWebDTO.class);
  }
}
