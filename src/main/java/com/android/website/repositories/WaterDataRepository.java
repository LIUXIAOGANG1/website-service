package com.android.website.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.android.website.beans.WaterData;

public interface WaterDataRepository extends CrudRepository<WaterData, Integer> {

	public List<WaterData> findByWaterSiteId(int waterSiteId);
	
	@Query("from waterData w where w.waterSiteId = :siteId AND w.samplingTime >= :start AND w.samplingTime <= :end ORDER BY id LIMIT :offset, 10")
	public List<WaterData> findBySiteIdAndTime(@Param("siteId")int siteId, @Param("start")Date start, @Param("end")Date end, @Param("offset")int offset);
}
