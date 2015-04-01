package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.api.IBean1;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Beans.xml"})
public class InjectTest {
    @Autowired
    private IBean1 autowired;
    @Inject
    private IBean1 injected;
    @Test
    public void shouldInjectBeansWithBothAnnotations() {
        assertNotNull(autowired);
        assertNotNull(injected);
    }
}
