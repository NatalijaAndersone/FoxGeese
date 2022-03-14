package com.example.fg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    DataBase db = new DataBase();

    @Test
    void insertIntoDB() {
        db.insertIntoDB("TEST", 1, "T");

    }


    @Test
    void getNames() {
        System.out.println(db.getNames("T"));
        db.deleteFromDB();
        // assertEquals("TESTUKAS",db.getNames("T"));
    }
}