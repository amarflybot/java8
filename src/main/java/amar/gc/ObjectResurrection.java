package amar.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 05/09/17.
 * While it's a good idea to avoid using finalize(), it is a small comfort to know it will only be called once it the object is resurrected.
 * https://dzone.com/articles/object-resurrection
 */
public class ObjectResurrection {

    static List<PersonSts> personSts = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            personSts.add(new PersonSts(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(personSts);
            personSts.clear();
            System.out.println("Clearing Person");
            System.gc();
            Thread.sleep(10000);
        }

    }

    static class PersonSts {

        private Integer id;

        public PersonSts(final Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "PersonSts{" +
                    "id=" + id +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Calling finalize for " + id);
            personSts.add(this);
        }
    }
}
