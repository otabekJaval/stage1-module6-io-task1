package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class FileReader {

    public  Profile getDataFromFile(File file) {

        if (!file.exists()) {
            System.out.println("File not found.");
            return null;
        }

        try (FileInputStream in = new FileInputStream(file)) {

            byte[] bytes = in.readAllBytes();

            String res = new String(bytes);


            String[] split = res.split("\n");


            String name=split[0].substring(split[0].lastIndexOf(" ")).trim();

            split[1]=split[1].substring(split[1].lastIndexOf(" ")).trim();

            int age=Integer.parseInt(split[1]);

            String email=split[2].substring(split[2].lastIndexOf(" ")).trim();

            String longStr=split[3].substring(split[3].lastIndexOf(" ")).trim();

            long phone=Long.parseLong(longStr);


            return new Profile(name, age, email, phone);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
