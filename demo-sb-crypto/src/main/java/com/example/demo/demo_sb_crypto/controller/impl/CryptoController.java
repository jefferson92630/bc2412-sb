package com.example.demo.demo_sb_crypto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.demo_sb_crypto.controller.CryptoOperation;
import com.example.demo.demo_sb_crypto.dto.CryptoWebDTO;
import com.example.demo.demo_sb_crypto.dto.mapper.DTOMapper;
import com.example.demo.demo_sb_crypto.model.Crypto;
import com.example.demo.demo_sb_crypto.service.CryptoService;
import com.example.demo.demo_sb_crypto.service.impl.CryptoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

// http://localhost:8080/crypto/api/v1/coin/market
@RestController
@RequestMapping("/crypto/api/v1")
public class CryptoController implements CryptoOperation {
  @Autowired
  private CryptoService cryptoService;

  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<CryptoWebDTO> getCoinMarket() {
    return cryptoService.getCoinMarket() //
        .stream() //
        .map(e -> dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<CryptoWebDTO> getCoinMarketWithCache() throws JsonProcessingException {
    return cryptoService.getCoinMarketWithCache() //
        .stream() //
        .map(e -> dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }
}