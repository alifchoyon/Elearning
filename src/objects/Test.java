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
public class Test {
    
    public int id , facultyid;
    public String name ,
           course_id,
           starting_time_slot_id,
           ending_time_slot_id
           ;
    
    public TimeSlot s , e;

    public Test(int id,  String name, String course_id, 
            String starting_time_slot_id, 
            String ending_time_slot_id ,
            int facultyid) {
        this.id = id;
        this.facultyid = facultyid;
        this.name = name;
        this.course_id = course_id;
        this.starting_time_slot_id = starting_time_slot_id;
        this.ending_time_slot_id = ending_time_slot_id;
    }
    
    
           
    
}
