package ru.live.kamaz_cs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        File file = new File("json.txt");
        StringBuilder sb = new StringBuilder();
        String result = performRequest(file);
        System.out.println(result);

        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result, JSON.class);

        sb.append("Name: " + json.name + "\n" + "Surname: " + json.surname + "\n" + "Phones: " + Arrays.toString(json.phones) +
                "\n" + "Sites: " + Arrays.toString(json.sites) + "\n" +
                "\n" + "Adress: " + "\n" + "Country: " + json.address.country + "\n" + "City: " + json.address.city +
                "\n" + "Street: " + json.address.street);
        System.out.println(sb.toString());
    }

    private static String performRequest(File file) {

        StringBuilder sb = new StringBuilder();
        String st = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (; (st = br.readLine()) != null; ) {
                sb.append(st).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
