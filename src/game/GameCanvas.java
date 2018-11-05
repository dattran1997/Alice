package game;

import base.*;
import base.enemy.EnemyManager;
import base.obstacle.Obstacle;
import base.obstacle.ObstacleManager;
import base.obstacle.ObstacleTree1L;
import base.player.Player;
import base.scene.SceneManager;
import base.scene.welcomeScene.WelcomeScene;

import javax.swing.*;
import java.awt.*;

//canvas bảng vẽ - panel
public class GameCanvas extends JPanel {
    Background background;
    Player player;
    EnemyManager enemyManager;
    Obstacle obstacle;
    ObstacleTree1L obstacleType1;
    ObstacleManager obstacleManager;


    //hàm khởi tạo GameCanvas
    public GameCanvas(){
        SceneManager.signNewScene(new WelcomeScene());
//        GameObject.add(enemyManager);

//        EnemyType1 enemyType1 = new EnemyType1();
//        enemyType1.position.setThis(200f,200f);
//        GameObject.add(enemyType1);
//        this.obstacle = GameObject.recycle(Obstacle.class);
//        this.obstacle.position.setThis(100f,1000f);
//        this.obstacleType1 = GameObject.recycle(ObstacleTree1L.class);
//        this.obstacleManager = GameObject.recycle(ObstacleManager.class);
    }


    // hàm run : hàm để update even khi có thay đổi về số liệu  (x += 1)
    // run phụ trách logic thay đổi dữ liệu

    public void run(){
        // run al : chạy tất cả object đc add vào list static gameObjects
        GameObject.runAll();
    }


    //render là bút vẽ sau khi số liệu đc update (g.draw)
    // chỉ phụ trách vẽ

    public void render (){
    //tương tự như run
        GameObject.renderAllToBackBuffer();
    }


    //painComponent : là hàm vẽ các thay đổi
    // graphics : đóng vai trò là bút vẽ, là 1 phần trong Jpanel

    @Override
    protected void paintComponent(Graphics g) {
        // gom tất cả các phần vẽ trong render để vẽ
//        this.render(g);
        GameObject.renderBackBufferToGame(g);
    }
}
