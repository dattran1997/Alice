package base.obstacle;

import base.GameObject;
import base.Setting;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.SingleImageRenderer;

public class ObstacleTree1R extends Obstacle {
    boolean goOut;
    public ObstacleTree1R(){
        super();
        this.renderer = new SingleImageRenderer("assets/images/obstacle/tree.png");
        this.collider = new BoxCollider(97,31);
        this.position.setThis((float)Setting.SCREEN_WIDTH,2000f);
    }


    public void move(){
        float vx = 0;

        if (goOut){
            if(this.position.x < Setting.SCREEN_WIDTH - this.collider.width +50){
                goOut = false;
            }
            vx -= 3;

        }else {
            if(this.position.x > Setting.SCREEN_WIDTH){
                goOut = true;
            }
            vx = +1;

        }

        this.position.addThis(vx,0);

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
