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
import java.util.Random;

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
    
    public Animal()
    {
        x =0;
        y=0;
        count=0;
        up=1;
        right=2;
        down=3;
        left=4;
        
        isDead = false;
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
    
    public int getY()
    {
        return y;
    }
    
    public boolean getIsDead()
    {
        return isDead;
    }
    
    public void move(Cells [][] cell, int row, int column)
    {
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
    }
    
}
