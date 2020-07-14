package me.supremeproject.objects;

public class Title {

    private String title;
    private String subtitle;

    private int fadeInTime;
    private int fadeShowTime;
    private int fadeOutTime;

    public Title(String title, String subtitle, int fadeInTime, int fadeShowTime, int fadeOutTime){
        this.title = title;
        this.subtitle = subtitle;
        this.fadeInTime = fadeInTime;
        this.fadeShowTime = fadeShowTime;
        this.fadeOutTime = fadeOutTime;
    }

    public String getTitle(){
        return title;
    }

    public String getSubtitle(){
        return subtitle;
    }

    public int getFadeInTime(){
        return fadeInTime;
    }

    public int getFadeShowTime(){
        return fadeShowTime;
    }

    public int getFadeOutTime(){
        return fadeOutTime;
    }


}
