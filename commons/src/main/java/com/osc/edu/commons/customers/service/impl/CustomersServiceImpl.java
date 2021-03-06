/* 
 * Copyright (C) 2012-2014 Open Source Consulting, Inc. All rights reserved by Open Source Consulting, Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * Revision History
 * Author			Date				Description
 * ---------------	----------------	------------
 * Sang-cheon Park	2014. 1. 7.		First Draft.
 */
package com.osc.edu.commons.customers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osc.edu.commons.customers.dao.CustomersDao;
import com.osc.edu.commons.customers.dto.CustomersDto;
import com.osc.edu.commons.customers.service.CustomersService;

/**
 * <pre>
 * Service Class for Customers
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersDao customersDao;
	
	public void setUseMapper(boolean useMapper) {
		customersDao.setUseMapper(useMapper);
	}

	public List<CustomersDto> getCustomersList() {
		return customersDao.getCustomersList();
	}

	public CustomersDto getCustomers(Integer id) {
		return customersDao.getCustomers(id);
	}

	public void insertCustomers(CustomersDto customers) {
		customersDao.insertCustomers(customers);
	}

	public void updateCustomers(CustomersDto customers) {
		customersDao.updateCustomers(customers);
	}

	public void deleteCustomers(Integer id) {
		customersDao.deleteCustomers(id);
	}

	public void insertCustomersList(List<CustomersDto> customersList) {
		for (CustomersDto customers : customersList) {
			customersDao.insertCustomers(customers);
		}
	}
}
//end of CustomersService.java