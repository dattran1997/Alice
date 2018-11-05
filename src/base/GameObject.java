package base;

import base.physics.Physics;
import base.renderer.Renderer;
import base.scene.SceneManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    boolean isActive = true;
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();
    public static BufferedImage backBuffer = new BufferedImage(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT,(BufferedImage.TYPE_INT_ARGB));
    public  static Graphics backBufferGraphics = backBuffer.createGraphics();

    //create(classname) >> instance classname

    public static void add(GameObject go){
        newGameObjects.add(go);
    }
    // hàm tạo đối tượng và add đối tượng vào mảng
    public static <E extends  GameObject> E create(Class<E> childClass){

        try{
            GameObject newGameObject = childClass.newInstance();
            newGameObjects.add(newGameObject);
            return (E)newGameObject;
        }catch (Exception e){
            return null;
        }
    }

    public static <E extends GameObject > E recycle(Class<E> childclass){
        // kiểm tra có game object tm yeu cầu (go.isActive == false và instance of child class)
        //có thì dùng lại
        // ko có tạo mưới
        //return game object
        for (GameObject go : gameObjects){
            // duyệt những đối tượng bị deactivate để dùng lại
            if(!go.isActive && go.getClass().isAssignableFrom(childclass)){
                go.isActive = true;
                return (E)go;
            }
        }
        return create(childclass);
    }

    public static void clearAll() {
        gameObjects.clear();
        newGameObjects.clear();
    }
    //physics là đối tượng cần đc check va chạm
    public  static <E extends GameObject> E intersect(Class<E> childClass, Physics physics){
        for(GameObject go : gameObjects){
            // check nếu như game object chưa đc vẽ ra || thuộc kiểu class của đối tượng kia đc truyền vào ||
            // và có collider khai báo trong class đó
            if(go.isActive && childClass.isAssignableFrom(go.getClass()) && go instanceof Physics){
                Physics physicsGo =(Physics) go;
                boolean intersected = physics.getBoxCollider().intersect(physicsGo,(GameObject) physics);
                if(intersected){
                    return (E) physicsGo;
                }
            }
        }
        return null;
    }

    public static void runAll(){
//        for(GameObject go : gameObjects){
//            go.run();
//        }

//        for(int i=0; i<gameObjects.size();i++){
        for(GameObject go: gameObjects){
            if (go.isActive){
                go.run();
            }
        }
//        System.out.println(gameObjects.size());
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        SceneManager.changeSceneIfNeeded();

    }

    public static void renderAllToBackBuffer(){
        for(GameObject go : gameObjects){
            if(go.isActive){
                go.render(backBufferGraphics);
            }
        }
    }

    public static void renderBackBufferToGame(Graphics g){
        g.drawImage(backBuffer,0,0,null);
    }

//    public static void renderAll (Graphics g){
//
////        for(int i=0; i<gameObjects.size();i++){
//        for(GameObject gameObject : gameObjects){
//            GameObject go = gameObjects.get(i);
//            if (go.isActive){
//                go.render(g);
//            }
//        }
//        gameObjects.addAll(newGameObjects);
//        newGameObjects.clear();
//    }

    //************************** khởi tạo

    BufferedImage image;
    //kiểu dữ liệu vector
    public Vector2D position;
    // render là 1 dạng đa hình

   public Renderer renderer;
   public Vector2D anchor;

    public GameObject(){
        this.isActive = true;
        this.anchor = new Vector2D(0.5f,0.5f);
    }

    public GameObject(BufferedImage image){
        this.isActive = true;
        this.image = image;
        this.position = new Vector2D(0,0);
    }

    //render : g.draw
    public  void render (Graphics g){
            if(this.renderer != null) {
                this.renderer.render(g,this);
            }
    }

    public void destroy (){
        this.isActive = false;
    }
    public void revive() {this.isActive = true;}

    public void run (){

    }

}
