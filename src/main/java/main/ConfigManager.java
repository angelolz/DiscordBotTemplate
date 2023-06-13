package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager
{
    private static final String PREFIX = "!";
    private static final String VERSION = "0.0.0";
    private static String token;
    private static String ownerId;

    public static void init() throws IOException
    {
        try(FileInputStream propFile = new FileInputStream("config.properties"))
        {
            Properties prop = new Properties();
            prop.load(propFile);
            token = prop.getProperty("bot_token");
            ownerId = prop.getProperty("owner_id");
        }
    }

    public static String getPrefix()
    {
        return PREFIX;
    }

    public static String getVersion()
    {
        return VERSION;
    }

    public static String getToken()
    {
        return token;
    }

    public static String getOwnerId()
    {
        return ownerId;
    }
}
