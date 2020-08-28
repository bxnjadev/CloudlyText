package team.cloudly.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.configuration.ConfigurationSection;
import team.cloudly.message.action.Action;
import team.cloudly.message.action.ActionType;

import java.util.ArrayList;
import java.util.List;

public class MessageBuilder implements Message {

    private final String message;
    private ChatColor color;
    private Action action;

    private final StringBuilder hoverBuilder = new StringBuilder();

    public MessageBuilder(String message){
        this.message = message;
    }

    public MessageBuilder setColor(ChatColor color){
        this.color = color;
        return this;
    }

    public MessageBuilder setHover(String text){
        hoverBuilder.append(ChatColor.translateAlternateColorCodes('&',text)).append("\n");
        return this;
    }

    private MessageBuilder setAction(Action action){
        this.action = action;
        return this;
    }

    @Override
    public BaseComponent create() {

        TextComponent textComponent = new TextComponent(message);

        if(color != null){
            textComponent.setColor(color);
        }

        if(action != null){
            switch (action.getActionType()) {
                case COMMAND:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,action.getIdentifier()));

                case SUGGEST:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,action.getIdentifier()));

                default:
                    textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,action.getIdentifier()));
            }
        }

        if(!hoverBuilder.toString().isEmpty()){

            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(hoverBuilder.toString()).create()));
        }

        return textComponent;
    }

    public static BaseComponent buildByConfig(ConfigurationSection section){
        String message = section.getString("text");
        MessageBuilder builder = new MessageBuilder(message);

        if(section.contains("color")){
            builder.setColor(ChatColor.valueOf(section.getString("color")));
        }

        if(section.contains("type") && section.contains("value")){

            ActionType actionType = ActionType.valueOf(section.getString("type"));
            String value = section.getString("value");

            builder.setAction(new Action(actionType,value));
        }

        if(section.contains("hover")){

            List<String> hover = section.getStringList("hover");
            hover.forEach(builder::setHover);
        }

        return builder.create();
    }


}
