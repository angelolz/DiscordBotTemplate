package schedulers;

import main.LoggerManager;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ScheduledTasks extends ListenerAdapter
{
    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        //put anything that needs to be initialized when the bot is ready
    }
}
