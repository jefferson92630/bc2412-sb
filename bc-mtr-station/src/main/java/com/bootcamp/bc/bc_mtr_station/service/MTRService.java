package com.bootcamp.bc.bc_mtr_station.service;

import java.util.List;
import java.util.Map;
import com.bootcamp.bc.bc_mtr_station.model.Line;
import com.bootcamp.bc.bc_mtr_station.model.Station;

public interface MTRService {
  Map<Line, List<Station>> getAllStations();
}
