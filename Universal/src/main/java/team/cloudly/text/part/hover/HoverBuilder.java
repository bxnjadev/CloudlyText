package team.cloudly.text.part.hover;

import java.util.List;

public class HoverBuilder {

    private StringBuilder hover;
    public HoverBuilder(String text){
        this();
        append(text);
    }

    public HoverBuilder(){
        hover = new StringBuilder();
    }

    public HoverBuilder append(String text){
        hover.append(text).append("\n");
        return this;
    }

    public HoverBuilder append(List<String> stringList){
        stringList.forEach(this::append);
        return this;
    }

    public String create(){
        hover.delete(hover.length()-2,hover.length());
        return hover.toString();
    }

}
