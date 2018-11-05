package base.enemy;

import base.GameObject;
import base.SoundManager;
import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;

public class EnemyType1 extends Enemy {
    public EnemyType1(){
        super();
        this.renderer = new AnimationRenderer(
                "assets/images/Bug weed/bug1.png",
                "assets/images/Bug weed/bug2.png",
                "assets/images/Bug weed/bug3.png",
                "assets/images/Bug weed/bug4.png",
                "assets/images/Bug weed/bug5.png"
        );
        this.collider = new BoxCollider(32,48);
    }

//    @Override
//    public void run() {
//        position.y += 50;
//    }

    @Override
    public  void takeDamage ( int damage){
        if(damage > 0){
            this.destroy();
            SoundManager.playSound("assets/music/sfx/enemy-explosion.wav");
        }
    }

    @Override
    public void destroy(){
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.setThis(this.position);
    }

}
