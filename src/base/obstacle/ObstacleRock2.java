package base.obstacle;

import base.GameObject;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;

public class ObstacleRock2 extends Obstacle {
    public ObstacleRock2(){
        super();
        this.renderer = new SingleImageRenderer("assets/images/obstacle/bigRock.png");
        this.collider = new BoxCollider(30,40);
    }
}
