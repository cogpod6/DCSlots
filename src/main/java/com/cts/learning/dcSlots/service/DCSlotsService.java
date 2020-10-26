package com.cts.learning.dcSlots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.learning.dcSlots.model.DC;
import com.cts.learning.dcSlots.model.DCEntity;
import com.cts.learning.dcSlots.model.DCSlots;
import com.cts.learning.dcSlots.model.DCSlotsEntity;
import com.cts.learning.dcSlots.model.DCType;
import com.cts.learning.dcSlots.model.DCTypeEntity;
import com.cts.learning.dcSlots.repository.DCSlotsRepository;

@Service
public class DCSlotsService {
	
	@Autowired
	DCSlotsRepository dcSlotsRepository;
	
	public DCSlots createDCSlots (DCSlots dcSlotsModel) {

		DCSlotsEntity responseEntity = dcSlotsRepository.save(mapToEntity(dcSlotsModel));
		return mapToModel(responseEntity);
	}
	
	public DCSlots updateDCSlots (DCSlots dcSlotsModel) {
		DCSlotsEntity responseEntity = dcSlotsRepository.saveAndFlush(mapToEntity(dcSlotsModel));
		return mapToModel(responseEntity);
	}
	
	public void deleteDCSlots (Integer id) {
		dcSlotsRepository.findById(id).map(dcSlots -> {
			dcSlotsRepository.delete(dcSlots);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("No Records Found"));
	     
	}
	
	public DCSlots getDCSlotsById (Integer id) {
		return dcSlotsRepository.findById(id).map(dcSlots -> {
			return mapToModel(dcSlots);
		}).orElseThrow(() -> new RuntimeException("No Records Found"));
	}

	public DCSlotsEntity mapToEntity (DCSlots dcSlotsModel) {
		DCSlotsEntity dcSlotsEO = new DCSlotsEntity();
		
		dcSlotsEO.setId(dcSlotsModel.getId());
		
		DCEntity dcEO = new DCEntity();
		dcEO.setId(dcSlotsModel.getDc().getId());
		dcEO.setDcNumber(dcSlotsModel.getDc().getDcNumber());
		dcEO.setCity(dcSlotsModel.getDc().getCity());
		
		DCTypeEntity dcTypeEO = new DCTypeEntity();
		dcTypeEO.setId(dcSlotsModel.getDc().getDcType().getId());
		dcTypeEO.setDcType(dcSlotsModel.getDc().getDcType().getType());
		dcEO.setDcType(dcTypeEO);
		
		dcSlotsEO.setDc(dcEO);
		dcSlotsEO.setTimeSlots(dcSlotsModel.getTimeSlots());
		dcSlotsEO.setMaxTrucks(dcSlotsModel.getMaxTrucks());
		
		
		return dcSlotsEO;
	}
	
	public DCSlots mapToModel (DCSlotsEntity dcSlotsEntity) {
		DCSlots dcSlotsModel = new DCSlots();
		
		dcSlotsModel.setId(dcSlotsEntity.getId());
		
		DC dcModel = new DC();
		dcModel.setId(dcSlotsEntity.getDc().getId());
		dcModel.setDcNumber(dcSlotsEntity.getDc().getDcNumber());
		dcModel.setCity(dcSlotsEntity.getDc().getCity());
		
		DCType dcTypeModel = new DCType();
		dcTypeModel.setId(dcSlotsEntity.getDc().getDcType().getId());
		dcTypeModel.setType(dcSlotsEntity.getDc().getDcType().getDcType());
		
		dcModel.setDcType(dcTypeModel);
		
		dcSlotsModel.setDc(dcModel);
		dcSlotsModel.setTimeSlots(dcSlotsEntity.getTimeSlots());
		dcSlotsModel.setMaxTrucks(dcSlotsEntity.getMaxTrucks());
		
		return dcSlotsModel;
	}
}
