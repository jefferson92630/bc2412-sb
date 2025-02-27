package com.example.demo.demo_sb_crypto.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.demo_sb_crypto.model.Crypto;
import com.example.demo.demo_sb_crypto.model.dto.CoinGeckoMarketDto;

@Component
public class CoreMapper {
  @Autowired
  private ModelMapper modelMapper;

  public Crypto map(CoinGeckoMarketDto dto) {
    return this.modelMapper.map(dto, Crypto.class);
  }
}