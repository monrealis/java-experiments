package spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.api.IBean1;
import spring.api.IBean2;

@Transactional
@Service
public class Bean1 implements IBean1 {
    @Autowired
    private IBean2 bean2;

    public IBean2 getBean2() {
        return bean2;
    }
}
