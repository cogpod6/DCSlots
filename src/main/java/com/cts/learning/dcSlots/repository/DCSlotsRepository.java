package com.cts.learning.dcSlots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.learning.dcSlots.model.DCSlotsEntity;

@Repository
public interface DCSlotsRepository extends JpaRepository<DCSlotsEntity, Integer>{

}
