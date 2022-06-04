package model;

import handler.MathOperationHandler;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;

import java.util.List;

public class ResendMessageManager {
    private MathOperationHandler mathOperationHandler = new MathOperationHandler();
    public boolean isMessageFits(String message){
        if(message.matches("[\\p{L}| ]+")){
            return true;
        }
        return false;
    }

    public void resendRandomMessage(MessageChannel channel){
        MessageHistory history = MessageHistory.getHistoryFromBeginning(channel).limit(100).complete();
        List<Message> messages = history.getRetrievedHistory();
        String randomMessage = getRandomMessage(messages);
        if(isMessageFits(randomMessage)){
            channel.sendMessage(randomMessage).queue();
        }else{
            resendRandomMessage(channel);
        }
    }
    public String getRandomMessage(List<Message> messages){
        return  messages.get(mathOperationHandler.GetRandomRange(messages.size()))
                .getContentRaw() +" "+messages.get(mathOperationHandler.GetRandomRange(messages.size()))
                .getContentRaw();
    }
}
