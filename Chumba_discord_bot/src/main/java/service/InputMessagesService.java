package service;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InputMessagesService extends ListenerAdapter {

    private static int inputMessagesCount;
    public int getInputMessagesCount(){
        return inputMessagesCount;
    }
    public void resetInputMessagesCount(){
         inputMessagesCount = 0;
    }
    public void onMessageReceived(MessageReceivedEvent event)
    {
        inputMessagesCount++;
    }
}
