package base;

import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.util.HashMap;

public class SoundManager {
    public static HashMap<String, Clip> sounds = new HashMap<>();

    public static void loadSounds(String... urls) {
        sounds.clear();
        for(String url: urls) {
            Clip sound = AudioUtils.loadSound(url);
            sounds.put(url, sound);
        }
    }

    public static void playSound(String url) {
        Clip sound = sounds.get(url);
        if(sound != null) {
            AudioUtils.playSound(sound);
        }
    }
}
