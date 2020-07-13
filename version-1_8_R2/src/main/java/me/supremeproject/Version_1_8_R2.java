package me.supremeproject;

import me.supremeproject.message.Message;
import me.supremeproject.objects.Title;
import net.minecraft.server.v1_8_R2.*;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Version_1_8_R2 implements SupremeText {

    @Override
    public void sendMessage(Player player, Message message) {
        IChatBaseComponent baseComponent = IChatBaseComponent.ChatSerializer.a(message.getJson().toJSONString());
        PacketPlayOutChat packetChat = new PacketPlayOutChat(baseComponent);
        sendPacket(player,packetChat);
    }

    @Override
    public void sendTitle(Player player, Title title) {
        IChatBaseComponent titleText = new ChatMessage(title.getTitle());
        IChatBaseComponent subtitleText = new ChatMessage(title.getSubtitle());

        int fadeInTime = title.getFadeInTime();
        int fadeShowTime = title.getFadeShowTime();
        int fadeOutTime = title.getFadeOutTime();

        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.TITLE, titleText,fadeInTime,fadeShowTime,fadeOutTime);

        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(
                PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleText,fadeInTime,fadeShowTime,fadeOutTime);

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
