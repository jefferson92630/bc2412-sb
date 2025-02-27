package com.example.demo.demo_sb_crypto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Crypto {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double current_price;
  private Long market_cap;
  private Integer market_cap_rank;
  private Long fully_diluted_valuation;
  private Long total_volume;
  private Long high_24h;
  private Long low_24h;
  private Double price_change_24h;
  private Double price_change_percentage_24h;
  private Long market_cap_change_24h;
  private Double market_cap_change_percentage_24h;
  private Long circulating_supply;
  private Long total_supply;
  private Long max_supply;
  private Long ath;
  private Double ath_change_percentage;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private String ath_date;
  private Double atl;
  private Double atl_change_percentage;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private String atl_date;
  private Roi roi;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private String last_updated;


  @Getter
  @Setter
  public static class Roi {
    private Double times;
    private String currency;
    private Double percentage;
  }

}
