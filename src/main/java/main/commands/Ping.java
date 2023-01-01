package main.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Ping extends SlashCommand
{
    public Ping() {
        this.name = "ping";
        this.help = ":ping_pong: Pong!";
        this.cooldown = 3;
    }

    @Override
    protected void execute(SlashCommandEvent slashCommandEvent)
    {
        long time = System.currentTimeMillis();
        String message = ":ping_pong: | Pong!";

        slashCommandEvent.reply(message + " ...").queue(
            s -> s.editOriginalFormat(message + " %dms", System.currentTimeMillis() - time).queue()
        );
    }
}
