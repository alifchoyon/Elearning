/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author student
 */
public class AssignmentO {
    
    public int id,starting_time_slot_id,
            ending_time_slot_id,
            
            facultyid;
    
    
    public TimeSlot sid , eid;
    public AssignmentO(int id, String name,
            String description,  String link,
            int starting_time_slot_id, int ending_time_slot_id, int facultyid) 
    {
        this.id = id;
        this.starting_time_slot_id = starting_time_slot_id;
        this.ending_time_slot_id = ending_time_slot_id;
        this.facultyid = facultyid;
        this.name = name;
        this.description = description;
        this.link = link;
    }
    
    
    
    public String name,description,link;

    

    
    
    
}
