package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.io.File;
import java.nio.file.Path;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String msg = update.getMessage().getText();
        String id = update.getMessage().getChatId().toString();
        if (msg.equals("file")){
            SendDocument sendDocument = new SendDocument();
            sendDocument.setDocument(new InputFile(new File("results.json")));
            sendDocument.setChatId(id);
            try {
                execute(sendDocument);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "JavaBOtHTTPConnection_bot";
    }
    public String getBotToken(){
        return "6844348727:AAEuKHyWeS7sJoECfpPHMH7OkFbqfBWcquU";
    }
}
