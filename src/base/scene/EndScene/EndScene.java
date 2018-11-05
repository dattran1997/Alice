package base.scene.EndScene;

import base.GameObject;
import base.scene.Scene;

public class EndScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Banner.class);
    }

    @Override
    public void destroy() {
        GameObject.clearAll();
    }
}
