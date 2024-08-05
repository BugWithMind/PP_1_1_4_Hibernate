package jm.task.core.jdbc.util;

import java.util.Properties;
import org.hibernate.cfg.Configuration;
import java.util.logging.Level;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    // Connect to MySQL
    public static Connection getMySQLConnection() throws SQLException {
        String hostName = "localhost";

        String dbName = "pp_1_1_3-4";
        String userName = "root";
        String password = "12345678910";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException {
        // Declare the class Driver for MySQL DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
        //Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(connectionURL, userName, password);
    }

    public static Configuration getMySQLConfiguration() {
        Properties prop = new Properties();
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pp_1_1_3-4");

        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "12345678910");

        //prop.setProperty("hibernate.show_sql", "true"); //If you wish to see the generated sql query
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        return new Configuration().addProperties(prop)
                .addAnnotatedClass(jm.task.core.jdbc.model.User.class);
    }

}
