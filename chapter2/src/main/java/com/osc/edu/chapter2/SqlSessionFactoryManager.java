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

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Manager Class to get SqlSession or SqlSessionFactory object using SqlSessionFactory 
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
public class SqlSessionFactoryManager {

    private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryManager.class);
    private static final SqlSessionFactory sqlSessionFactory;
   
	static {
		String resource = "mybatis/mybatis-config.xml";
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			logger.error("Initializing error. : ", e);
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	/**
	 * <pre>
	 * 인스턴스 생성을 할 수 없도록 private 생성자를 지정
	 * </pre>
	 */
	private SqlSessionFactoryManager() {}
    
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
          
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public static SqlSession getSqlSession(boolean arg) {
		return sqlSessionFactory.openSession(arg);
	}
}
//end of SqlSessionFactoryManager.java