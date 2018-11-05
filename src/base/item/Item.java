package base.item;

import base.GameObject;
import base.physics.BoxCollider;
import base.physics.Physics;

public class Item extends GameObject implements Physics {
    public Item(){

    }
    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
    @Override
    public void run(){

    }
}
