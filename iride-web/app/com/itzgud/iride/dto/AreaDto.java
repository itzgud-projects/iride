package com.itzgud.iride.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.dao.AreaDao;
import com.itzgud.iride.dao.LocationDao;
import com.itzgud.iride.entities.Area;

public class AreaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    public Integer id;
    public Integer locationId;
    public String areaName;
    public String pincode;
    public String latitude;
    public String longitude;
    
    @Component
    public static class Mapper extends DtoMapper<Area, AreaDto>{
    	
    	@Autowired
    	AreaDao areaDao;
    	@Autowired
    	LocationDao locationDao;
    	
    	@Override
    	protected AreaDto newDto(){
    		return new AreaDto();
    	}
    	
    	public Area fromDto(AreaDto areaDto){
    		Area area = areaDao.findById(areaDto.id);
    		mapDtoToEntity(areaDto,area);
    		return area;
    	}
    	
    	public Area newEntity(AreaDto areaDto){
    		Area area = new Area();
    		mapDtoToEntity(areaDto,area);
    		return area;
    	}
    	
    	public void mapDtoToEntity(AreaDto areaDto, Area area){
    		area.setLocation((areaDto.locationId == null) ? null: locationDao.findById(areaDto.locationId));
    		area.setAreaName(areaDto.areaName);
    		area.setLatitude(areaDto.latitude);
    		area.setLongitude(areaDto.longitude);
    		area.setPincode(areaDto.pincode);
    	}
    	
    	@Override
    	public void mapEntityToDto(Area area,AreaDto dto){
    		dto.locationId = (area.getLocation() == null) ? null: area.getLocation().getId();
    		dto.areaName = area.getAreaName();
    		dto.latitude = area.getLatitude();
    		dto.longitude = area.getLongitude();
    		dto.pincode = area.getPincode();
    		dto.id = area.getId();
    	}
    }
	
}
