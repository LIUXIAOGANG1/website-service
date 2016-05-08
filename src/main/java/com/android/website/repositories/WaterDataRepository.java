package com.android.website.repositories;

import org.springframework.data.repository.CrudRepository;

import com.android.website.beans.WaterData;

public interface WaterDataRepository extends CrudRepository<WaterData, Integer> {

}
