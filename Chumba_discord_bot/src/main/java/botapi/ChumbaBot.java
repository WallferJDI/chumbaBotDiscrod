package botapi;

import controller.ProcessingInputMessages;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import service.InputMessagesService;

import javax.security.auth.login.LoginException;

public class ChumbaBot  extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder.createLight("", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new ProcessingInputMessages())
                .addEventListeners(new InputMessagesService())
                .setActivity(Activity.playing("Type !message"))
                .build();
    }
}
