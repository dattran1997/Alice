package base.player;

import base.GameObject;
import base.event.KeyEventPress;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    Renderer straightAnimation;
    Renderer leftAnimation;
    Renderer rightAnimation;
    Renderer bullet;

    public PlayerAnimator(){
        this.straightAnimation = new AnimationRenderer(7,
                "assets/images/Alice-Straight/Straight/Alice_Straight1.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight2.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight3.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight4.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight5.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight6.png",
                "assets/images/Alice-Straight/Straight/Alice_Straight7.png"
        );
        this.bullet = new AnimationRenderer(
                "assets/images/Alice-attack/Attack/Sprite-0001.png",
                "assets/images/Alice-attack/Attack/Sprite-0002.png",
                "assets/images/Alice-attack/Attack/Sprite-0003.png",
                "assets/images/Alice-attack/Attack/Sprite-0004.png",
                "assets/images/Alice-attack/Attack/Sprite-0005.png",
                "assets/images/Alice-attack/Attack/Sprite-0006.png",
                "assets/images/Alice-attack/Attack/Sprite-0007.png",
                "assets/images/Alice-attack/Attack/Sprite-0008.png",
                "assets/images/Alice-attack/Attack/Sprite-0009.png",
                "assets/images/Alice-attack/Attack/Sprite-0010.png",
                "assets/images/Alice-attack/Attack/Sprite-0011.png",
                "assets/images/Alice-attack/Attack/Sprite-0012.png",
                "assets/images/Alice-attack/Attack/Sprite-0013.png",
                "assets/images/Alice-attack/Attack/Sprite-0014.png",
                "assets/images/Alice-attack/Attack/Sprite-0015.png",
                "assets/images/Alice-attack/Attack/Sprite-0016.png",
                "assets/images/Alice-attack/Attack/Sprite-0017.png",
                "assets/images/Alice-attack/Attack/Sprite-0018.png",
                "assets/images/Alice-attack/Attack/Sprite-0019.png",
                "assets/images/Alice-attack/Attack/Sprite-0020.png"
                );
        this.leftAnimation = new AnimationRenderer(
                "assets/images/players/left/0.png",
                "assets/images/players/left/1.png",
                "assets/images/players/left/2.png",
                "assets/images/players/left/3.png",
                "assets/images/players/left/4.png",
                "assets/images/players/left/5.png"
        );
        this.rightAnimation = new AnimationRenderer(
                "assets/images/players/right/0.png",
                "assets/images/players/right/1.png",
                "assets/images/players/right/2.png",
                "assets/images/players/right/3.png",
                "assets/images/players/right/4.png",
                "assets/images/players/right/5.png"
        );
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Player player =(Player)master;
        if(KeyEventPress.isUpPress){
            this.straightAnimation.render(g, master);
        }
        else if (!KeyEventPress.isUpPress){
            this.bullet.render(g,master);
        }
        else if (player.velocity.x < 0){
            this.rightAnimation.render(g, master);
        }
        else{
            this.straightAnimation.render(g, master);
        }
    }
}
