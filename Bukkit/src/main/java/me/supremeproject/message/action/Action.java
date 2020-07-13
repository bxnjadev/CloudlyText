package me.supremeproject.message.action;

public class Action {
    private ActionType actionType;
    private String value;

    public Action(ActionType actionType, String value){
        this.actionType = actionType;
        this.value = value;
    }

    public ActionType getAction(){
        return actionType;
    }

    public String getValue(){
        return value;
    }
}
