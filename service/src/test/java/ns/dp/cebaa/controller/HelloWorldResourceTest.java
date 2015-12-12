package ns.dp.cebaa.controller;

import ns.dp.cebaa.Application;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:9000")
public class HelloWorldResourceTest {

    RestTemplate restTemplate = new TestRestTemplate();

    String helloWorldUrl = "http://localhost:9000/hello/world";

    @Test
    public void testHello() throws Exception {
        String res = restTemplate.getForObject(helloWorldUrl, String.class);
        assertThat(res, is("Hello, world!"));
    }
}