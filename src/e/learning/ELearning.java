/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.learning;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author hiddenDimension
 */
public class ELearning {

    /**
     * @param args the command line arguments
     */
    
    public static SuperClass sc;
    public static void main(String[] args) {
        // TODO code application logic here
        
       
         sc = new SuperClass();
        
         
        // System.out.println( sc.getTimeSlotId(9, 30, 23, 7, 2017) ); 
         
        
       
             JFrame logo=   new Logo();
             logo.setVisible(true);
     
         
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ELearning.class.getName()).log(Level.SEVERE, null, ex);
        }
           
             logo.dispose();
        
      
          
          
      
      initiate();
      
       
      
     // sc.login("alifchoyon@gmail.com", "1234");

       
        
    }

    static void initiate() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          
       
        //  java.awt.EventQueue.invokeLater(new Runnable() {
       //     public void run() {
                new Login().setVisible(true);
         //   }
      //  });
    }
    
    
     

     
    
}
