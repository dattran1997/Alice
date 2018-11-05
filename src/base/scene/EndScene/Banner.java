package base.scene.EndScene;

import base.GameObject;
import base.Setting;
import base.Vector2D;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.StageScene;
import base.scene.welcomeScene.WelcomeScene;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

public class Banner extends GameObject {
    BufferedImage image;
    public Banner() {
        super();
        this.position = new Vector2D();
        this.image = SpriteUtils.loadImage("assets/images/scenes/end.png");
        position.x = 0;
        position.y = 0;
        this.anchor.setThis((float)0,(float)0);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.anchor.x, (int)this.anchor.y, null);
        g = image.getGraphics();
        Font f = new Font("TimesRoman", 50,30);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString("Your Score: " + Setting.SCORE, 200,400);
    }

    @Override
    public void run() {
        if(KeyEventPress.isSpacePress){
            SceneManager.signNewScene(new WelcomeScene());
        }
    }
}
