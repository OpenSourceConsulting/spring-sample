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
package com.osc.edu.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.osc.edu.commons.customers.service.CustomersService;
import com.osc.edu.commons.employees.service.EmployeesService;

/**
 * <pre>
 * Mybatis + Spring Standalone Example Class
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
        logger.debug("Initializing Spring context.");
        
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{ "spring/application-context.xml" });

        logger.debug("Spring context initialized.");

        //CustomersService customersService = (CustomersService)applicationContext.getBean("customersService");
        //EmployeesService employeesService = (EmployeesService)applicationContext.getBean("employeesService");
        CustomersService customersService = applicationContext.getBean(CustomersService.class);
        EmployeesService employeesService = applicationContext.getBean(EmployeesService.class);
        
        customersService.setUseMapper(true);
        employeesService.setUseMapper(true);

        logger.debug("customers size with mapper : {}", customersService.getCustomersList().size());
        logger.debug("employees size with mapper : {}", employeesService.getEmployeesList().size());
        
        customersService.setUseMapper(false);
        employeesService.setUseMapper(false);

        logger.debug("customers size with sqlSession : {}", customersService.getCustomersList().size());
        logger.debug("employees size with sqlSession : {}", employeesService.getEmployeesList().size());     
        
        applicationContext.close();
	}

}
//end of Starter.java