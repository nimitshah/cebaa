package ns.dp.cebaa.controller;

import ns.dp.cebaa.Application;
import ns.dp.cebaa.dao.BankRepository;
import ns.dp.cebaa.domain.Bank;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:9000")
public class HelloWorldResourceTest {

    RestTemplate restTemplate = new TestRestTemplate();

    String helloWorldUrl = "http://localhost:9000/hello/world";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BankRepository bankRepository;

    @Before
    public void setup(){
        bankRepository.deleteAll();
    }

    @After
    public void teardown(){
        bankRepository.deleteAll();
    }

    @Test
    public void testHello() throws Exception {
        String res = restTemplate.getForObject(helloWorldUrl, String.class);
        assertThat(res, is("Hello, world!"));
        List<Map<String, Object>> banks = jdbcTemplate.queryForList("select * from BANK");
        assertThat(banks.size(), is(1));
        assertThat(banks.get(0).get("NAME"), is("world"));
    }
}