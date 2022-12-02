package org.example;

import java.util.Random;

/**
 * Информация о подразделении
 */
public class Division {
    int ID;
    String NAME;
    Division(String NAME) {
        this.NAME = NAME;
        Random random = new Random();
        ID = random.nextInt();
    }
}
