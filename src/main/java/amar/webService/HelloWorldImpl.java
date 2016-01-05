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
    public Student getHelloWorldAsString(String name, Integer roll) {
        Student student = new Student();
        student.setName(name);
        student.setRoll(roll);
        return student;
    }
}
