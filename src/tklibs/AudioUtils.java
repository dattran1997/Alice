package tklibs;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 5/12/17.
 */
@SuppressWarnings("deprecation")
public class AudioUtils {

    /**
     * For playing sound effect: wav
     * @param audioUrl
     * @return
     */
    public static Clip loadSound(String audioUrl) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void playSound(Clip sound) {
        sound.setFramePosition(0);
        sound.start();
    }

    public static void initialize() {
        new javafx.embed.swing.JFXPanel();
    }

    /**
     * For playing background music, must calll intialize first: mp3
     * @param audioUrl
     * @return
     */
    public static MediaPlayer loadMedia(String audioUrl) {
        String uriString = new File(audioUrl).toURI().toString();
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.setAutoPlay(true);
        return mediaPlayer;
    }

    public static void playMedia(MediaPlayer media) {
        media.play();
    }

    public static void main(String[] args) {
        //sound (.wav)
        Clip sound = loadSound("assets/music/sfx/enemy-explosion.wav");
        playSound(sound);

        //music (.mp3)
        initialize();
        MediaPlayer media = loadMedia("assets/music/bgm/ending.mp3");
        playMedia(media);

        while(true) {}
    }
}
