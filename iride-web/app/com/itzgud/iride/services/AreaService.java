package com.itzgud.iride.services;

import java.util.List;

import com.itzgud.iride.dto.AreaDto;

public interface AreaService {

	AreaDto getArea(int areaId);
	List<AreaDto> getAllAreas();
	List<AreaDto> getAreaByLocation(int locationId);
}
