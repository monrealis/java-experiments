package eu.vytenis.fitnesse.row;

import fit.RowFixture;

public class PersonsRowFixture extends RowFixture {
    @Override
    public Object[] query() throws Exception {
        Object[] persons = {new Person("F", "L"), new Person("F", "L"), new Person("f", "l")};
        return persons;
    }

    @Override
    public Class<?> getTargetClass() {
        return Person.class;
    }

    public static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
