package ns.dp.cebaa.controller;

import ns.dp.cebaa.dao.AccountTypeRepository;
import ns.dp.cebaa.domain.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    private Logger log = LoggerFactory.getLogger(HelloWorldResource.class);

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {

        AccountType accountType = new AccountType();
        accountType.setAccountType("Current");
        accountTypeRepository.save(accountType);
        log.info("accounts -- "+jdbcTemplate.queryForList("SELECT * FROM ACCOUNT_TYPE"));
        return "Hello, " + name + "!";
    }
}
