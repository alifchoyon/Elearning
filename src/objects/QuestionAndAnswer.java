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
public class QuestionAndAnswer {
    
    public int id, testid, facultyid;
    public String question , answer ;
    public ArrayList<String> options;

    public QuestionAndAnswer(int id,String question, String answer,  int facultyid ,int testid, ArrayList<String> options) {
        this.id = id;
        this.testid = testid;
        this.facultyid = facultyid;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
    
    
    public QuestionAndAnswer(int id,String question, String answer,  int facultyid ,int testid) {
        this.id = id;
        this.testid = testid;
        this.facultyid = facultyid;
        this.question = question;
        this.answer = answer;
    }
    
    
    
}
