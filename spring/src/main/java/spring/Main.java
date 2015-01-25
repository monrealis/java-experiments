package spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.api.IBean1;
import spring.api.IBean2;
import spring.api.IFactory;
import spring.impl.Bean3;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        IBean1 i = context.getBean(IBean1.class);
        IBean2 i2 = context.getBean(IBean2.class);
        IFactory b = context.getBean(IFactory.class);
        System.out.println(i.getClass().getName());
        System.out.println(i2.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(b.createBean3(1).getClass().getName());
        System.out.println(b.createBean3(1).getBean1().getClass().getName());
        System.out.println(new Bean3().getBean1());
        System.out.println(b.inject(new Bean3()).getBean1());
    }
}
