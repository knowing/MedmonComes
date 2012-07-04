package net.comes.care.ws.sycare.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2012-05-16T15:17:52.230+02:00
 * Generated source version: 2.6.0
 * 
 */
@WebServiceClient(name = "sycare", 
                  wsdlLocation = "sycare-0.11.wsdl",
                  targetNamespace = "https://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl") 
public class Sycare_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("https://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl", "sycare");
    public final static QName SycareSOAP = new QName("https://www.kompass-lme.ei.tum.de/sycare/soap/sycare-0.11.wsdl", "sycareSOAP");
    static {
        URL url = Sycare_Service.class.getResource("sycare-0.11.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(Sycare_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "sycare-0.11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public Sycare_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Sycare_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Sycare_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Sycare_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Sycare_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Sycare_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Sycare
     */
    @WebEndpoint(name = "sycareSOAP")
    public Sycare getSycareSOAP() {
        return super.getPort(SycareSOAP, Sycare.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Sycare
     */
    @WebEndpoint(name = "sycareSOAP")
    public Sycare getSycareSOAP(WebServiceFeature... features) {
        return super.getPort(SycareSOAP, Sycare.class, features);
    }

}
