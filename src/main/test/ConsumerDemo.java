import com.bbs.service.IConsumerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerDemo {
    ApplicationContext applicationContext;

    @Before
    public void defore(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void checkUsername(){
        IConsumerService consumerService = (IConsumerService) applicationContext.getBean("consumerService");
        int tom = consumerService.checkUsername("tom");
        return;
    }
}
