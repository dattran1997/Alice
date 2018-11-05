package base.obstacle;

import base.GameObject;
import base.Vector2D;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

public class ObstacleTree1C extends Obstacle {
    boolean goOut;
    public ObstacleTree1C(){
        super();
        this.renderer = new AnimationRenderer("assets/images/obstacle/Cat/Cat1.png",
                "assets/images/obstacle/Cat/Cat2.png",
                "assets/images/obstacle/Cat/Cat3.png",
                "assets/images/obstacle/Cat/Cat4.png",
                "assets/images/obstacle/Cat/Cat5.png",
                "assets/images/obstacle/Cat/Cat6.png",
                "assets/images/obstacle/Cat/Cat7.png",
                "assets/images/obstacle/Cat/Cat8.png");
        this.collider = new BoxCollider(97,31);
        this.position = new Vector2D(180,3000);
    }

    public void move(){
        float vx = 0;

        if (goOut){
            if(this.position.x >250){
                goOut = false;
            }
            vx += 4;

        }else {
            if(this.position.x < 150){
                goOut = true;
            }
            vx -= 4;

        }

        this.position.addThis(vx,0);

        if(this.position.y < 0){
            this.destroy();
        }
    }

    public float clamp(float number,float min, float max ){
        return number < min ? min : number > max ? max : number;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }

    @Override
    public void run (){
        if(KeyEventPress.isUpPress){
            this.position.subtractThis(0,3);
        }else{
            this.position.subtractThis(0,5);
        }

        this.move();

        //intersect
        Player player = GameObject.intersect(Player.class,this);
        if(player != null){
            player.destroy();
        }else{
            if(this.position.y < 0){
                this.destroy();
            }
        }
    }
}
