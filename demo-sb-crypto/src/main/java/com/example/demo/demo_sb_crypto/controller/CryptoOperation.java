package com.example.demo.demo_sb_crypto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.demo_sb_crypto.dto.CryptoWebDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CryptoOperation {
  @GetMapping("/coin/market")
  List<CryptoWebDTO> getCoinMarket();

  @GetMapping("/cache/coin/market")
  List<CryptoWebDTO> getCoinMarketWithCache() throws JsonProcessingException;
}