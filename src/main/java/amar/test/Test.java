package amar.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 22/04/16.
 */
public class Test {

    public static void main(String[] args) {

        Map<Student, String> hm = new HashMap<>();
        Student s1 = new Student("Ashish");
        Student s2 = new Student("Ashish");

        hm.put(s1,"One");
        hm.put(s2,"Two");

        System.out.println(hm.get(new Student("Ashish")));
    }
}

class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
        //return false;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
