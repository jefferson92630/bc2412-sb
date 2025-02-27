package com.example.demo.demo_sb_crypto.service;

import java.util.List;
import com.example.demo.demo_sb_crypto.model.Crypto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CryptoService {
  List<Crypto> getCoinMarket();

  List<Crypto> getCoinMarketWithCache() throws JsonProcessingException;
}

