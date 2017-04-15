/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author montanoa64
 */
public class PredatorPreySimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UI ui = new UI();
        ui.setBackground(Color.GREEN);
        ui.setVisible(true);
        gird grid;
        Random rand = new Random();
        ArrayList<Animal> listprey =new ArrayList<Animal>();
        ArrayList<Animal> listprey2 =new ArrayList<Animal>();
        ArrayList<Animal> listPredator = new ArrayList<Animal>();
        ArrayList<Animal> listPredator2 = new ArrayList<Animal>();
        int row;
        int column;
        while(true)
        {
            try {
                
                Thread.sleep(1000);
                if(ui.getClose()==true)
                {
                    ui.setVisible(false);
                    for(int i =0; i < ui.getPreyCount();i++)
                    {
                        listprey.add(new Prey());
                    }
                    for(int i = 0; i < ui.getPredatorCount();i++)
                    {
                        listPredator.add(new Predator());
                    }
                    
                    grid = new gird(ui.getGridRow(),ui.getGridColumn());
                   // grid.setVisible(true);
                    grid.setOpen();
                    for(Animal obj:listprey)
                    {
                        row = rand.nextInt(ui.getGridRow());
                        column = rand.nextInt(ui.getGridColumn());
                        while(grid.cells[row][column].getIsEmpty() == false)
                        {
                            row = rand.nextInt(ui.getGridRow());
                            column = rand.nextInt(ui.getGridColumn());
                        }
                        grid.cells[row][column].setNotEmpty(obj);
                    }
                    
                    for(Animal obj:listPredator)
                    {
                        row = rand.nextInt(ui.getGridRow());
                        column = rand.nextInt(ui.getGridColumn());
                        while(grid.cells[row][column].getIsEmpty() == false)
                        {
                            row = rand.nextInt(ui.getGridRow());
                            column = rand.nextInt(ui.getGridColumn());
                        }
                        grid.cells[row][column].setNotEmpty(obj);
                    }
                    for(int i = 0; i < ui.getTime(); i++)
                    {
                        try
                        {
                            Thread.sleep(0000);
                            
                            
                   
                            for(Animal obj:listPredator)
                                obj.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
                            
                            for(Animal obj:listPredator)
                            {
                                if(obj.isBreed() == true)
                                {
                                    //grid.cells[rand.nextInt(ui.getGridRow()-1)][rand.nextInt(ui.getGridColumn()-1)].setNotEmpty(obj);
                                    // n = obj.getBreed();
                                    listPredator2.add(obj.getBreed());
                                    obj.setBreedF();
                                }
                            }
                            for(Animal n:listPredator2)
                            {
                                if(n != null)
                                {
                                    listPredator.add(n);
                                }
                            }
                            listPredator2.clear();
                            
                            for(Animal obj:listPredator)
                                
                            {
                                if(obj.getIsDead() == true)
                                {
                                    grid.cells[obj.getX()][obj.getY()].setEmpty();
                                    obj = null;
                                }
                                if(obj != null)
                                {
                                    listPredator2.add(obj);
                                }
                            }
                            listPredator.clear();
                            //listprey.clear();
                            for(Animal obj:listPredator2)
                            {
                                if(obj != null)
                                {
                                    listPredator.add(obj);
                                }
                            }
                            listPredator2.clear();
                            
                            
                            
                            
                            
                            
                            
                            for(Animal obj:listprey)
                                obj.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
                            for(Animal obj:listprey)
                            {
                                if(obj.isBreed() == true)
                                {
//                                    grid.cells[rand.nextInt(ui.getGridRow()-1)][rand.nextInt(ui.getGridColumn()-1)].setNotEmpty(obj);
                                    // n = obj.getBreed();
                                    listprey2.add(obj.getBreed());
                                    obj.setBreedF();
                                }
                            }
                            for(Animal n:listprey2)
                            {
                                if(n != null)
                                {
                                    listprey.add(n);
                                }
                            }
                            listprey2.clear();
                            for(Animal obj:listprey)
                            {
                                if(obj.getIsDead() == true)
                                {
                                    obj = null;
                                }
                                if(obj != null)
                                {
                                    listprey2.add(obj);
                                }
                            }
                            listprey.clear();
                            for(Animal obj:listprey2)
                            {
                                if(obj != null)
                                {
                                    listprey.add(obj);
                                }
                            }
                            listprey2.clear();
                                
//                                animal.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
//                                animal2.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
                            //}
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    break;
                }
            } 
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("this is end");
        //gird grid = new gird();
        //boolean yes = true;
        //grid.setOpen();
//        if(ui.getClose() == true)
//            yes = true;
//        if(yes == true)
//        {
//            grid.setOpen();
//        }
    }
    
}
