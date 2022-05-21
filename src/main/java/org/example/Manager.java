package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("manager")
public class Manager extends Staff {
    public Manager(@Value("Igor") String name) {
        super(name);
    }
}
