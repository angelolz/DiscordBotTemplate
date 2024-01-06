package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager
{
    private static Logger logger;

    public static Logger getLogger()
    {
        if(logger == null)
            logger = LoggerFactory.getLogger(DiscordBot.class);

        return logger;
    }
}


