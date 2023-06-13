package main;

import org.slf4j.Logger;

public class DiscordBot
{
    public static void main(String[] args)
    {
        try
        {
            LoggerManager.init();
            ConfigManager.init();
            DatabaseManager.init();
            BotManager.init();
        }

        catch(Exception e)
        {
            System.out.println("oops");
            e.printStackTrace();
        }
    }
}