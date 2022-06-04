package controller;

import botapi.BotSettings;
import model.CallbackCommandManager;
import model.ResendIntervalMessageManager;
import model.ResendMessageManager;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import service.InputMessagesService;

import java.util.Arrays;

public class ProcessingInputMessages extends ListenerAdapter {

    private BotSettings botSettings = new BotSettings();
    private CallbackCommandManager callbackCommandManager = new CallbackCommandManager();
    private ResendIntervalMessageManager intervalMessageManager = new ResendIntervalMessageManager();
    public void onMessageReceived(MessageReceivedEvent event)
    {
     callbackCommandManager.searchCommand(event,botSettings);
     if(botSettings.getWriteBySelf()){
         intervalMessageManager.ResendIntervalMessage(botSettings.getInterval(), event.getChannel());
     }


    }
}
