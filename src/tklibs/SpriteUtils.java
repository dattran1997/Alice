package tklibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by huynq on 5/11/17.
 */
public class SpriteUtils {
    public  static HashMap <String,BufferedImage> images = new HashMap<>();

    public static BufferedImage loadImage(String url) {
        // cache lai anh de do lag
        BufferedImage image = images.get(url);
        if(image!=null){
            return image;
        }else {
            try {
                return ImageIO.read(new File(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    // ...url để truyền vào nhiểu string , các string tạo thành mảng
    public static ArrayList<BufferedImage> loadImages(String ...urls){
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (String url : urls){
            BufferedImage image = loadImage(url);
            if(image != null){
                images.add(image);
            }
        }
        return images;
    }

    public static void renderAtCenter(Graphics graphics, BufferedImage image, double x, double y) {
        graphics.drawImage(image, (int)(x - (double)image.getWidth() / 2), (int)(y - (double) image.getHeight() / 2), null);
    }

    public static BufferedImage maskWhite(BufferedImage image) {
        BufferedImage returnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                int alpha = color & 0xFF000000;
                if (alpha != 0) {
                    returnImage.setRGB(x, y, color | 0x00FFFFFF | alpha);
                } else {
                    returnImage.setRGB(x, y, color);
                }
            }
        }

        return returnImage;
    }
}
