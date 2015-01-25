package spring.api;

import org.springframework.context.annotation.Bean;

public interface IFactory {
    @Bean
    IBean3 createBean3(int x);

    <T> T inject(T t);
}
