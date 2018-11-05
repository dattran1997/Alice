package base.obstacle;

import base.GameObject;
import base.Vector2D;
import base.action.*;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.SingleImageRenderer;

public class ObstacleTree1L extends Obstacle implements Physics {
    boolean goOut ;

    public ObstacleTree1L(){
        super();
        this.renderer = new SingleImageRenderer("assets/images/obstacle/tree.png");
        this.collider = new BoxCollider(70,28);
        this.position = new Vector2D(-this.collider.width,2000);
    }


    public void move(){
        float vx = 0;

        if (goOut){
            if(this.position.x > 40){
                goOut = false;
            }
            vx += 6;

        }else {
            if(this.position.x < - this.collider.width){
                goOut = true;
            }
            vx = -1;

        }

        this.position.addThis(vx,0);

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
            this.position.subtractThis(0,6);
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
