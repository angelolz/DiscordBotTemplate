package schedulers;

import main.LoggerManager;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class ScheduledTasks extends ListenerAdapter
{
    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        LoggerManager.init();
        LoggerManager.setJda(event.getJDA());

        //put anything that needs to be initialized when the bot is ready
    }
}
