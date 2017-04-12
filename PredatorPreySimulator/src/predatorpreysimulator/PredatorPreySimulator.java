/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;

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
        ui.setVisible(true);
        gird grid;
        Animal animal = new Animal();
        //System.out.println("this is main");
        while(true)
        {
            try {
                
                Thread.sleep(1000);
                if(ui.getClose()==true)
                {
                    ui.setVisible(false);
                    grid = new gird(ui.getGridRow(),ui.getGridColumn());
                   // grid.setVisible(true);
                    grid.setOpen();
                    grid.cells[2][2].setNotEmpty(animal);
                    for(int i = 0; i < 1000; i++)
                    {
                        try
                        {
                            Thread.sleep(50);
                            //for(int j=0;j<ui.getGridColumn();j++)
                            //{
                                animal.move(grid.cells, ui.getGridRow(), ui.getGridColumn());
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
