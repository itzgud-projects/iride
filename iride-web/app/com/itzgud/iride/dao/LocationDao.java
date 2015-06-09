package com.itzgud.iride.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.itzgud.iride.entities.Location;
import com.itzgud.iride.model.EntityDao;

@Component
public class LocationDao extends EntityDao<Location> {

	public Set<Location> findAll() {

		return Sets.newHashSet(em()
				.createQuery("from Location", Location.class).getResultList());

	}

	public Location findById(int id) {

		return em().find(Location.class, id);

	}

}
