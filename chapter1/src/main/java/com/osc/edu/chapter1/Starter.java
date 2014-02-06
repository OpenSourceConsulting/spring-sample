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
package com.osc.edu.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * Spring Standalone Example Class
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

	public static void main(String[] args) {
        logger.debug("Initializing Spring context.");
        
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{ "spring/application-context.xml" });

        logger.debug("Spring context initialized.");

		//Message message = (Message)applicationContext.getBean("message");
		Message message = applicationContext.getBean(Message.class);
		
		logger.debug("[Title] : {}", message.getTitle());
		logger.debug("[Message] : {}", message.getMessage());   
        
        applicationContext.close();
	}
}
//end of Starter.java