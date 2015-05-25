package com.itzgud.iride.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.dao.AreaDao;
import com.itzgud.iride.dao.LocationDao;
import com.itzgud.iride.dto.AreaDto;
import com.itzgud.iride.entities.Area;

@Component
public class AreaServiceImpl implements AreaService{

	@Autowired
	AreaDao areaDao;
	
	@Autowired
	LocationDao locationDao;
	
	@Autowired
	AreaDto.Mapper dtoMapper;
	
	@Override
	public AreaDto getArea(int areaId){
		Area area = areaDao.findById(areaId);
		return dtoMapper.fromEntity(area);
		
	}
	
	@Override
	public List<AreaDto> getAllAreas(){
		Set<Area> areas = areaDao.findAll();
		return dtoMapper.fromEntities(areas);
	}
	
	@Override
	public List<AreaDto> getAreaByLocation(int locationId){
		Set<Area> areas = areaDao.findAreabyLocationId(locationId);
		return dtoMapper.fromEntities(areas);
	}
}
