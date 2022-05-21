package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Configuration
public class Shop {
    private static final Logger logger = LoggerFactory.getLogger(Shop.class);
    
    @Autowired // DI через поле
    private Manager manager; 
    
    private Accountant accountant;
    private Staff intern;
    
    @Autowired // DI через конструктор
    public Shop(@Qualifier("accountant") Staff staff) {
        intern = staff;
    }
    
    @Autowired // DI через сеттер
    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }
    
    public void listStaff() {
        System.out.println("Manager: " + manager.name);
        System.out.println("Accountant: " + accountant.name);
        System.out.println("Intern: " + intern.name);
    }
    
    @PostConstruct // Логгирование про создании
    public void onInitialize() {
        logger.info("Создан бин Shop");
    }
    
    @PreDestroy // Логгирование про разрушении
    public void onDestroy() {
        logger.info("Разрушен бин Shop");
    }
}
