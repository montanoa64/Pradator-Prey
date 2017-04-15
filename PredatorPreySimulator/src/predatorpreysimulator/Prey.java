/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ecko0_000
 */
public class Prey extends Animal {
    private int rand;
    private int up;
    private int right;
    private int down;
    private int left;
    private int x;
    private int y;
    private Animal rAnimal=null;
    private boolean breed;
    private String tag;
    private Image img;
    
    public Prey()
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
        tag="prey";
        File file = new File("test/prey.jpg");
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
    //private Animal rAnimal = new Prey();
    public void move(Cells [][] cell, int row, int column)
    {
//        x = super.getX();
//        y = super.getY();
        
        rand = super.getRand();
        if(rand == up)
        {
            if(x == 0)
            {
                super.increaseCount();
            }
            else if(cell[x-1][y].getIsEmpty() == false)
            {
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                x--;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
            }
        }
        else if (rand == right)
        {
            if(y == column-1)
            {
                super.increaseCount();
            }
            else if(cell[x][y+1].getIsEmpty() == false)
            {
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                y++;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
            }
        }
        else if(rand == down)
        {
            if(x == row-1)
            {
                super.increaseCount();
            }
            else if (cell[x+1][y].getIsEmpty() == false)
            {
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                x++;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
            }
        }
        else
        {
            if(y == 0)
            {
                super.increaseCount();
            }
            else if(cell[x][y-1].getIsEmpty() == false)
            {
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                y--;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
            }
        }
        breed(cell,row,column);
        
    }
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public void setAnimal(Animal animal)
    {
        this.rAnimal = animal;
    }
    @Override
    public void setBreedF()
    {
        breed=false;
    }
    @Override
    public void breed(Cells [][] cell, int row, int column)
    {
        //rAnimal = null;
        Animal animal = new Prey();
        if(super.getCount() % 3 ==0 && super.getCount() >0)
        {
//            x = super.getX();
//            y = super.getY();
            rand = super.getRand();
            if(rand == up)
            {
                if(x == 0)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else if(cell[x-1][y].getIsEmpty() == false)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else
                {
//                  cell[x][y].setEmpty();
//                  x--;
                    animal.setXY(x-1, y);
                    cell[x-1][y].setNotEmpty(animal);
                    setAnimal(animal);
                    breed = true;
                    super.setCountToZero();
                }
            }
            else if (rand == right)
            {
                if(y == column-1)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else if(cell[x][y+1].getIsEmpty() == false)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else
                {
//                    cell[x][y].setEmpty();
//                    y++;
                    animal.setXY(x, y+1);
                    cell[x][y+1].setNotEmpty(animal);
                    setAnimal(animal);
                    breed = true;
                    super.setCountToZero();
                }
            }
            else if(rand == down)
            {
                if(x == row-1)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else if (cell[x+1][y].getIsEmpty() == false)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else
                {
//                    cell[x][y].setEmpty();
//                    x++;
                    animal.setXY(x+1, y);
                    cell[x+1][y].setNotEmpty(animal);
                    setAnimal(animal);
                    breed = true;
                    super.setCountToZero();
                }
            }
            else
            {
                if(y == 0)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else if(cell[x][y-1].getIsEmpty() == false)
                {
                    super.setCountToZero();
                    breed = false;
                }
                else
                {
//                    cell[x][y].setEmpty();
//                    y--;
                    animal.setXY(x, y-1);
                    cell[x][y-1].setNotEmpty(animal);
                    setAnimal(animal);
                    breed = true;
                    super.setCountToZero();
                }
            }
        }
        
    }
    public Animal getBreed()
    {
        return rAnimal;
    }
    public boolean isBreed()
    {
        return breed;
    }
    public String getTag()
    {
        return tag;
    }
    
    
}
