package base.player;

import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    Vector2D velocity;
    BoxCollider collider;
    int damage;

    public PlayerBullet (){
        super(); // gọi hàm tạo của lớp cha
        this.position = new Vector2D(0, 0);
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/bullet Smiley/Smiley1.png",
                "assets/images/bullet Smiley/Smiley2.png",
                "assets/images/bullet Smiley/Smiley3.png",
                "assets/images/bullet Smiley/Smiley4.png",
                "assets/images/bullet Smiley/Smiley5.png",
                "assets/images/bullet Smiley/Smiley6.png",
                "assets/images/bullet Smiley/Smiley7.png",
                "assets/images/bullet Smiley/Smiley8.png",
                "assets/images/bullet Smiley/Smiley9.png",
                "assets/images/bullet Smiley/Smiley10.png"

        );

        // renderer = image
        this.renderer = new AnimationRenderer(images);
        this.velocity = new Vector2D(0,0);
//        this.collider = new BoxCollider(22,22);
    }

    public PlayerBullet (int x, int y ){
        this.position = new Vector2D(x, y);

        // images ko cần gọi new vì trong loadImage đã có hàm khởi tạo
        // load image thay cho bước khởi tạo mảng và add địa chỉ ảnh vào mảng
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
        );
//        this.renderer = new AnimationRenderer(images);

    }

    public void move(int x, int y){
        position.addThis(velocity);
    }

    @Override
    public void run(){
        Enemy enemy = GameObject.intersect(Enemy.class, this);
        if(enemy != null){
            // viên dạn xóa sổ con quái
            enemy.takeDamage(this.damage);
            this.hitEnemy();
//            enemy.destroy();
//            this.destroy();
            return;
        }

        if(this.position.y < 0){
            this.destroy();
            return;
        }
//        this.move(0,-5);
//        this.move((int)velocity.x,(int)velocity.y);
//        this.move((int)velocity.x,(int)velocity.y);
        this.position.addThis(velocity);
    }

    public void hitEnemy(){

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
