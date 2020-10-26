package com.cts.learning.dcSlots.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.learning.dcSlots.model.DCSlots;
import com.cts.learning.dcSlots.service.DCSlotsService;

@RestController
@RequestMapping("dcSlots")
public class DCSlotsController {
	
	@Autowired
	DCSlotsService dcSlotsService;
	
	@PostMapping
	public ResponseEntity<DCSlots> createDCSlots (@RequestBody DCSlots dcSlotsModel) {
		DCSlots responseModel = dcSlotsService.createDCSlots(dcSlotsModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
	
	@PutMapping
	public ResponseEntity<DCSlots> updateDCSlots (@RequestBody DCSlots dcSlotsModel) {
		DCSlots responseModel = dcSlotsService.updateDCSlots(dcSlotsModel);
		return ResponseEntity.status(HttpStatus.OK).body(responseModel);
	}
	
	@DeleteMapping("/{slotId}")
	public ResponseEntity<DCSlots> deleteDCSlots (@PathVariable Integer slotId) {
		dcSlotsService.deleteDCSlots(slotId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{slotId}")
	public ResponseEntity<DCSlots> getDCSlots (@PathVariable Integer slotId) {
		DCSlots responseModel = dcSlotsService.getDCSlotsById(slotId);
		return ResponseEntity.status(HttpStatus.OK).body(responseModel);
	}
	
}
