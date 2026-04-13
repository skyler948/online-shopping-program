package image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageSheet {

    private int subimageSize;
    private String path;

    private int imagesX, imagesY;

    private BufferedImage sheet;

    private ImageIcon[] icons;

    public ImageSheet(int subimageSize, String path) {
        this.subimageSize = Math.max(0, subimageSize);
        this.path = path;

        try {
            sheet = ImageIO.read(ImageSheet.class.getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imagesX = sheet.getWidth() / subimageSize;
        imagesY = sheet.getHeight() / subimageSize;

        icons = new ImageIcon[imagesX * imagesY];

        int i = 0;
        for (int x = 0; x < imagesX; x++) {
            for (int y = 0; y < imagesY; y++) {
                icons[i] = new ImageIcon(sheet.getSubimage(x * subimageSize, y * subimageSize, subimageSize, subimageSize));
                i++;
            }
        }
    }

    public int getSubimageSize() {
        return subimageSize;
    }

    public String getPath() {
        return path;
    }

    public int getImagesX() {
        return imagesX;
    }

    public int getImagesY() {
        return imagesY;
    }

    public ImageIcon[] getIcons() {
        return icons;
    }

}
