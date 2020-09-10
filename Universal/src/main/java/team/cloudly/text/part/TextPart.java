package team.cloudly.text.part;

import net.md_5.bungee.api.chat.BaseComponent;

public interface TextPart {

    BaseComponent getPart();

    static PartTextBuilder of(String text){
      return new PartTextBuilder(text);
    }

}
