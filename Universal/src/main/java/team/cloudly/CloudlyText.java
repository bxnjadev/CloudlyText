package team.cloudly;

import team.cloudly.objects.Title;
import org.bukkit.entity.Player;

public interface CloudlyText {

    void sendTitle(Player player, Title title);

    void sendActionBar(Player player, String text);

}
