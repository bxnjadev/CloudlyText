package team.cloudly;

import org.bukkit.entity.Player;

public interface NMS {

    void sendPacket(Player player, Object packet);

}
