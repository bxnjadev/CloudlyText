package team.cloudly.title;

public class Title {

    private final String title;
    private final String subtitle;

    private final int fadeInTime;
    private final int fadeShowTime;
    private final int fadeOutTime;

    public Title(String title, String subtitle){
        this(title,subtitle,20,20,20);
    }

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
