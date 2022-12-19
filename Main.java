package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) {
    // Replace myServer, myUser, myPassword, and myDB with the actual values for your server
    String connectionUrl = System.getenv("DB");

    try (Connection connection = DriverManager.getConnection(connectionUrl)) {
      // If the connection was successful, you can now perform various database operations
      System.out.println("Connected to Database - "+connectionUrl+" is Success");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
