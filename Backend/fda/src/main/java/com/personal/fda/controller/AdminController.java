package com.personal.fda.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.fda.dtos.AdminUserDTO;
import com.personal.fda.entities.Admin;
import com.personal.fda.services.AdminService;

@RestController
@RequestMapping("/api/v1/fda/admin")
@ResponseBody
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/createAdmin")
	public ResponseEntity<AdminUserDTO> createAdmin( @RequestBody AdminUserDTO adminUserDTO ) {
		Admin admin=this.adminService.createAdmin(adminUserDTO);
		AdminUserDTO adminUserDto=this.modelMapper.map(admin,AdminUserDTO.class);
		adminUserDto.setPassword(adminUserDTO.getPassword());
		adminUserDto.setRole(adminUserDTO.getRole());
		adminUserDto.setUsername(adminUserDTO.getUsername());
		return ResponseEntity.ok(adminUserDto);
	}	
	
}

	

	 
	
	 