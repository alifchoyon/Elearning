/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author hiddenDimension
 */
public class TimeSlot {
    
   public int id , hour , minute,
        
            year , month , day ;

    public TimeSlot(int id, int hour, int minute, int year, int month, int day) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
   
    
    
}
