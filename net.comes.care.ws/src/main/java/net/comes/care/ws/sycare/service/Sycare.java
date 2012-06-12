package net.comes.care.ws.sycare.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-05-16T15:17:52.219+02:00
 * Generated source version: 2.6.0
 * 
 */
@WebService(targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", name = "sycare")
@XmlSeeAlso({net.comes.care.ws.sycare.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Sycare {

    /**
     * Client has to authenticate against Webservice with username and password.
     * 			If account exists we will return an appropriate userid. 
     * 			If authentication takes place within a configurable period before password expires,
     * 			we return the  additional parameter PwdExpire with the date of expiration as value. 
     * 			If account doesn't exist we return zero.
     * 		
     */
    @WebResult(name = "Session", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/authenticate")
    public net.comes.care.ws.sycare.Session authenticate(
        @WebParam(partName = "parameters", name = "Credentials", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.Credentials parameters
    );

    /**
     * Client sends request for retrieving next available message
     */
    @WebResult(name = "aMessage", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getMessage")
    public net.comes.care.ws.sycare.AMessage getMessage(
        @WebParam(partName = "parameters", name = "getMessageRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetMessageRequest parameters
    );

    /**
     * Client sends device type. We return a list of manufacturers for this device type.
     *     		The list is empty, if no devices of given type are allocated to actual patient.
     *     	
     */
    @WebResult(name = "DeviceManufacturers", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getDeviceManufacturers")
    public net.comes.care.ws.sycare.DeviceManufacturers getDeviceManufacturers(
        @WebParam(partName = "parameters", name = "getDeviceManufacturersRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetDeviceManufacturersRequest parameters
    );

    /**
     * Client sends confirmation and maybe answers of a survey. 
     * 			We return if data could be inserted in database succesfully
     * 		
     */
    @WebResult(name = "Status", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/sendSurveyData")
    public net.comes.care.ws.sycare.Status sendSurveyData(
        @WebParam(partName = "parameters", name = "sendSurveyDataRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.SendSurveyDataRequest parameters
    );

    /**
     * Client sends new password.
     * 			We return if password is valid and could be inserted in database succesfully.
     * 		
     */
    @WebResult(name = "Status", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/newPwd")
    public net.comes.care.ws.sycare.Status newPwd(
        @WebParam(partName = "parameters", name = "newPwdRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.NewPwdRequest parameters
    );

    /**
     * Client sends device type and number of days.
     *     		The number of days specfies how many days before current date the period 
     * 			from which the measured data shall come begins.  
     * 			We return measured data for specified device type within specified period.
     * 		
     */
    @WebResult(name = "getMeasuredDataResponse", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getMeasuredData")
    public net.comes.care.ws.sycare.GetMeasuredDataResponse getMeasuredData(
        @WebParam(partName = "parameters", name = "getMeasuredDataRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetMeasuredDataRequest parameters
    );

    /**
     * Client sends data for available devices to Webservice. We return a status.
     */
    @WebResult(name = "Status", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/sendData")
    public net.comes.care.ws.sycare.Status sendData(
        @WebParam(partName = "parameters", name = "sendDataRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.SendDataRequest parameters
    );

    /**
     * Client sends request for embedded device types. We return a list of device types.
     */
    @WebResult(name = "DeviceTypes", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getDeviceTypes")
    public net.comes.care.ws.sycare.DeviceTypes getDeviceTypes(
        @WebParam(partName = "parameters", name = "getDeviceTypesRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetDeviceTypesRequest parameters
    );

    /**
     * Client sends request for retrieving status of messages and/or surveys and/or a specific device.
     * 			We return the status of the devices which contains requested device identifier and most recent values for devices
     * 			and/or the number of the unread messages and/or the number of the unread surveys.
     * 			Returns a SOAP-Fault if no session id is transmitted, session id is invalid or session is expired.
     * 		
     */
    @WebResult(name = "Status", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getStatus")
    public net.comes.care.ws.sycare.Status getStatus(
        @WebParam(partName = "parameters", name = "getStatusRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetStatusRequest parameters
    );

    /**
     * Client sends request for retrieving next available survey
     */
    @WebResult(name = "aSurvey", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl", partName = "parameters")
    @WebMethod(action = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl/getSurvey")
    public net.comes.care.ws.sycare.ASurvey getSurvey(
        @WebParam(partName = "parameters", name = "getSurveyRequest", targetNamespace = "https://comes.synergysystems-net.com/sycare/soap/sycare-0.11.wsdl")
        net.comes.care.ws.sycare.GetSurveyRequest parameters
    );
}