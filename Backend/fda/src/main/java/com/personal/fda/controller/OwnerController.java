package com.personal.fda.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.dtos.OwnerUserDTO;
import com.personal.fda.entities.RestaurantOwner;
import com.personal.fda.services.OwnerService;

@RestController
@RequestMapping("/api/v1/fda/owner")
@ResponseBody
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/createOwner")
	public ResponseEntity<OwnerUserDTO> creatOwner( @RequestBody OwnerUserDTO ownerUserDTO ) {
		RestaurantOwner owner=this.ownerService.createOwner(ownerUserDTO);
		OwnerUserDTO ownerUserDto=this.modelMapper.map(owner,OwnerUserDTO.class);
		ownerUserDto.setPassword(ownerUserDTO.getPassword());
		ownerUserDto.setRole(ownerUserDTO.getRole());
		ownerUserDto.setUsername(ownerUserDTO.getUsername());
		return ResponseEntity.ok(ownerUserDto);
	}	
}
