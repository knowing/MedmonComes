package net.comes.care.ws.sycare.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.ws.sycare.*;
import net.comes.care.ws.sycare.service.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;


public class SycareOSGiTest {

	
	private Sycare sycare;

	@Before
	public void setUp() throws Exception {
		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceReference<Sycare> reference = context.getServiceReference(Sycare.class);
		sycare = context.getService(reference);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticate(){
		Credentials credentials = new Credentials();
		credentials.setUsername("ComesTest22");
		credentials.setPassword("Comes#22");
		Session session = sycare.authenticate(credentials);
		
		assertNotNull(session);
		assertNotNull(session.getSessionId());
	}
	
	@Test(expected = SOAPFaultException.class)
	public void testAuthenticateFail(){
		Credentials credentials = new Credentials();
		credentials.setUsername("WrongUser");
		credentials.setPassword("No Password");
		sycare.authenticate(credentials);
	}

	@Test
	public void testGetMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeviceManufacturers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendSurveyData() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewPwd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMeasuredData() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendData() {
		Credentials credentials = new Credentials();
		credentials.setUsername("ComesTest22");
		credentials.setPassword("Comes#22");
		Session session = sycare.authenticate(credentials);
		
		SendDataRequest parameters = new SendDataRequest();
		parameters.setSessionId(session.getSessionId());
		parameters.setDataType(DataType.ASCII_DELIMITED);
		parameters.setDeviceType(DeviceType.AC);
		List<DeviceData> data = parameters.getDeviceData(); // Adding data
		DeviceData d = new DeviceData();

		DeviceADDR deviceADDR = new DeviceADDR();
		deviceADDR.setSerialNumber("0002C752DF9E");
		deviceADDR.setDeviceManufacturer("Omron RX Genius 6371T");
		d.setDeviceADDR(deviceADDR);
		List<String> acData = d.getACData();
		//##;record_id;year;month;day;hour;minute;second;unit;duration;steps;weight;met;calorie;distance
		acData.add("##;0;2010;05;25;19;50;51;Joggen;2;0;");
		acData.add("##;1;2010;05;25;19;50;53;biken;3;0;");
		acData.add("##;2;2010;05;25;19;50;54;Joggen;4;0;");
		data.add(d);
		
		Status status = sycare.sendData(parameters);
		assertTrue(status.isAccepted());
	}

	@Test
	public void testGetDeviceTypes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSurvey() {
		fail("Not yet implemented");
	}

}
