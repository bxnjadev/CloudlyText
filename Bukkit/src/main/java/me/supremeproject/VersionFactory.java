package me.supremeproject;

import org.bukkit.Bukkit;

public class VersionFactory {

    public SupremeText getVersionAPI(){
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        if(version.contains("1_8_R1")){
            return new Version_1_8_R1();
        }

        if(version.contains("1_8_R2")){
            return new Version_1_8_R2();
        }

        if (version.contains("1_8_R3")) {
            return new Version_1_8_R3();
        }

        if(version.contains("1_9_R1")){
            return new Version_1_9_R1();
        }

        if(version.contains("1_9_R2")){
            return new Version_1_9_R2();
        }

        if(version.contains("1_10_R1")){
            return new Version_1_10_R1();
        }

        if(version.contains("1_11_R1")){
            return new Version_1_11_R1();
        }

        if(version.contains("1_12_R1")){
            return new Version_1_12_R1();
        }

        if(version.contains("1_13_R1")){
            return new Version_1_13_R1();
        }

        if(version.contains("1_13_R2")){
            return new Version_1_13_R2();
        }

        if(version.contains("1_14_R1")){
            return new Version_1_14_R1();
        }

        if(version.contains("1_15_R1")){
            return new Version_1_15_R1();
        }

        if(version.contains("1_16_R1")){
            return new Version_1_16_R1();
        }
        return null;
    }

}
