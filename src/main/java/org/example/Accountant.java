package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("accountant")
public class Accountant extends Staff {
    public Accountant(@Value("Alexander") String name) {
        super(name);
    }
}
