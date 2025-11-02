package com.personal.fda.services;

import com.personal.fda.dtos.OwnerUserDTO;
import com.personal.fda.entities.RestaurantOwner;

public interface OwnerService {

	public RestaurantOwner createOwner(OwnerUserDTO ownerUserDTO);
}
