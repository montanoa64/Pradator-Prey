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
    private int countStarve;
    
    public Predator()
    {
        
        super();
        countStarve =0;
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
        countStarve = 0;
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
    public void setBreedF()
    {
        breed = false;
    }
    @Override
    public Animal getBreed()
    {
        return rAnimal;
    }
    @Override
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public Image getImg()
    {
        return img;
    }
    public void increaseCountStarve()
    {
        countStarve++;
    }
    public void setCountStarveZero()
    {
        countStarve=0;
    }
    public int getX()
    {return x;}
    public int getY()
    {return y;}
    @Override
    public boolean isBreed()
    {
        return breed;
    }
    @Override
    public void move(Cells [][] cell, int row, int column)
    {
//        x = super.getX();
//        y = super.getY();
        breed(cell,row,column);
        rand = super.getRand();
        if(rand == up)
        {
            if(x == 0)
            {
                increaseCountStarve();
                super.increaseCount();
            }
            else if(/*cell[x-1][y].getIsEmpty() == false && */"predator".equals(cell[x-1][y].getTag()))
            {
                increaseCountStarve();
                super.increaseCount();
            }
            else if(cell[x-1][y].getIsEmpty()==false&& cell[x-1][y].getTag().equals("prey"))
            {
                eat = true;
                cell[x][y].setEmpty();
                x--;
                cell[x][y].animalCell.setDead();
                cell[x][y].setEmpty();
                
                cell[x][y].setNotEmpty(this);
                setCountStarveZero();
                //increaseCountStarve();
                
                //super.setCountToZero();
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                x--;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
                increaseCountStarve();
            }
        }
        else if (rand == right)
        {
            if(y == column-1)
            {
                increaseCountStarve();
                super.increaseCount();
            }
            else if(/*cell[x-1][y].getIsEmpty() == false && */"predator".equals(cell[x][y+1].getTag()))
            {
                increaseCountStarve();
                super.increaseCount();
            }
            else if(/*cell[x][y+1].getIsEmpty() == false && */cell[x][y+1].getTag().equals("prey"))
            {
                eat = true;
                cell[x][y].setEmpty();
                y++;
                cell[x][y].animalCell.setDead();
                cell[x][y].setEmpty();
                cell[x][y].setNotEmpty(this);   
                setCountStarveZero();
                //increaseCountStarve();
                //super.setCountToZero();
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                y++;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
                increaseCountStarve();
            }
        }
        else if(rand == down)
        {
            if(x == row-1)
            {
                super.increaseCount();
                increaseCountStarve();
            }
            else if(/*cell[x-1][y].getIsEmpty() == false && */"predator".equals(cell[x+1][y].getTag()))
            {
                super.increaseCount();
                increaseCountStarve();
            }
            else if (/*cell[x+1][y].getIsEmpty() == false && */cell[x+1][y].getTag().equals("prey"))
            {
                eat = true;
                cell[x][y].setEmpty();
                x++;
                cell[x][y].animalCell.setDead();
                cell[x][y].setEmpty();
                cell[x][y].setNotEmpty(this);
                setCountStarveZero();
                //increaseCountStarve();
                //super.setCountToZero();
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                x++;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
                increaseCountStarve();
            }
        }
        else
        {
            if(y == 0)
            {
                super.increaseCount();
                increaseCountStarve();
            }
            else if(/*cell[x-1][y].getIsEmpty() == false && */"predator".equals(cell[x][y-1].getTag()))
            {
                super.increaseCount();
                increaseCountStarve();
            }
            else if(/*cell[x][y-1].getIsEmpty() == false && */cell[x][y-1].getTag().equals("prey"))
            {
                eat = true;
                cell[x][y].setEmpty();
                y--;
                cell[x][y].animalCell.setDead();
                cell[x][y].setEmpty();
                cell[x][y].setNotEmpty(this);
                setCountStarveZero();
                //increaseCountStarve();
                //super.setCountToZero();
                super.increaseCount();
            }
            else
            {
                cell[x][y].setEmpty();
                y--;
                cell[x][y].setNotEmpty(this);
                super.increaseCount();
                increaseCountStarve();
            }
        }
        
        starve(cell);
        eat = false;
        
    }
    @Override
    public void setAnimal(Animal animal)
    {
        this.rAnimal = animal;
    }
    
    @Override
    public void breed(Cells [][] cell, int row, int column)
    {
        //rAnimal = null;
        Animal animal = new Predator();
        if(super.getCount() % 8 ==0 && super.getCount() > 0)
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
    public void starve(Cells [][] cell)
    {
        if(countStarve%3 ==0 && eat == false)
        {
            cell[x][y].setEmpty();
            super.setDead();
            
        }
    }
    @Override
    public String getTag()
    {
        return tag;
    }
    
}
