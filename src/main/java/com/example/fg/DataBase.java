package com.example.fg;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    static String pathToDB = "C:\\Users\\ba_in\\IdeaProjects\\FoxGeese\\src\\main\\java\\com\\example\\fg\\foxandgeesedb.db";

    public void insertIntoDB(String name, int points) {

        String query = "INSERT INTO results VALUES (null, '" + name + "', '" + points + "')";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + pathToDB);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            System.out.println("written to db");
        } catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }



    // @Override
    public List<Table> getNames(){
        int top = 10;
        int place = 0;
        String query = "SELECT * FROM results ORDER BY points DESC LIMIT '"+top+"'";
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + pathToDB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Table> returnValues = new ArrayList<>();
            while (resultSet.next()) {
                place ++;
                returnValues.add(new Table(place, resultSet.getString("name"), resultSet.getInt("points")));
                //System.out.println(place + "\t" + resultSet.getString("name") + "\t" + resultSet.getInt("points"));
                //connection.close();
            }
            return returnValues;

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
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
}
