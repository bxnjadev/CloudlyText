package team.cloudly.text;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import team.cloudly.text.part.PartTextBuilder;
import team.cloudly.text.part.TextPart;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder implements Text {

    List<TextPart> textParts;

    public TextBuilder(){
        textParts = new ArrayList<>();
    }

    public TextBuilder add(PartTextBuilder partBuilder){
        textParts.add(partBuilder.create());
        return this;
    }

    @Override
    public BaseComponent create() {
        TextPart textPart = textParts.get(0);
        textParts.remove(textPart);

        if(textParts.isEmpty()){
            return textPart.getPart();
        }

        BaseComponent baseComponent = textPart.getPart();

        textParts.forEach(part -> {
            baseComponent.addExtra(part.getPart());
        });

        return baseComponent;
    }
}
