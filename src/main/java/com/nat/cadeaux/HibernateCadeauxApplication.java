package com.nat.cadeaux;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

@SpringBootApplication
public class HibernateCadeauxApplication {

    public HibernateCadeauxApplication() throws IOException {
    }

    public static void main(String[] args) throws IOException, SQLException {
        /* Create tables */
        SpringApplication.run(HibernateCadeauxApplication.class, args);
        /* Add data to country */
        AddCountryData.run();
    }


}
