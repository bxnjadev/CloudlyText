package me.supremeproject;

import me.supremeproject.message.Message;
import me.supremeproject.objects.Title;
import org.bukkit.entity.Player;

public interface SupremeText {

    void sendMessage(Player player, Message message);

    void sendTitle(Player player, Title title);

    void sendActionBar(Player player, String text);

}
