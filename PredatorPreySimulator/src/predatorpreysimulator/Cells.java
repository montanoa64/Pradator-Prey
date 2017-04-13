/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

//import javax.swing.JButton;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author ecko0_000
 */
public class Cells extends javax.swing.JButton {
    
    private int x;
    private int y;
    private boolean isEmpty;
    private String tag;
    
    public Cells()
    {
        isEmpty = true;
        x=0;
        y=0;
        tag="";
    }
    
    public Cells(int x, int y, boolean isEmpty,String tag)
    {
        this.x=x;
        this.y=y;
        this.isEmpty = isEmpty;
        this.tag=tag;
    }
    
    public void setXY(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public String getTag()
    {
        return tag;
    }
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
        
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setNotEmpty(Animal animal)
    {
        File file = new File("test/predator.jpg");
        try
        {
            Image img = ImageIO.read(file);
            img = img.getScaledInstance(this.getHeight(), this.getWidth(), Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(img));
        }
        catch(Exception ex)
        {System.out.println(ex);}
        animal.setXY(getX(), getY());
        isEmpty = false;
    }
    
    public boolean getIsEmpty()
    {
        
        return isEmpty;
    }
    
    public void setEmpty()
    {
        setIcon(null);
        isEmpty = true;
    }
}
