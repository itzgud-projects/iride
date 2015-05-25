package com.itzgud.iride.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.dao.LocationDao;
import com.itzgud.iride.dto.LocationDto;
import com.itzgud.iride.entities.Location;

@Component
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationDao locationDao;
	
	@Autowired
	LocationDto.Mapper dtoMapper;
	
	@Override
	public LocationDto getLocation(int locationId){
		Location location = locationDao.findById(locationId);
		return dtoMapper.fromEntity(location);
		
	}
	
	@Override
	public List<LocationDto> getAllLocations(){
		Set<Location> locations = locationDao.findAll();
		return dtoMapper.fromEntities(locations);
	}
}
