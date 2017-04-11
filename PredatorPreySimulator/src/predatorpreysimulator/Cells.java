/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

//import javax.swing.JButton;

/**
 *
 * @author ecko0_000
 */
public class Cells extends javax.swing.JButton {
    
    private int x;
    private int y;
    private boolean isEmpty;
    
    public Cells()
    {
        isEmpty = true;
        x=0;
        y=0;
    }
    
    public Cells(int x, int y, boolean isEmpty)
    {
        this.x=x;
        this.y=y;
        this.isEmpty = isEmpty;
    }
    
    public void setXY(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setNotEmpty()
    {
        isEmpty = false;
    }
    
    public boolean getIsEmpty()
    {
        return isEmpty;
    }
}
