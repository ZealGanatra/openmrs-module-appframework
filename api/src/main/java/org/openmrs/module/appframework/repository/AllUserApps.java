/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.appframework.repository;

import java.util.List;

import org.openmrs.api.db.hibernate.DbSessionFactory;  
import org.openmrs.module.appframework.domain.UserApp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Repository
public class AllUserApps {
	
	private DbSessionFactory sessionFactory;
	protected Log log = LogFactory.getLog(this.getClass());

	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public UserApp getUserApp(String appId) {
		try{
		log.debug("getting User Apps");
		}
		catch(RuntimeException e)
		{
			log.error("error while getting User Apps",e);
			throw e;
		}
		return (UserApp) sessionFactory.getCurrentSession().get(UserApp.class, appId);
	}
	
	@Transactional
	public UserApp saveUserApp(UserApp userApp) {
		try
		{
		log.debug("saving User App");
		sessionFactory.getCurrentSession().saveOrUpdate(userApp);
		}
		catch(RuntimeException e)
		{
			log.error("error while save user",e);
			throw e;
		}
		return userApp;
	}
	
	@Transactional(readOnly = true)
	public List<UserApp> getUserApps() {
		try
		{
		log.debug("getting all User Apps");
		}
		catch(RuntimeException e)
		{
			log.error("error while getting User App",e);
			throw e;
		}
		return sessionFactory.getCurrentSession().createCriteria(UserApp.class).list();
	}
	
	@Transactional
	public void deleteUserApp(UserApp userApp) {
		try
		{
		log.debug("deleting User App");
		sessionFactory.getCurrentSession().delete(userApp);
		}
		catch(RuntimeException e)
		{
			log.error("error while deleting user",e);
			throw e;
		}
	}
	
}
