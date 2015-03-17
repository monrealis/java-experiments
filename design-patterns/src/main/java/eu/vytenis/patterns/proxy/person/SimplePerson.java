package eu.vytenis.patterns.proxy.person;

import eu.vytenis.patterns.proxy.api.Person;

public class SimplePerson implements Person {
    private final String name;
    private final int salary;

    public SimplePerson(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
