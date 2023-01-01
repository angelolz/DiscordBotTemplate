package main;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import main.commands.Help;
import main.commands.Ping;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.util.Properties;

public class DiscordBot
{
    private static final String PREFIX = "!"; // this is for text commands
    private static final String VERSION = "0.0.0";
    private static Logger logger;
    private static long uptime;

    public static void main(String[] args) throws IllegalArgumentException
    {
        try(FileInputStream propFile = new FileInputStream("bot.properties"))
        {
            //logger
            logger = LoggerFactory.getLogger(DiscordBot.class);

            //gets tokens and stuff
            Properties prop = new Properties();

            prop.load(propFile);
            String token = prop.getProperty("bot_token");
            String ownerId = prop.getProperty("owner_id");

            //create command builders and listeners
            CommandClientBuilder client = new CommandClientBuilder();

            //bot client config
            client.useHelpBuilder(false)
                .setOwnerId(ownerId)
                .setActivity(Activity.playing("with deez nuts lol | !help"))
                .setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26")
                .setPrefix(PREFIX);

            client.addSlashCommands(
                new Help(),
                new Ping()
            );

            uptime = System.currentTimeMillis();

            DefaultShardManagerBuilder.createLight(token)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("loading!"))
                .addEventListeners(client.build())
                .build();
        }

        catch(LoginException e)
        {
            logger.error("Unable to login with bot token: {}", e.getMessage());
            e.printStackTrace();
        }

        catch(Exception e)
        {
            logger.error("oops, unknown exception: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getVersion()
    {
        return VERSION;
    }

    public static String getPrefix()
    {
        return PREFIX;
    }

    public static Logger getLogger()
    {
        return logger;
    }

    public static String getUptime()
    {
        long ms = System.currentTimeMillis() - uptime;
        int days;
        int hours;
        int minutes;
        int seconds;
        String result;

        seconds = (int) ((ms / 1000) % 60);
        minutes = (int) ((ms / (1000*60)) % 60);
        hours = (int) ((ms / (1000*60*60)) % 24);
        days = (int) (ms / (1000*60*60*24));

        result = days + " days, " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds";
        return result;
    }
}