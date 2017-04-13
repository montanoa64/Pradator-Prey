/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

/**
 *
 * @author ecko0_000
 */
import java.awt.Image;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Animal {
    private int x;
    private int y;
    private int count;
    private int up;
    private int right;
    private int down;
    private int left;
    private boolean isDead;
    private Random rand = new Random();
    private int n;
    private String tag;
    
    public Animal()
    {
        x =0;
        y=0;
        count=0;
        up=1;
        right=2;
        down=3;
        left=4;
        tag="";
        isDead = false;
    }
    public Image getImg()
    {
        return null;
    }
    public String getTag()
    {
        return tag;
    }
    public int getUp()
    {
        return up;
    }
    public int getRight()
    {
        return right;
    }
    public int getDown()
    {
        return down;
    }
    public int getLeft()
    {
        return left;
    }
    public int getRand()
    {
        return rand.nextInt(4)+1;
    }
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void setDead()
    {
        isDead = true;
    }
    
    public int getX()
    {
        return x;
    }
    public void increaseCount()
    {
        count++;
    }
    public int getCount()
    {
        return count;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean getIsDead()
    {
        return isDead;
    }
    public void  move(Cells [][] cell, int row, int column)
    {}
    public void breed(Cells [][] cell, int row, int column)
    {}
    public void setCountToZero()
    {
        count = 0;
    }
    public Animal getBreed()
    {
        return null;
    }
    public boolean isBreed()
    {
        return false;
    }
    public void setAnimal(Animal animal)
    {
        //this.rAnimal = animal;
    }
    /*public void move(Cells [][] cell, int row, int column)
    {
        breed(cell,row,column);
        if(x == 0)
        {
           if(y == column-1)
           {
               n = rand.nextInt(4)+ 3;
               if(n==3 && cell[x+1][y].getIsEmpty()==true)
               {
                   cell[x][y].setEmpty();
                   x = x+1;
                   cell[x][y].setNotEmpty(this);
                   count+=1;
               }
               else 
               {
                   if(cell[x][y-1].getIsEmpty() ==true)
                   {
                       cell[x][y].setEmpty();
                       y = y-1;
                       cell[x][y].setNotEmpty(this);
                       count+=1;
                   }
                   else
                   {
                       count+=1;
                   }
                   
               }
           }
           else if(y == 0)
           {
               n = rand.nextInt(3)+ 2;
               if(n==2 && cell[x][y+1].getIsEmpty()==true)
               {
                   cell[x][y].setEmpty();
                   y = y+1;
                   cell[x][y].setNotEmpty(this);
                   count+=1;
               }
               else 
               {
                   if(n==3 && cell[x+1][y].getIsEmpty() ==true)
                   {
                       cell[x][y].setEmpty();
                       x = x+1;
                       cell[x][y].setNotEmpty(this);
                       count+=1;
                   }
                   else
                   {
                       count+=1;
                   }
               }
           }
           else
           {
               n = rand.nextInt(4)+ 2;
               if(n==2 && cell[x][y+1].getIsEmpty()==true)
               {
                   cell[x][y].setEmpty();
                   y = y+1;
                   cell[x][y].setNotEmpty(this);
                   count+=1;
               }
               else 
               {
                   if (n==3 && cell[x+1][y].getIsEmpty()==true)
                   {
                        cell[x][y].setEmpty();
                        x = x+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                   }
                   else
                   {
                       if(cell[x][y-1].getIsEmpty() ==true)
                       {
                           cell[x][y].setEmpty();
                           y = y-1;
                           cell[x][y].setNotEmpty(this);
                           count+=1;
                       }
                       else
                       {
                           count+=1;
                       }
                   }
               }
           }
           
        }
        else if(x == row-1 )
        {
            if(y == column-1)
            {
                n = rand.nextInt(2)+ 1;
               if(n==1 && cell[x-1][y].getIsEmpty()==true)
               {
                   cell[x][y].setEmpty();
                   x = x-1;
                   cell[x][y].setNotEmpty(this);
                   count+=1;
               }
               else
               {
                   if(cell[x][y-1].getIsEmpty() ==true)
                   {
                       cell[x][y].setEmpty();
                       y = y-1;
                       cell[x][y].setNotEmpty(this);
                       count+=1;
                   }
               }
               count+=1;
            }
            else if (y == 0)
            {
                n = rand.nextInt(2)+ 1;
                if(n==1 && cell[x-1][y].getIsEmpty()==true)
                {
                    cell[x][y].setEmpty();
                    x = x-1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
                else
                {
                    if(cell[x][y+1].getIsEmpty() ==true)
                    {
                        cell[x][y].setEmpty();
                        y = y+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                    }
                }
                count+=1;
            }
            else
            {
                n = rand.nextInt(3)+ 1;
                if(n==1 && cell[x-1][y].getIsEmpty() == true )
                {
                    cell[x][y].setEmpty();
                    x = x-1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
                else
                {
                    if(n ==2 && cell[x][y+1].getIsEmpty() ==true)
                    {
                        cell[x][y].setEmpty();
                        y = y+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                    }
                    else
                    {
                        if(cell[x][y-1].getIsEmpty() == true)
                        {
                            cell[x][y].setEmpty();
                            y=y-1;
                            cell[x][y].setNotEmpty(this);
                            count+=1;
                        }
                        else
                        {
                            count+=1;
                        }
                    }
                }
                
            }
        }
        else if(y == 0)
        {
            n = rand.nextInt(3)+ 1;
            if(n==1 && cell[x-1][y].getIsEmpty() == true )
            {
                cell[x][y].setEmpty();
                x = x-1;
                cell[x][y].setNotEmpty(this);
                count+=1;
            }
            else
            {
                if(n ==2 && cell[x][y+1].getIsEmpty() ==true)
                {
                    cell[x][y].setEmpty();
                    y = y+1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
                else
                {
                    if(cell[x+1][y].getIsEmpty() == true)
                    {
                        cell[x][y].setEmpty();
                        x=x+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                    }
                    else
                    {
                        count+=1;
                    }
                }
            }
        }
        else if(y == column-1)
        {
            n = rand.nextInt(3)+ 1;
            if(n==1 && cell[x-1][y].getIsEmpty() == true )
                {
                    cell[x][y].setEmpty();
                    x = x-1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
            else
            {
                if(n ==2 && cell[x][y-1].getIsEmpty() ==true)
                {
                    cell[x][y].setEmpty();
                    y = y-1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
                else
                {
                    if(cell[x+1][y].getIsEmpty() == true)
                    {
                        cell[x][y].setEmpty();
                        x=x+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                    }
                    else
                    {
                        count+=1;
                    }
                }
            }
        }
        else
        {
            n = rand.nextInt(4)+ 1;
            if(n==1 && cell[x-1][y].getIsEmpty() == true )
                {
                    cell[x][y].setEmpty();
                    x = x-1;
                    cell[x][y].setNotEmpty(this);
                    count+=1;
                }
                else
                {
                    if(n ==2 && cell[x][y+1].getIsEmpty() ==true)
                    {
                        cell[x][y].setEmpty();
                        y = y+1;
                        cell[x][y].setNotEmpty(this);
                        count+=1;
                    }
                    else
                    {
                        if(n==3 && cell[x+1][y].getIsEmpty() == true)
                        {
                            cell[x][y].setEmpty();
                            x=x+1;
                            cell[x][y].setNotEmpty(this);
                            count+=1;
                        }
                        else
                        {
                            if(cell[x][y-1].getIsEmpty() == true)
                            {
                                cell[x][y].setEmpty();
                                y = y-1;
                                cell[x][y].setNotEmpty(this);
                                count+=1;
                            }
                            else
                            {
                                count+=1;
                            }
                        }
                    }
                }
        }
    }*/
    /*
    public void breed(Cells [][] cell, int row, int column)
    {
        if(count > 3)
        {
            Animal animal = new Animal();
            if(x == 0)
            {
                if(y==0)
                {
                    if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    }   
                    else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                    else
                    {
                        count =0;
                    }
                }//
                else if(y == column-1)
                {
                    if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    }   
                    else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                    else
                    {
                        count =0;
                    }
                }
                else
                {
                   if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    } 
                   else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                   else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                   else
                    {
                        count =0;
                    }
                }
            }
                
                
            
            
            else if(x==row-1)
            {
                if(y==0)
                {
                   if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    } 
                   else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                   else
                    {
                       count =0;
                    }
                }
                else if(y == column-1)
                {
                    if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    } 
                    else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                    else
                    {
                        count=0;
                    }
                }
                else
                {
                    if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    }
                    else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                    else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                    else
                    {
                        count = 0;
                    }
                }
                        
                        
            }
            else if(y==0)
            {
                if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    }
                else if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    } 
                else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                else
                {
                    count = 0;
                }
            }
            else if(y == column-1)
            {
                if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    }
                else if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    } 
                else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                else
                {
                    count =0;
                }
            }
            else
            {
                if(cell[x-1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x-1, y);
                        cell[x-1][y].setNotEmpty(animal);
                        count = 0;
                    }
                else if(cell[x+1][y].getIsEmpty()==true)
                    {
                        animal.setXY(x+1, y);
                        cell[x+1][y].setNotEmpty(animal);
                        count = 0;
                    }
                else if(cell[x][y-1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y-1);
                        cell[x][y-1].setNotEmpty(animal);
                        count = 0;
                    }
                else if(cell[x][y+1].getIsEmpty() == true)
                    {
                        animal.setXY(x, y+1);
                        cell[x][y+1].setNotEmpty(animal);
                        count = 0;
                    }
                else
                {
                    count=0;
                }
            }
        }
            
    }*/
}
    

