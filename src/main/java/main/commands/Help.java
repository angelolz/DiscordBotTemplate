package main.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import main.DiscordBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Help extends SlashCommand
{
    public Help() {
        this.name = "help";
        this.help = "Shows all commands available to be used!";
        this.cooldown = 3;
    }

    @Override
    protected void execute(SlashCommandEvent slashCommandEvent)
    {
        EmbedBuilder embed = new EmbedBuilder();

        //gets id of bot owner
        String ownerId = getClient().getOwnerId();

        //insert info into embed
        slashCommandEvent.getJDA().retrieveUserById(ownerId).queue(
            user -> {

                embed.setTitle("Discord Bot");
                embed.setColor(0x32CD32);
                embed.setDescription("Here are a list of commands you can use!");
                embed.setFooter("Created by " + user.getAsTag() + " | Version " + DiscordBot.getVersion(), user.getAvatarUrl());
                embed.setThumbnail(slashCommandEvent.getJDA().getSelfUser().getAvatarUrl());

                for(SlashCommand command : getClient().getSlashCommands())
                {
                    if(!command.isHidden() && !command.isOwnerCommand())
                    {
                        String commandName = String.format("/%s", command.getName());

                        embed.addField(commandName, command.getHelp(), true);
                    }
                }

                slashCommandEvent.replyEmbeds(embed.build()).queue();
            });
    }
}
