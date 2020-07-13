package me.supremeproject;

import me.supremeproject.message.Message;
import org.bukkit.entity.Player;

public interface SupremeText {

    void sendMessage(Player player, Message message);

    void sendTitle(Player player, String title, String subtitle, int time1, int time2, int time3);

    void sendActionBar(Player player, String text);

}
