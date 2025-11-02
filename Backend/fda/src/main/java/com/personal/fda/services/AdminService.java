package com.personal.fda.services;

import com.personal.fda.dtos.AdminUserDTO;
import com.personal.fda.entities.Admin;

public interface AdminService {
	public Admin createAdmin(AdminUserDTO adminUserDTO);
}
