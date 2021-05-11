package com.travel;

import static org.junit.Assert.assertTrue;

import com.amazonservices.mws.client.MwsEndpoints;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersAsyncClient;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersConfig;
import com.amazonservices.mws.orders._2013_09_01.model.GetOrderRequest;
import com.amazonservices.mws.orders._2013_09_01.model.GetOrderResponse;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageServiceImpl messageService = context.getBean(MessageServiceImpl.class);
        // 这句将输出: hello world
        System.out.println(messageService.getName());
        messageService.sayHi();

        context.getBean(LookUpBean.class).print();
    }

    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.travel");
        configApplicationContext.getBean(AnnotationTest.class).printMsg();
    }

    @Test
    public void getOrder() throws ExecutionException, InterruptedException {
        MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
        config.setServiceURL(MwsEndpoints.NA_PROD.toString());
        MarketplaceWebServiceOrdersAsyncClient client = new MarketplaceWebServiceOrdersAsyncClient("11","12",config);

        GetOrderRequest request = new GetOrderRequest();
        Future<GetOrderResponse> future = client.getOrderAsync(request);
        GetOrderResponse response = future.get();
        System.out.println(response.toXML());
    }
}
