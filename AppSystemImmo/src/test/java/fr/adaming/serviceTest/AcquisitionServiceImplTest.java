package fr.adaming.serviceTest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Acquisition;
import fr.adaming.service.IAcquisitionService;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AcquisitionServiceImplTest {

	// instanciation de Service
	@Autowired
	IAcquisitionService acService;

	// test ajouter
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddAcquisition() {
		Acquisition ac = new Acquisition(54.6, null, "AGHGB", null);
		acService.addAcquisition(ac);
		assertEquals(2, acService.getAllAcquisition().size());
	}

}
