package com.itzgud.iride.entities;

import javax.persistence.*;

import com.itzgud.iride.model.PersistentEntity;
import com.itzgud.iride.util.ReflectionsUtils;
import com.itzgud.iride.util.ReflectionsUtils.Copyable;
import com.itzgud.iride.util.ReflectionsUtils.Exclude;

@Entity
@Table(name = "md_location")
public class Location extends PersistentEntity implements Copyable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Exclude
    @Column(name = "location_id")
    private Integer id;
    
    @Column(name = "location_type")
    private String locationType;
    
    @Column(name = "location_name")
    private String locationName;
    
    @Column(name = "parent_location_id")
    private Integer parentLocationId;
    
    @Column(name = "time_zone")
    private Integer timeZone;
	
    @Override
    public Integer getId() {
        return id;
    }
    
    public void copyTo(Location target) {
    	ReflectionsUtils.copy(this, target);

    }

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getParentLocationId() {
		return parentLocationId;
	}

	public void setParentLocationId(Integer parentLocationId) {
		this.parentLocationId = parentLocationId;
	}

	public Integer getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Integer timeZone) {
		this.timeZone = timeZone;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
