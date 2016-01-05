package amar.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author Amarendra Kumar
 * @date 05-01-2016 AM 08:57.
 */
    //Service Endpoint Interface
    @WebService
    @SOAPBinding(style = SOAPBinding.Style.RPC)
    public interface HelloWorld{

        @WebMethod
        String getHelloWorldAsString(String name);

    }