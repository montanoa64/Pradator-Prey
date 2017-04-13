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
                    
                    grid = new gird(ui.getGridRow(),ui.getGridColumn());
                   // grid.setVisible(true);
                    grid.setOpen();
                    for(Animal obj:listprey)
                    {
                        grid.cells[rand.nextInt(ui.getGridRow()-1)][rand.nextInt(ui.getGridColumn()-1)].setNotEmpty(obj);
                    }
                    for(int i = 0; i < ui.getTime(); i++)
                    {
                        try
                        {
                            Thread.sleep(0);
                            //for(int j=0;j<ui.getGridColumn();j++)
                            //{
//                            Iterator <Animal> itr = listprey.iterator();
//                            while(itr.hasNext())
//                            {
//                                if(itr.next().isBreed()==true)
//                                {
//                                    listprey.add(itr.next().getBreed());
//                                }
//                                itr.next().move(grid.cells, ui.getGridRow(), ui.getGridColumn());
//                            }
                            //Animal n = null;
                            for(Animal obj:listprey)
                            {
                                if(obj.isBreed() == true)
                                {
//                                    grid.cells[rand.nextInt(ui.getGridRow()-1)][rand.nextInt(ui.getGridColumn()-1)].setNotEmpty(obj);
                                    // n = obj.getBreed();
                                    listprey2.add(obj.getBreed());
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
                                obj.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
                            
                                
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
