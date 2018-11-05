package base.enemy;

import base.*;
import base.action.*;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import base.scene.EndScene.EndScene;
import base.scene.SceneManager;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject implements Physics {
    EnemyBullet enemyBullet;
//    FrameCounter frameCounter;
    BoxCollider collider;
    Action action;

    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/1.png",
                "assets/images/enemies/level0/black/2.png",
                "assets/images/enemies/level0/black/4.png",
                "assets/images/enemies/level0/black/5.png",
                "assets/images/enemies/level0/black/6.png",
                "assets/images/enemies/level0/black/7.png",
                "assets/images/enemies/level0/black/8.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0, 0);
//        this.collider = new BoxCollider(32,48);
        this.defineAction();

        //        this.frameCounter = new FrameCounter(10);

    }

    void defineAction(){
        ActionWait actionWait = new ActionWait(120);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                //this.fire của base.action
                shoot();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        // this.fire() của enemy

        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        // parallel để cho những hành động xảy ra song song vào ko cho actionWait vào vì vô tác dụng
        ActionParallel actionParallel = new ActionParallel(actionMove,actionFire);
        // sequence để cho những hđ xảy ra nối tiếp nhau thg này làm hết rồi đến thg kia
        ActionSequence actionSquence = new  ActionSequence(actionWait,actionParallel);
        // repeat để lặp lại
        ActionRepeat actionRepeat = new ActionRepeat(actionSquence);
        this.action = actionRepeat;
    }

    public Enemy(int x, int y) {

        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/1.png",
                "assets/images/enemies/level0/black/2.png",
                "assets/images/enemies/level0/black/4.png",
                "assets/images/enemies/level0/black/5.png",
                "assets/images/enemies/level0/black/6.png",
                "assets/images/enemies/level0/black/7.png",
                "assets/images/enemies/level0/black/8.png"
        );

        // max count la khoang delay giua cac anh render
        this.renderer = new AnimationRenderer(images, 2);
        this.position = new Vector2D(x, y);

    }

    public  void takeDamage(int damage){

    }

    //tạo giá trị random gán để bot di chuyển
    Random randomX = new Random();
    Random randomY = new Random();

    // run tương đương vs vòng for vì đc đặt trong loop

    @Override
    public void run() {
//        this.move();
//        position.addThis(randomX.nextInt(3 + 2) - 2, randomY.nextInt(3 + 2) - 2);
//        if (this.frameCounter.run()) {
//            this.shoot();
//            this.frameCounter.reset();
//            }
//        this.shoot();
        this.action.run(this);

//        intersect
        Player player = GameObject.intersect(Player.class,this);
        if (player != null){
            if(KeyEventPress.isUpPress){
                player.destroy();
                Setting.SCORE = player.score.score;
                SceneManager.signNewScene(new EndScene());
            }
            else {
                this.takeDamage(10);
                player.score.addScore(1);
            }
        }

        if(KeyEventPress.isUpPress){
            this.position.y -= 3;
        }else {
            this.position.y -= 6;
        }

        if(this.position.y < 0){
            this.destroy();
        }
    }

    public void move(){
//        position.addThis(randomX.nextInt(10 + 9) - 9,0);
        position.addThis(0,0);
    }

    public void shoot() {
        this.enemyBullet = GameObject.recycle(EnemyBullet.class);
        enemyBullet.position.setThis(this.position.x + 5, this.position.y );
    }

    public float clamp(float number,float min, float max ){
        return number < min ? min : number > max ? max : number;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
