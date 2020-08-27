package team.cloudly.message.action;

public class Action {

    private final ActionType actionType;
    private final String identifier;

    public Action(ActionType actionType, String identifier){
        this.actionType = actionType;
        this.identifier = identifier;
    }

    public ActionType getActionType(){
        return actionType;
    }

    public String getIdentifier(){
        return identifier;
    }

}
