package com.personal.fda.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fda.dtos.AdminUserDTO;
import com.personal.fda.entities.Admin;
import com.personal.fda.entities.User;
import com.personal.fda.repositories.AdminRepository;
import com.personal.fda.repositories.UserRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;	
	
	@Override
	public Admin createAdmin(AdminUserDTO adminUserDTO) {
		Admin admin=this.modelMapper.map(adminUserDTO, Admin.class);
		User user=this.modelMapper.map(adminUserDTO,User.class);
		admin.setUser(user);
		this.userRepository.save(user);
		return this.adminRepository.save(admin);

	}
}