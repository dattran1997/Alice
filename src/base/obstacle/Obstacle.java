package base.obstacle;

import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.SingleImageRenderer;

public class Obstacle extends GameObject implements Physics {
    BoxCollider collider ;

    public Obstacle(){
        super();
        this.renderer = new SingleImageRenderer("assets/images/Obstacle/chair.png");
        this.position = new Vector2D(0,0);
//        this.collider = new BoxCollider(40,60);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }

    @Override
    public void run(){
        if(KeyEventPress.isUpPress){
            this.position.addThis(0,-3);
        }else{
            this.position.addThis(0,-6);
        }


        // intersect
        Player player = GameObject.intersect(Player.class,this);
        if(player != null){
            player.destroy();
            player.revive();
        }else{
            if(this.position.y < 0){
                this.destroy();
            }
        }
    }
}
