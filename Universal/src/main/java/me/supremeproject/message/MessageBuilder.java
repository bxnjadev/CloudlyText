package me.supremeproject.message;

import me.supremeproject.message.action.Action;

public class MessageBuilder {
    private String message;
    private HoverBuilder hoverBuilder;
    private Action action;

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

    public String getMessage(){
        return message;
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
