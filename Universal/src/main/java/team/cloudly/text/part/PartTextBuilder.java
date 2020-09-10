package team.cloudly.text.part;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import team.cloudly.text.part.action.ActionClick;
import team.cloudly.text.part.hover.HoverBuilder;

public class PartTextBuilder {

    private final String message;
    private ChatColor color;
    private String hover;
    private ActionClick actionClick;

    public PartTextBuilder(String message){
        this.message = message;
    }

    public PartTextBuilder setColor(ChatColor color){
        this.color = color;
        return this;
    }

    public PartTextBuilder setActionClick(ActionClick actionClick){
        this.actionClick = actionClick;
        return this;
    }

    public PartTextBuilder setHover(HoverBuilder hoverBuilder){
        hover = hoverBuilder.create();
        return this;
    }

    public TextPart create(){
        TextComponent textComponent = new TextComponent(message);

        if(color != null){
            textComponent.setColor(color);
        }

        if(hover != null){
            textComponent.setHoverEvent(
                    new HoverEvent(HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(hover).create()));
        }

        if(actionClick != null){
            switch (actionClick.getActionTypeClick()){

                case COMMAND:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,actionClick.getValue()));
                case LINK:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,actionClick.getValue()));
                default:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,actionClick.getValue()));

            }

        }

        return new SimplePart(textComponent);
    }



}
