package base.scene;

import base.Background;
import base.GameObject;
import base.SoundManager;
import base.enemy.EnemyManager;
import base.enemy.EnemyType1;
import base.obstacle.ObstacleManager;
import base.player.Player;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

public class StageScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(EnemyManager.class);
        GameObject.recycle(ObstacleManager.class);
        //urls sound & media
        String[] urls = {"assets/music/sfx/enemy-explosion.wav", "assets/music/sfx/enemy-explosion-big.wav", "assets/music/sfx/item-collect.wav"};
        //load all sound & media
        SoundManager.loadSounds(urls);
        AudioUtils.playMedia(AudioUtils.loadMedia("assets/music/bgm/title.mp3"));//???
    }

    @Override
    public void destroy() {
        GameObject.clearAll();
    }
}
