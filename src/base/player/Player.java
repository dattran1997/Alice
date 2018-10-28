package base.player;

import base.*;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
//    boolean isValidFire;
    FrameCounter fireCounter;
    PlayerBulletType1 bullet;
    PlayerBulletType1 bullet1;
    PlayerBulletType1 bullet2;
    BoxCollider collider;
    Vector2D velocity;


    public int playerHealth ;

    public Player(){
        super();
        // load image thay cho tạo mảng và add ảnh
        this.renderer = new PlayerAnimator();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png"
        );
//        this.renderer = new AnimationRenderer(images); // renderer là 1 dạng của đa hình vì là kiểu Renderer nhưng gọi new theo AnimationRender
        this.position = new Vector2D();
        position.x = Setting.START_PLAYER_POSITION_X;
        position.y = Setting.START_PLAYER_POSITION_Y;
        this.playerHealth = Setting.Player_Full_HP;

        this.fireCounter = new FrameCounter(10);
        this.collider =  new BoxCollider(32,48);
        this.velocity = new Vector2D(0,0);
    }

    public void move (float velocityX, float velocityY){
//        position.addThis(x,y);
        if(velocityX == 0 && velocityY == 0){
            this.velocity.setThis((float)0,(float)0);
        }else{
            this.velocity.addThis(velocityX, velocityY);
            if(KeyEventPress.isUpPress) {
                this.velocity.setThis(clamp(velocity.x, -3, 3), clamp(velocity.y, -2, 2));
            }else{
                this.velocity.setThis(clamp(velocity.x, -3, 3), clamp(velocity.y, -8, 8));
            }
        }
    }

    // giới hạn
    public float clamp(float number,float min, float max ){
//        if(number < min){
//            return min;
//        }else if(number > max){
//            return max;
//        }else {
//            return number;
//        }

        return number < min ? min : number > max ? max : number;
    }

    @Override
    public  void run (){
        int vx =0;
        float vy =0;
        if (KeyEventPress.isUpPress){
            if(this.position.y > 50) {
                vy -= 0.1;
            }else{
                vy -= 0;
            }

            if (KeyEventPress.isRightPress ){
                // need get bg width
                if (this.position.x < 375){
                    vx +=3;
                }
            }
            if (KeyEventPress.isLeftPress ){
                if(position.x > 10)
                    vx -=4;
            }
        }else{
            if(this.position.y > Setting.SCREEN_HEIGHT - 100){
                vy += 0;
            }else{
                vy += 6;
            }
            if (KeyEventPress.isRightPress ){
                // need get bg width
                if (this.position.x < 375){
                    vx +=1;
                }
            }
            if (KeyEventPress.isLeftPress ){
                if(position.x > 10)
                    vx -=1;
            }
        }

        if (KeyEventPress.isRightPress ){
            // need get bg width
            if (this.position.x < 375){
                vx +=2;
            }
        }
        if (KeyEventPress.isLeftPress ){
            if(position.x > 10)
            vx -=2;
        }

        this.move(vx,vy);
        this.position.addThis(this.velocity);
    }


    public void takeDamage(int damage){
        this.playerHealth -= damage;
        this.reportStatus();
        if(this.playerHealth <= 0){
            this.destroy();  // is active = false : ưu tiên code rõ nghĩa hơn ;
            this.playerHealth = 0;
            this.reportStatus();
        }
    }

    public void reportStatus(){
        if(this.playerHealth > 0){
            System.out.println("player HP: "+this.playerHealth);
        }
        else {
            System.out.println("playerHp: "+this.playerHealth);
            System.out.println("you lose");
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
