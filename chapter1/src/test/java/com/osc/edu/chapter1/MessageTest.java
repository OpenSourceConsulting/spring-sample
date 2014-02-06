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

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * 
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/resources/spring/application-context.xml" })
public class MessageTest {
	
	@Inject
	@Named("message")
	private Message message;
	
	@Test
	public void constructorTest() {		
		String title = "Hello World~!";
		
		// 검증
		assertEquals("title must be equal with " + title, title, message.getTitle());
	}
	
	@Test
	public void getMessageTest() {		
		String msg = "This is Korea.";
		
		// 검증
		assertEquals("message must be equal with " +  msg, msg, message.getMessage());
	}
	
	@Test
	public void setMessageTest() {
		// 1. 초기화
		String msg = "Test Message";
		
		// 2. 테스트
		message.setMessage(msg);
		
		// 3. 검증
		assertEquals("message must be equal with " +  msg, msg, message.getMessage());
	}

}
//end of MessageTest.java