package amar.webService;

import javax.jws.WebService;

/**
 * @author Amarendra Kumar
 * @date 05-01-2016 AM 08:59.
 */
//Service Implementation
@WebService(endpointInterface = "amar.webService.HelloWorld")
public class HelloWorldImpl implements  HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}
