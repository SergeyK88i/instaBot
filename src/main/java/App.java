import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String TOKEN = "1813435953:AAHKOCwjFdQG7l6-BWcerQ_UJUyvzR6xBv0";

        Map<Integer, User> users = new HashMap<>();

        TelegramBot bot = new TelegramBot(TOKEN);

        bot.setUpdatesListener(updates -> {
            updates.forEach(System.out::println);

            updates.forEach(update -> {
                Integer userId = update.message().from().id();
                //проверка наличия логина и пароля
                if (!users.containsKey(userId)) {
                    bot.execute(new SendMessage(update.message().chat().id(),
                            "вам необходимо прислать логин и пароль в одном предложении через пробел"));
                    users.put(userId, null);

                } else if (users.get(userId) == null){ // запись логин и пароль
                    String[] loginAndPassword = update.message().text().split(" ");
                    User user = new User(loginAndPassword[0], loginAndPassword[1]);
                    users.put(userId, user);
                    bot.execute(new SendMessage(update.message().chat().id(),
                            "Все работает, теперь вы можете отпрвлять текст и фото в одном сообщении."));
                } else {
                    System.out.println(update.toString());
                }

            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

}
