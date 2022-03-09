package com.example.fg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    DataBase db = new DataBase();

    @Test
    void insertIntoDB() {
        db.insertIntoDB("TESTUKAS", 1, "T");
    }

    @Test
    void getNames() {
        System.out.println(db.getNames("T"));
       // assertEquals("TESTUKAS",db.getNames("T"));
    }
}