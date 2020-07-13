# SupremeText
Json message API 

SupremeText is an api to send messages with titles and messages in actionbar.

##Use
first you create a variable of type SupremeText.

```
  
  SupremeText supremeText;
  
  @Override
  public void onEnable(){
     supremeText = TextAPI.getAPI();
  }
 
```

##Send Title 

```

  supremeText.sendTitle(player,"title","subtitle",20,20,20);

```

##Send ActionBar

```

  supremeText.sendActionBar(player,"this is actionbar");

```

###Send json message
you must first create a Message variable, help yourself with MessageBuilder

```

Message message = new MessageBuilder("This is a json message")
                       .setAction(new Action(ActionType.RUN_COMMAND,"/say hello"))
                       .setHover(new HoverBuilder("hello").append("everyone"))
                       .buil();
                           
   supremeText.sendMessage(player,message);

```

enjoy!


