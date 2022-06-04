package model;

import botapi.BotSettings;
import net.dv8tion.jda.api.entities.MessageChannel;
import service.InputMessagesService;

public class ResendIntervalMessageManager extends ResendMessageManager {

    private InputMessagesService inputMessagesService = new InputMessagesService();
    public void ResendIntervalMessage(int botSettingsInterval, MessageChannel channel){
        if(inputMessagesService.getInputMessagesCount() > botSettingsInterval){
            resendRandomMessage(channel);
            inputMessagesService.resetInputMessagesCount();
        }
    }
}
