package base.obstacle;

import base.GameObject;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

public class ObstacleRock1 extends Obstacle {
    public ObstacleRock1(){
        super();
        this.renderer = new AnimationRenderer(8,"assets/images/obstacle/Mirror/mirror1.png",
                "assets/images/obstacle/Mirror/mirror2.png",
                "assets/images/obstacle/Mirror/mirror3.png",
                "assets/images/obstacle/Mirror/mirror4.png",
                "assets/images/obstacle/Mirror/mirror5.png",
                "assets/images/obstacle/Mirror/mirror6.png",
                "assets/images/obstacle/Mirror/mirror7.png",
                "assets/images/obstacle/Mirror/mirror8.png",
                "assets/images/obstacle/Mirror/mirror9.png",
                "assets/images/obstacle/Mirror/mirror10.png"
                );
        this.collider = new BoxCollider(20,30);
    }
}
