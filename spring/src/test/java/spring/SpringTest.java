package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.api.*;
import spring.impl.Bean3;

public class SpringTest {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    IBean1 bean1 = context.getBean(IBean1.class);
    IBean2 bean2 = context.getBean(IBean2.class);
    IFactory factory = context.getBean(IFactory.class);

    @Test
    public void printClasses() {
        println(bean1);
        println(bean2);
        println(bean2.getClass().getName());
        println(factory.getClass().getName());
        println(factory.createBean3(1).getClass().getName());
        println(factory.createBean3(1).getBean1());
        println(new Bean3().getBean1());
        println(factory.inject(new Bean3()).getBean1());
    }

    private void println(Object o) {
        if (o == null) {
            System.out.println(String.valueOf(o));
        } else {
            System.out.println(o.getClass().getName());
        }
    }
}
