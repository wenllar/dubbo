package consumer;

import api.HelloService;
import org.junit.Test;
import reflect.PorxyFactory;

import java.io.IOException;


public class ConsumerTest {

    @Test
    public void testCallHelloServiceWithAssignedProvider() throws IOException, ClassNotFoundException {
        String result = new ConsumerSerivce().callHelloServiceWithAssignedProvider();
        System.out.println(result);
    }

    @Test
    public void testCallHelloServiceWithRandomProvider() throws IOException, ClassNotFoundException {
        String result = new ConsumerSerivce().callHelloServiceWithRandomProvider();
        System.out.println(result);
    }
}
