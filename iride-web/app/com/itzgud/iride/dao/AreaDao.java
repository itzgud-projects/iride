package com.itzgud.iride.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.itzgud.iride.entities.Area;
import com.itzgud.iride.model.EntityDao;
@Component
public class AreaDao extends EntityDao<Area> {

	public Set<Area> findAll() {

		return Sets.newHashSet(em().createQuery("from Area", Area.class)
				.getResultList());

	}

	public Area findById(int id) {

		return em().find(Area.class, id);

	}

	/**
	 * 
	 * Retrieve area by location id
	 */

	public Set<Area> findAreabyLocationId(int locationId) {

		return Sets.newHashSet(em()
				.createQuery("from Area where location.id = :locationId",
						Area.class)

				.setParameter("locationId", locationId)

				.getResultList());

	}
	
	public void removeAllByLocationId(int locationId) {

        em().createQuery("delete from Area a1 WHERE a1.id.locationId = :locationId")

                        .setParameter("locationId", locationId).executeUpdate();

    }
	
	public Boolean locationHasAreaData(Integer locationId) {

        List<Area> resultList =  session().createCriteria(Area.class, "area")

                        .add(Restrictions.eq("area.id.locationId", locationId))

                        .setMaxResults(1)

                        .list();

 

        return !resultList.isEmpty();

    }


}
