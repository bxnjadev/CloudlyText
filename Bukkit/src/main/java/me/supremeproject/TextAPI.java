package me.supremeproject;

import org.bukkit.Bukkit;

public class TextAPI {

    public static SupremeText getAPI(){
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        if (version.contains("1_8_R3")) {
            return new Version_1_8_R3();
        }

        return null;
    }

}
