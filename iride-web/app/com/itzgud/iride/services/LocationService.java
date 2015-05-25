package com.itzgud.iride.services;

import java.util.List;

import com.itzgud.iride.dto.LocationDto;

public interface LocationService {
	
	LocationDto getLocation(int locationId);
	List<LocationDto> getAllLocations();

}
