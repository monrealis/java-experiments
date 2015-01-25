package spring.impl;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.api.IBean3;
import spring.api.IFactory;

@Configuration
public class Factory implements IFactory {
    @Override
    @Bean
    @Scope("prototype")
    public IBean3 createBean3(int x) {
        return new Bean3();
    }

    @Override
    @Bean
    @Scope("prototype")
    public <T> T inject(T t) {
        return t;
    }
}
