/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ecko0_000
 */
public class Predator extends Animal {
    
    private int rand;
    private int up;
    private int right;
    private int down;
    private int left;
    private int x;
    private int y;
    private Animal rAnimal=null;
    private boolean breed;
    private boolean eat;
    private String tag;
    private Image img;
    
    public Predator()
    {
        super();
        rand=0;
        up = super.getUp();
        right = super.getRight();
        down = super.getDown();
        left = super.getLeft();
        x = super.getX();
        y = super.getY();
        breed = false;
        tag="predator";
        eat = false;
        File file = new File("test/predator.jpg");
        try
        {
            img = ImageIO.read(file);
            //img = img.getScaledInstance(this.getHeight(), this.getWidth(), Image.SCALE_DEFAULT);
            //setIcon(new ImageIcon(img));
        }
        catch(Exception ex)
        {System.out.println(ex);}
    }
    
    @Override
    public Image getImg()
    {
        return img;
    }
    
}
