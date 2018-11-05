package base.scene.welcomeScene;

import base.GameObject;
import base.Vector2D;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.StageScene;
import tklibs.SpriteUtils;

public class Banner extends GameObject {

    public Banner() {
        super();
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/scenes/welcome.png"));
        this.position = new Vector2D();
        position.x = 0;
        position.y = 0;
        this.anchor.setThis((float)0,(float)0);
    }

    @Override
    public void run() {
        if(KeyEventPress.isAnyKey){
            SceneManager.signNewScene(new StageScene());
        }
    }
}
