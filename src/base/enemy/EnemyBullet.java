package base.enemy;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider collider;
    int damage;
    Random randomX = new Random();
    Random randomCount = new Random();
    Vector2D velocity;
    FrameCounter moveCounter;

    public EnemyBullet(){
        super();
        this.renderer = new AnimationRenderer(8,"assets/images/bullet Smiley/Smiley1.png",
                "assets/images/bullet Smiley/Smiley2.png",
                "assets/images/bullet Smiley/Smiley3.png",
                "assets/images/bullet Smiley/Smiley4.png",
                "assets/images/bullet Smiley/Smiley5.png",
                "assets/images/bullet Smiley/Smiley6.png",
                "assets/images/bullet Smiley/Smiley8.png",
                "assets/images/bullet Smiley/Smiley7.png",
                "assets/images/bullet Smiley/Smiley9.png",
                "assets/images/bullet Smiley/Smiley10.png");
        this.position = new Vector2D(0, 0);
        this.collider = new BoxCollider(14,14);
        this.velocity = new Vector2D();
        this.moveCounter = new FrameCounter(5);
        this.damage = 20;
    }

//    public EnemyBullet(int x, int y){
//
//        // load image: tạo mảng và add ảnh vào
//        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
//                "assets/images/enemies/bullets/blue.png",
//                "assets/images/enemies/bullets/cyan.png",
//                "assets/images/enemies/bullets/green.png",
//                "assets/images/enemies/bullets/pink.png",
//                "assets/images/enemies/bullets/red.png",
//                "assets/images/enemies/bullets/white.png",
//                "assets/images/enemies/bullets/yellow.png"
//        );
//        this.renderer = new AnimationRenderer(images);
//        this.position = new Vector2D(x, y);
//    }

    //có thể bỏ move khi run ko phải check even phím
    public void move(float velocityX, float velocityY){
        if (moveCounter.run()) {
            if(velocityX == 0 && velocityY == 0){
                velocity.setThis(0f,0f);
            }else{
                velocity.setThis(velocityX,velocityY);
            }
            moveCounter.reset();
            moveCounter.addMaxCount(randomCount.nextInt(120 - 5) + 5);
        }
    }

    @Override
    public void run (){
        // check nếu có va chạm giữa player vs ebullet thì gán vào biến player
        Player player = GameObject.intersect(Player.class,this);
        if (player != null){
            // player khi bị va chạm sẽ đc lấy từ gameObjects gán vào biến để thay đổi thông số
            if(KeyEventPress.isUpPress){
                if(player.playerHealth > 0){
                    player.takeDamage(damage);
                    this.destroy();
                }
                else if (player.playerHealth == 0){
                    player.reportStatus();
                    this.destroy();
                }
            }else{
                this.destroy();
            }
        }
        else {
            if(this.position.y < 0){
                this.destroy();
            }
        }
        float vx =0, vy =0;
        if(KeyEventPress.isUpPress){
//            vx -= 2;
//            vy -= 2;
            vx = randomX.nextInt(5 + 3) - 3;
            vy = -5;
        }else {
//            vx +=7;
//            vy +=7;
            vx = randomX.nextInt(7 + 5) - 5;
            vy = -7;
        }
//        this.move((float) Math.cos(60*3.14/180) * vx,(float) Math.sin(60*3.14/180)*vy);
        this.move((float)vx,(float)vy);
        this.position.addThis(velocity);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
