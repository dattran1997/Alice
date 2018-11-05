package base.scene.welcomeScene;

import base.GameObject;
import base.scene.Scene;

public class WelcomeScene extends Scene {
    @Override
    public void init() {
        GameObject.recycle(Banner.class);
    }

    @Override
    public void destroy() {
        GameObject.clearAll();
    }
}
