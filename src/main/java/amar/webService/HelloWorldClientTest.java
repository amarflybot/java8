package amar.webService;

import amar.webService.client.*;
import amar.webService.client.Student;

/**
 * Created by amarendra on 05/01/16.
 */
public class HelloWorldClientTest {

    public static void main(String[] args) {
        HelloWorldImplService helloWorldImplService = new HelloWorldImplService();
        amar.webService.client.HelloWorld helloWorldImplPort = helloWorldImplService.getHelloWorldImplPort();
        Student amar = helloWorldImplPort.getHelloWorldAsString("Amar", 12);
        System.out.println("Name --> "+amar.getName()+", Roll --> "+amar.getRoll());
    }
}
