package main;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.*;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import schedulers.ScheduledTasks;

public class BotManager
{
    private static long uptime;

    public static void init()
    {
        //create command builders and listeners
        CommandClientBuilder client = new CommandClientBuilder();

        //bot client config
        client.useHelpBuilder(false);
        client.setActivity(Activity.playing("with Discord! | " + ConfigManager.getPrefix() + "help"));
        client.setOwnerId(ConfigManager.getOwnerId());
        client.setEmojis("✅", "⚠️", "❌");
        client.setPrefix(ConfigManager.getPrefix());

        //slash commands here
        client.addSlashCommands(
            new Help(),
            new Ping()
        );

        //non-hidden commands
        client.addCommands(
            new Help(),
            new Ping()
        );

        // TODO ONLY FOR TESTING
        client.forceGuildOnly("695074147071557632");

        DefaultShardManagerBuilder.createLight(ConfigManager.getToken())
                                  .setStatus(OnlineStatus.DO_NOT_DISTURB)
                                  .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                                  .setActivity(Activity.playing("loading!! | " + ConfigManager.getPrefix() + "help"))
                                  .addEventListeners(client.build(), new ScheduledTasks())
                                  .build();

        uptime = System.currentTimeMillis();
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
        minutes = (int) ((ms / (1000 * 60)) % 60);
        hours = (int) ((ms / (1000 * 60 * 60)) % 24);
        days = (int) (ms / (1000 * 60 * 60 * 24));

        result = days + " days, " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds";
        return result;
    }
}
