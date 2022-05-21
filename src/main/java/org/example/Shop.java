package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Shop {
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
    
    @PostConstruct
    public void onInitialize() {
        System.out.println("Создан бин Shop");
    }
    
    @PreDestroy
    public void onDestroy() {
        System.out.println("Разрушен бин Shop");
    }
}
