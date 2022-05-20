package com.nat.cadeaux;

import com.nat.cadeaux.models.Country;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCountryData {

    public static void run() throws IOException, SQLException {

        try {
            URL url = new URL("https://nathan-html.github.io/ISO-3166-Countries/all/all.csv");

            // Patron Decorator
            Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()), "UTF-8");

            // Patron Builder
            CSVFormat csvFormat = CSVFormat.newFormat(';').builder().setHeader().setSkipHeaderRecord(true).build();

            CSVParser csvParser = csvFormat.parse(reader);

            // Patron Iterator
            CSVRecord csvRecord = null;

            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "application.properties";
            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));

            Connection connection = DriverManager.getConnection (appProps.getProperty("spring.datasource.url"), "sa","");
            Statement statement = connection.createStatement();

            Logger logger = Logger.getLogger("AddCountryData");
            Integer id = 0;
            while (csvParser.iterator().hasNext()) {
                csvRecord = csvParser.iterator().next();
                id++;
                String sql =
                        "INSERT INTO country (ISO3166, name) VALUES ('" +
                        csvRecord.get(0).split(",")[1] + "', '" +
                        String.valueOf(csvRecord.get(0).split(",")[0]) + "')";
                try{
                    statement.execute(sql);
                    logger.log(Level.INFO, id + " : Country was add " + csvRecord.get(0).split(",")[0]);
                } catch (Exception e) {
                    logger.log(Level.WARNING, id + " : Country was not add " + csvRecord.get(0).split(",")[0]);
                }

            }

            csvParser.close();
            reader.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Patron Iterator
//        CSVRecord csvRecord = null;
//        for (CSVRecord record : records) {
//            String columnOne = record.get(0);
//            String columnTwo = record.get(1);
//
//            String sql = "INSERT INTO country VALUES ('" + columnTwo + "', '" + columnOne + "')";
//            statement.execute(sql);
//        }
//        connection.close();

    }
}
