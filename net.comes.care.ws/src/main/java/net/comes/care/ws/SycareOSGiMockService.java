package net.comes.care.ws;

import java.util.LinkedList;
import java.util.Queue;

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
import net.comes.care.ws.sycare.MessageType;
import net.comes.care.ws.sycare.NewPwdRequest;
import net.comes.care.ws.sycare.SendDataRequest;
import net.comes.care.ws.sycare.SendSurveyDataRequest;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.Status;
import net.comes.care.ws.sycare.Sycare;

public class SycareOSGiMockService implements Sycare {
	
	private final Queue<AMessage> messageQueue = new LinkedList<>();
	
	/**
	 * OSGi activate. Generate mock objects here
	 */
	protected void activate() {
		//Messages
		AMessage msg1 = new AMessage();
		msg1.setMessageId(0);
		msg1.setMessageTitle("Welcome to COMES");
		msg1.setMessageData("This is a welcome message");
		msg1.setMessageType(MessageType.STRING);
		AMessage msg2 = new AMessage();
		msg2.setMessageId(0);
		msg2.setMessageTitle("Welcome to COMES in HTML");
		msg2.setMessageData("<h1>Welcome</h1><p>This is a welcome message. <em>COMES Team</em></p>");
		msg2.setMessageType(MessageType.HTML);
		messageQueue.add(msg1);
		messageQueue.add(msg2);
		
		//Devices
		
	}

	@Override
	public Status sendData(SendDataRequest parameters) {
		return null;
	}

	@Override
	public Session authenticate(Credentials parameters) {
		Session session = new Session();
		session.setSessionId(parameters.getUsername() + ":" + parameters.hashCode());
		return session;
	}

	@Override
	public ASurvey getSurvey(GetSurveyRequest parameters) {
		return null;
	}

	@Override
	public Status newPwd(NewPwdRequest parameters) {
		return null;
	}

	@Override
	public Status getStatus(GetStatusRequest parameters) {
		Status status = new Status();
		status.setAvailableMessages(2);
		status.setAccepted(true);
		status.setAvailableSurveys(0);
		return status;
	}

	@Override
	public DeviceManufacturers getDeviceManufacturers(GetDeviceManufacturersRequest parameters) {
		return null;
	}

	@Override
	public GetMeasuredDataResponse getMeasuredData(GetMeasuredDataRequest parameters) {
		return null;
	}

	@Override
	public Status sendSurveyData(SendSurveyDataRequest parameters) {
		return null;
	}

	@Override
	public AMessage getMessage(GetMessageRequest parameters) {
		return messageQueue.poll();
	}

	@Override
	public DeviceTypes getDeviceTypes(GetDeviceTypesRequest parameters) {
		return null;
	}

}
