package me.supremeproject.message;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Message {
    private JSONArray jsonArray;

    public Message(MessageBuilder builder) {
        jsonArray = new JSONArray();
        add(builder);
    }

    public void add(String text){
        MessageBuilder builder = new MessageBuilder(text)
                .setHover(null)
                .setAction(null);
        add(builder);
    }

    public void add(MessageBuilder builder){
        JSONObject objectText = new JSONObject();
        objectText.put("text",builder.getMessage());

        if(builder.getAction() != null){
            JSONObject objectAction = new JSONObject();
            objectAction.put("action",builder.getAction().getAction().toString().toLowerCase());
            objectAction.put("value",builder.getAction().getValue());
            objectText.put("clickEvent",objectAction);
        }

        if(builder.getHover() != null){
            JSONObject objectHover = new JSONObject();
            objectHover.put("action","show_text");

            JSONArray arrayHover = new JSONArray();
            JSONObject objectArrayHover = new JSONObject();
            objectArrayHover.put("text",builder.getHover().build());
            arrayHover.add(objectArrayHover);

            objectHover.put("value",arrayHover);

            objectText.put("hoverEvent",objectHover);
        }

        jsonArray.add(objectText);
    }

    public JSONArray getJson() {
        return jsonArray;
    }
}
