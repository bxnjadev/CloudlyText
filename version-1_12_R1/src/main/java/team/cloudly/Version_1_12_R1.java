package team.cloudly;

import team.cloudly.title.Title;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.ChatMessage;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.ChatMessageType;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Version_1_12_R1 implements CloudlyText, NMS {

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
        PacketPlayOutChat packetChat = new PacketPlayOutChat(baseComponent, ChatMessageType.GAME_INFO);
        sendPacket(player,packetChat);
    }

    @Override
    public void sendPacket(Player player, Object packet) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet) packet);
    }

}
