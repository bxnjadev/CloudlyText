package me.supremeproject;

import me.supremeproject.message.Message;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Version_1_8_R3 implements SupremeText {

    @Override
    public void sendMessage(Player player, Message message) {
        IChatBaseComponent baseComponent = IChatBaseComponent.ChatSerializer.a(message.getJson().toJSONString());
        PacketPlayOutChat packetChat = new PacketPlayOutChat(baseComponent);
        sendPacket(player,packetChat);
    }

    @Override
    public void sendTitle(Player player, String title, String subtitle, int time1, int time2, int time3) {
        IChatBaseComponent titleText = new ChatMessage(title);
        IChatBaseComponent subtitleText = new ChatMessage(subtitle);

        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.TITLE, titleText,time1,time2,time3);

        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleText,time1,time2,time3);

        sendPacket(player,titlePacket);
        sendPacket(player,subtitlePacket);
    }

    @Override
    public void sendActionBar(Player player, String text) {
        IChatBaseComponent baseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\"}");
        PacketPlayOutChat packetChat = new PacketPlayOutChat(baseComponent);
        sendPacket(player,packetChat);
    }

    public void sendPacket(Player player, Object object){
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet) object);
    }

}
