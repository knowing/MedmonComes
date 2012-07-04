package net.comes.care.ws.sycare.service.impl;

import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import net.comes.care.ws.sycare.AMessage;
import net.comes.care.ws.sycare.ASurvey;
import net.comes.care.ws.sycare.Credentials;
import net.comes.care.ws.sycare.DeviceManufacturers;
import net.comes.care.ws.sycare.DeviceTypes;
import net.comes.care.ws.sycare.GetDeviceManufacturersRequest;
import net.comes.care.ws.sycare.GetDeviceTypesRequest;
import net.comes.care.ws.sycare.GetMeasuredDataRequest;
import net.comes.care.ws.sycare.GetMeasuredDataResponse;
import net.comes.care.ws.sycare.GetMessageRequest;
import net.comes.care.ws.sycare.GetStatusRequest;
import net.comes.care.ws.sycare.GetSurveyRequest;
import net.comes.care.ws.sycare.NewPwdRequest;
import net.comes.care.ws.sycare.SendDataRequest;
import net.comes.care.ws.sycare.SendSurveyDataRequest;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.Status;
import net.comes.care.ws.sycare.service.Sycare;

public class SycareOSGiService implements Sycare {
	
	private Sycare client;

	protected void activate(Map<String, Object> properties) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//https://www.kompass-lme.ei.tum.de/sycare/soap/sycare_ws.php -unsigned certificate
		factory.setAddress("http://www.kompass-lme.ei.tum.de/sycare/soap/sycare_ws.php");
		factory.setServiceClass(Sycare.class);
		client = (Sycare) factory.create();
	}
	
	protected void deactivate() {
		client = null;
	}
	
	@Override
	public Session authenticate(Credentials parameters) {
		return client.authenticate(parameters);
	}
	
	@Override
	public AMessage getMessage(GetMessageRequest parameters) {
		return client.getMessage(parameters);
	}
	
	@Override
	public DeviceManufacturers getDeviceManufacturers(GetDeviceManufacturersRequest parameters) {
		return client.getDeviceManufacturers(parameters);
	}
	
	@Override
	public Status sendSurveyData(SendSurveyDataRequest parameters) {
		return client.sendSurveyData(parameters);
	}
	
	@Override
	public Status newPwd(NewPwdRequest parameters) {
		return client.newPwd(parameters);
	}
	
	@Override
	public GetMeasuredDataResponse getMeasuredData(GetMeasuredDataRequest parameters) {
		return client.getMeasuredData(parameters);
	}
	
	@Override
	public Status sendData(SendDataRequest parameters) {
		return client.sendData(parameters);
	}
	
	@Override
	public DeviceTypes getDeviceTypes(GetDeviceTypesRequest parameters) {
		return client.getDeviceTypes(parameters);
	}
	
	@Override
	public Status getStatus(GetStatusRequest parameters) {
		return client.getStatus(parameters);
	}
	
	@Override
	public ASurvey getSurvey(GetSurveyRequest parameters) {
		return client.getSurvey(parameters);
	}


	
}
