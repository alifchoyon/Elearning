/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author hiddenDimension
 */
public class Article {
    
    public String id , name , description , facultyid;
    
    public ArrayList<String> link;

    public Article(String id, String name, String description, String facultyid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facultyid = facultyid;
    }

    public Article(String id, String name, String description, String facultyid, ArrayList<String> link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facultyid = facultyid;
        this.link = link;
    }
    
    
    
    
}
