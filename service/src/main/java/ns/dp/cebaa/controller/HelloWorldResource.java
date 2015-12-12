package ns.dp.cebaa.controller;

import ns.dp.cebaa.dao.BankRepository;
import ns.dp.cebaa.domain.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @Autowired
    private BankRepository bankRepository;

    private Logger log = LoggerFactory.getLogger(HelloWorldResource.class);

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        Bank bank = new Bank();
        bank.setName(name);
        bankRepository.save(bank);
        return "Hello, " + name + "!";
    }
}
