package com.example.fg;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    static String pathToDB = "C:\\Users\\ba_in\\IdeaProjects\\FoxGeese\\src\\main\\resources\\database\\foxandgeesedb.db";

    public void insertIntoDB(String name, int points, String role) {

        String query = "INSERT INTO results VALUES (null, '" + name + "', '" + points + "', '" + role + "')";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + pathToDB);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            System.out.println("Written to db.");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Collects score info from DB
    public List<Table> getNames(String role) {
        int top = 10;   // The number of showed results
        int place = 0;  // This variable is used to represent the place from 1 to 'top'
        String query_f = "SELECT name, points, role FROM results WHERE role = '" + role + "' ORDER BY points DESC LIMIT '" + top + "'";    // Collects names and points descending by points
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + pathToDB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_f);
            List<Table> returnValues = new ArrayList<>();
            while (resultSet.next()) {
                place++;
                returnValues.add(new Table(place, resultSet.getString("name"), resultSet.getInt("points")));
                System.out.println(place + "\t" + resultSet.getString("name") + "\t" + resultSet.getInt("points") + " "+role);
            }
            return returnValues;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
/*
    public static void main(String[] args) throws SQLException {
        DataBase db = new DataBase();

        String name = "Janis";
        int points = 5;
        db.insertIntoDB(name, points);
        db.readFromDB();

    }
 */

