package com.badlogic.drop;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryRepository {
    static Connection verbinding = Database.maakVerbinding();

    public static void insertName(String username) {
        try {
            PreparedStatement myStmt = verbinding.prepareStatement("insert into namen (gebruikersnaam) Select ? Where not exists(select * from namen where gebruikersnaam=?)");
            myStmt.setString(1, username);
            myStmt.setString(2, username);
            Database.query(myStmt);
        } catch (Exception e) {
            System.out.println("Fout met opslaan naam");
        }
    }
}