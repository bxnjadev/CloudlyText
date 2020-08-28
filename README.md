# CloudlyText
SupremeText is an API to send json messages, messages with titles and messages in the action bar.

## Use
first you create a variable of type SupremeText.

```
  SupremeText supremeText;
  
  @Override
  public void onEnable(){
     supremeText = VersionFactory.getAPI();
  }
```

## Send Title 

You must create an object of type title

```  
Title title = new Title("title","subtitle",fadeInTime,fadeShowTime,fadeOutTime);
```  
And send it with this method
```  
supremeText.sendTitle(player,title);
```

## Send ActionBar

```
  supremeText.sendActionBar(player,"this is actionbar");
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

## Supported versions

- [X] 1_8_R1
- [X] 1_8_R2
- [X] 1_8_R3
- [X] 1_9_R1
- [X] 1_9_R2
- [X] 1_10_R1
- [X] 1_11_R1
- [X] 1_12_R1
- [X] 1_13_R1
- [X] 1_13_R2
- [X] 1_14_R1
- [X] 1_15_R1
- [X] 1_16_R1

enjoy!


