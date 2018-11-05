package base.obstacle;

import base.GameObject;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

public class ObstacleChair extends Obstacle{
    public ObstacleChair(){
        super();
        this.renderer = new AnimationRenderer(6,"assets/images/obstacle/Chair/Sprite-0006.png",
                "assets/images/obstacle/Chair/Sprite-0007.png",
                "assets/images/obstacle/Chair/Sprite-0008.png",
                "assets/images/obstacle/Chair/Sprite-0009.png",
                "assets/images/obstacle/Chair/Sprite-0010.png",
                "assets/images/obstacle/Chair/Sprite-0011.png",
                "assets/images/obstacle/Chair/Sprite-0012.png",
                "assets/images/obstacle/Chair/Sprite-0013.png");
        this.collider = new BoxCollider(30,20);
    }

}
