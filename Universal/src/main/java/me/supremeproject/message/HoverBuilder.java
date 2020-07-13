package me.supremeproject.message;

import java.util.List;

public class HoverBuilder {
    StringBuilder hover;

    public HoverBuilder(String text){
        hover = new StringBuilder(text).append("\n");
    }

    public HoverBuilder append(String text){
        hover.append(text).append("\n");
        return this;
    }

    public HoverBuilder append(List<String> text){
        text.forEach(this::append);
        return this;
    }

    public String build(){
        return hover.toString();
    }

}
