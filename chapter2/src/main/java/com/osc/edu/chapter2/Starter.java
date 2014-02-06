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
 * Sang-cheon Park	2014. 1. 6.		First Draft.
 */
package com.osc.edu.chapter2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osc.edu.commons.customers.dto.CustomersDto;
import com.osc.edu.commons.customers.mapper.CustomersMapper;
import com.osc.edu.commons.employees.dto.EmployeesDto;
import com.osc.edu.commons.employees.mapper.EmployeesMapper;

/**
 * <pre>
 * Mybatis Standalone Example Class
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

	/**
	 * <pre>
	 * 프로그램 실행을 위해 samples/commons/db_configuration/build.xml 파일의 test-db-start, initializeData Task를 실행해야 한다.
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession session = SqlSessionFactoryManager.getSqlSession();
		
		List<CustomersDto> customersList = null;
		List<EmployeesDto> employeesList = null;

        logger.debug("Invoke query using Mapper XML.");
		
		// (xml) mapper 파일의 namespace, id를 이용한 쿼리 실행
        customersList = session.selectList("com.osc.edu.commons.customers.mapper.CustomersMapper.getCustomersList");
        employeesList = session.selectList("com.osc.edu.commons.employees.mapper.EmployeesMapper.getEmployeesList");

        logger.debug("customersList's size : {}", customersList.size());
        logger.debug("employeesList's size : {}", employeesList.size());
        
		// Mapper 인터페이스를 이용한 쿼리 실행
        CustomersMapper customersMapper = session.getMapper(CustomersMapper.class);
        EmployeesMapper employeesMapper = session.getMapper(EmployeesMapper.class);
        
        // 조회 결과의 차이를 비교하기 위해 데이터를 삭제한다.
        customersMapper.deleteCustomers(103);
        employeesMapper.deleteEmployees(1002);
        
        customersList = customersMapper.getCustomersList();
        employeesList = employeesMapper.getEmployeesList();

        logger.debug("customersList's size : {}", customersList.size());
        logger.debug("employeesList's size : {}", employeesList.size());
        
        session.close();
	}

}
//end of Starter.java