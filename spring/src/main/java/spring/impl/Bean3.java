package spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.api.IBean1;
import spring.api.IBean3;


public class Bean3 implements IBean3 {
    @Autowired
    private IBean1 bean1;

    @Override
    public IBean1 getBean1() {
        return bean1;
    }
}
