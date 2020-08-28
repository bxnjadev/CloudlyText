# CloudlyText [![Codacy Badge](https://app.codacy.com/project/badge/Grade/b55650a2b8194c5397f8e96495c27e32)](https://www.codacy.com/gh/CloudlyTeam/CloudlyText?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CloudlyTeam/CloudlyText&amp;utm_campaign=Badge_Grade)

CloudlyText is an API to send json messages, messages with titles and messages in the action bar.

## Use
first you create a instance of type CloudlyText.

```
  private CloudyText cloudlyText;
  
  @Override
  public void onEnable(){
     TextFactory textFactory = new TextFactory();
      cloudlyText = textFactory.getTextVersion();
  }
```

## Send Title 

You must create an object of type title

```  
Title title = new Title("title","subtitle",fadeInTime,fadeShowTime,fadeOutTime);
```  
And send it with this method
```  
cloudlyText.sendTitle(player,title);
```

## Send ActionBar

```
  cloudlyText.sendActionBar(player,"this is actionbar");
```

## Send json message
you must first create a BaseComponent with BuilderMessage and send

```
BaseComponent baseComponent = new BuilderMessage("Hello world")
                              .setHover("this is a hover")
                              .setAction(new Action(ActionType.COMMAND,"gamemode creative"));
                              .build();
                              
#player.spigot().sendMessage(baseComponent);     
```                 
enjoy!


