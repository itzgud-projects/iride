package com.itzgud.iride.entities;

import javax.persistence.*;

import com.itzgud.iride.model.PersistentEntity;
import com.itzgud.iride.util.ReflectionsUtils;
import com.itzgud.iride.util.ReflectionsUtils.Copyable;
import com.itzgud.iride.util.ReflectionsUtils.Exclude;

@Entity
@Table(name = "md_area")
public class Area extends PersistentEntity implements Copyable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Exclude
    @Column(name = "area_id")
    private Integer id;

    @Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_location_id")
    private Location location;
    
    @Column(name = "area_name")
    private String areaName;
    
    @Column(name = "pincode")
    private String pincode;
    
    @Column(name = "latitude")
    private String latitude;
    
    @Column(name = "longitude")
    private String longitude;
    

    @Override
    public Integer getId() {
        return id;
    }

    
    public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void copyTo(Area target) {
    	ReflectionsUtils.copy(this, target);

    }
	
	
	
	

}
