package org.openmrs.module.appframework.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.appframework.domain.Extension;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;


public class AllUserAppsTest {
	
	private AllUserApps allUserApps;
	
	@Mock
    private DbSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        allUserApps = new AllUserApps();
        allUserApps.setSessionFactory(sessionFactory);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test1() {
       allUserApps.getUserApp(null);
    }

}
