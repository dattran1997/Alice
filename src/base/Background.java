package base;

import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class Background extends GameObject {

    public Background (){
        super();
        this.image = SpriteUtils.loadImage("assets/images/background/BG.png");
        this.renderer = new SingleImageRenderer( image);
        this.position = new Vector2D(); // vẫn phải gọi do ở lớp cha mới có biến chưa có gtrị
        // do điểm bắt đầu vẽ luôn là góc trái trên của ảnh nên phải kéo ngược lên trên để bg đi xuống
        position.x = 0;
        position.y = 0;
        this.anchor.setThis((float)0,(float)0);
    }

    //overrider hàm run để thêm thay đổi của lớp con
    public int getImageWidth(){
        return this.image.getWidth();
    }

    public int getImageHeight(){
        return this.image.getHeight();
    }

    @Override
    public void render(Graphics g) {
//        super.render(g);
        g.drawImage(this.image,(int)this.position.x, (int)this.position.y,null);
        g.drawImage(this.image,(int)this.position.x, (int)this.position.y+1000,null);

    }

    @Override
    public void run(){
        if (position.y > -(image.getHeight() - Setting.SCREEN_HEIGHT +1000)){
            System.out.println(this.image.getHeight());
            if(KeyEventPress.isUpPress){
                position.subtractThis(0,0);
            }
            else{
                position.subtractThis(0,0);
            }
        }
        else {
//            this.position.setThis(0f,0f);
            return;
        }
//
//        if(position.y > -(this.image.getHeight() - Setting.SCREEN_HEIGHT)){
//            if(KeyEventPress.isUpPress){
//                position.subtractThis(0,3);
//            }
//            else{
//                position.subtractThis(0,8);
//            }
//        }
//        else{
//            this.position.setThis((float)0,(float)0);
//        }
    }


}
