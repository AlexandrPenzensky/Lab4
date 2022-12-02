package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для прочтения информации о человеке из CSV-файла
 */
public class CSVPersonReader {
    private char separator;
    private StringBuilder stringBuilder;
    private List<PersonInfo> List;

    /**
     * Получить информацию о человеке ввиде списка
     * @return - список
     */
    public List<PersonInfo> getInfo() { return List; }

    /**
     * Разделяет строку на поля класса PersonInfo по символу separator
     * @return - строку
     */
    String Separate() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; stringBuilder.charAt(i) != separator; i++)
            sb.append(stringBuilder.charAt(i));
        stringBuilder.delete(0, i+1);
        return sb.toString();
    }

    /**
     * Инициализирует объект класса PersonInfo
     * @param stringBuilder - строка CSV-файла
     * @return - объект класса PersonInfo
     */
    PersonInfo initPersonInfo(String stringBuilder) {
        this.stringBuilder = new StringBuilder(stringBuilder);
        this.stringBuilder.delete(0,1);
        this.stringBuilder.delete(this.stringBuilder.length()-1, this.stringBuilder.length());
        PersonInfo tmpPerson = new PersonInfo();
        tmpPerson.ID = Integer.parseInt(Separate());
        tmpPerson.NAME = Separate();
        tmpPerson.GENDER = Separate();
        tmpPerson.BIRTDATE = Separate();
        tmpPerson.DIVISION = new Division(Separate());
        tmpPerson.SALARY = Integer.parseInt(this.stringBuilder.toString());
        return tmpPerson;
    }

    /**
     * Конструктор класса выполняет чтение CSV-файла в список
     * @param file_name - название файла
     * @param separator - символ-разделитель
     */
    CSVPersonReader(String file_name, char separator) {
        List = new LinkedList<>();
        this.separator = separator;
        try {
            CSVReader reader = new CSVReader(new FileReader(file_name));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                List.add(initPersonInfo(Arrays.toString(nextLine)));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
