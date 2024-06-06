package main;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import enums.LogLevel;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager
{
    private static HikariDataSource ds;

    public static void init() throws SQLException
    {
        String configFile = "db.properties";
        HikariConfig cfg = new HikariConfig(configFile);
        ds = new HikariDataSource(cfg);
        ds.getConnection();
        LoggerManager.sendLogMessage(LogLevel.INFO, "Connected to database successfully!");
    }

    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }
}
