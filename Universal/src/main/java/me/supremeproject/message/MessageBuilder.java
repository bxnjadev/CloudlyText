package me.supremeproject.message;

import me.supremeproject.message.action.Action;
import org.bukkit.ChatColor;

public class MessageBuilder {
    private String message;
    private HoverBuilder hoverBuilder;
    private Action action;

    private ChatColor color;

    public MessageBuilder(String message){
        this.message = message;
    }

    public MessageBuilder setAction(Action action){
        this.action = action;
        return this;
    }

    public MessageBuilder setHover(HoverBuilder hoverBuilder){
        this.hoverBuilder = hoverBuilder;
        return this;
    }

    public void append(String text){

    }

    public MessageBuilder setColor(ChatColor color){
        this.color = color;
        return this;
    }

    public String getMessage(){
        return message;
    }

    public ChatColor getColor(){
        return color;
    }

    public HoverBuilder getHover(){
        return hoverBuilder;
    }

    public Action getAction(){
        return action;
    }

    public Message build(){
        return new Message(this);
    }
}
