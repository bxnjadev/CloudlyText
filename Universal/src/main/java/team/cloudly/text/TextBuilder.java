package team.cloudly.text;

import net.md_5.bungee.api.chat.BaseComponent;
import team.cloudly.text.part.TextPartBuilder;
import team.cloudly.text.part.TextPart;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder implements Text {

    private List<TextPart> textParts;

    public TextBuilder(){
        textParts = new ArrayList<>();
    }

    public TextBuilder add(TextPartBuilder partBuilder){
        textParts.add(partBuilder.create());
        return this;
    }

    @Override
    public BaseComponent[] create() {

        BaseComponent[] components = new BaseComponent[textParts.size()];

        for(int i=0;i<textParts.size();i++){
            components[i] = textParts.get(i).getPart();
        }

        return components;
    }
}
