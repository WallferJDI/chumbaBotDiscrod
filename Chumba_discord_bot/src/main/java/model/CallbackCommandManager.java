package model;

import botapi.BotSettings;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class CallbackCommandManager {
    private ResendMessageManager resendMessageManager = new ResendMessageManager();
    public void searchCommand(MessageReceivedEvent event, BotSettings botSettings){
        Message msg = event.getMessage();
        String[] splitedCommands = msg.getContentRaw().split("\\b+");
        if ( Arrays.asList(splitedCommands).contains("!"))
        {
            MessageChannel channel = event.getChannel();
            if ( Arrays.asList(splitedCommands).contains("message"))
            {
                resendMessageManager.resendRandomMessage(channel);
                channel.purgeMessages(msg);
            }
            if ( Arrays.asList(splitedCommands).contains("settings"))
            {
                channel.sendMessage( botSettings.getSettingsInfo()).queue();
                channel.purgeMessages(msg);
            }
            if ( Arrays.asList(splitedCommands).contains("setInterval"))
            {
                try{
                    int value = Integer.parseInt(msg.getContentRaw().replaceAll("[^0-9]", ""));
                    botSettings.setInterval(value);
                }catch (Exception e){
                    channel.sendMessage("Введите верное значение").queue();
                }

                channel.sendMessage( botSettings.getInterval() + " interval set").queue();
                channel.purgeMessages(msg);
            }
            if ( Arrays.asList(splitedCommands).contains("setWriteBool"))
            {
                try{

                    botSettings.setWriteBySelf(Boolean.parseBoolean(splitedCommands[splitedCommands.length -1]) );
                }catch (Exception e){
                    channel.sendMessage("Введите верное значение").queue();
                }
                channel.purgeMessages(msg);
            }
        }

    }

}
