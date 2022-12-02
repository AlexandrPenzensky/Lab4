package org.example;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVPersonReader personReader = new CSVPersonReader("foreign_names.csv", ';');
        List<PersonInfo> InfoList = new LinkedList<>(personReader.getInfo());
        for(PersonInfo i: InfoList) {
            System.out.print(i.ID + " ");
            System.out.print(i.NAME + " ");
            System.out.print(i.GENDER + " ");
            System.out.print(i.BIRTDATE + " ");
            System.out.print(i.DIVISION.NAME + " ");
            System.out.print(i.DIVISION.ID + " ");
            System.out.print(i.SALARY + " ");
            System.out.println();
        }
    }
}