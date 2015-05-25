package com.itzgud.iride.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.dao.LocationDao;
import com.itzgud.iride.entities.Location;

public class LocationDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
    public String locationType;
    public String locationName;
    public Integer parentLocationId;
    public Integer timeZone;
    
    @Component
    public static class Mapper extends DtoMapper<Location, LocationDto>{
    	
    	@Autowired
    	LocationDao locationDao;
    	
    	@Override
    	protected LocationDto newDto(){
    		return new LocationDto();
    	}
    	
    	public Location fromDto(LocationDto locationDto){
    		Location location = locationDao.findById(locationDto.id);
    		mapDtoToEntity(locationDto,location);
    		return location;
    	}
    	
    	public Location newEntity(LocationDto locationDto){
    		Location location = new Location();
    		mapDtoToEntity(locationDto,location);
    		return location;
    	}
    	
    	public void mapDtoToEntity(LocationDto locationDto, Location location){
    		location.setLocationType(locationDto.locationType);
    		location.setLocationName(locationDto.locationName);
    		location.setParentLocationId(locationDto.parentLocationId);
    		location.setTimeZone(locationDto.timeZone);
    	}
    	
    	@Override
    	public void mapEntityToDto(Location location,LocationDto dto){
    		dto.locationType = location.getLocationType();
    		dto.locationName = location.getLocationName();
    		dto.parentLocationId = location.getParentLocationId();
    		dto.timeZone = location.getTimeZone();
    		dto.id = location.getId();
    	}
    }

}
