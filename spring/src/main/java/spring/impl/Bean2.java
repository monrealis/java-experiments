package spring.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.api.IBean2;

@Component
@Transactional
public class Bean2 implements IBean2 {
}


