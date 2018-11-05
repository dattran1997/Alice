package base.renderer;

import base.GameObject;
import base.counter.FrameCounter;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImage = 0;
    FrameCounter frameCounter;
    boolean isOne;

    public AnimationRenderer (String... urls){
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(urls);
        this.images = images;
        this.frameCounter = new FrameCounter(5);
    }

    public AnimationRenderer (int framecount, String... urls){
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(urls);
        this.images = images;
        this.frameCounter = new FrameCounter(framecount);
    }

//    public AnimationRenderer (String...urls){
//        ArrayList<BufferedImage>images = new ArrayList<>();
//        for (String url : urls){
//            BufferedImage image = SpriteUtils.loadImage(url);
//            if(image != null){
//                images.add(image);
//            }
//        }
//        this.images = images;
//    }
    public AnimationRenderer(int frameCount, boolean isOnce, String ...urls) {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(urls);
        this.images = images;
        this.frameCounter = new FrameCounter(frameCount);
        this.isOne = isOnce;
    }

    public AnimationRenderer (ArrayList<BufferedImage> images){
        this.images = images;
        this.frameCounter = new FrameCounter(5);
        this.isOne = false;
    }

    // maxcount cho tùy chỉnh thời gian delay giữa các lần render ảnh
    public AnimationRenderer (ArrayList<BufferedImage> images, int maxCount){
        this.images = images;
        this.frameCounter = new FrameCounter(maxCount);
        this.isOne = false;
    }

    public AnimationRenderer (ArrayList<BufferedImage> images, int maxCount, boolean isOne){
        this.images = images;
        this.frameCounter = new FrameCounter(maxCount);
        this.isOne = isOne;
    }




//    int frameCount = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        if(images.size() > 0){
            // load anh trong mang
//            g.drawImage(images.get(currentImage), (int) master.position.x, (int) master.position.y, null);
            BufferedImage image = images.get(currentImage);
            // để vật thể ra giữa màn hình
            double x = master.position.x - image.getWidth() * master.anchor.x;
            double y = master.position.y - image.getHeight() * master.anchor.y;
            g.drawImage(image,(int) x,(int) y , null);

            if(frameCounter.run()){
                currentImage ++;
                if(this.isOne && this.currentImage >= images.size() -1 ){  /*khi chạy quá chiều dài mảng thì gán về vị trí đầu*/
                    master.destroy();
                }
                if(currentImage >= images.size() - 1){
                    currentImage = 0;
                }
                frameCounter.reset();
            }
        }
    }
}
