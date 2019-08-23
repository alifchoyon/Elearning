/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.learning;

import java.awt.Color;
import objects.Article;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import objects.AssignmentO;
import objects.Person;
import objects.QuestionAndAnswer;
import objects.Test;
import objects.TimeSlot;

/**
 *
 * @author hiddenDimension
 */
public class SuperClass {
    
    Connection con;
    Statement stmt;
        
    ResultSet rs;
    
    public Person p;
    
    public JFrame f ;
    
    Color c;
    
    int nextQID=0;
                                 

    public SuperClass() {
        
        this.connectDatabase("localhost", "e-learning", "root", "");
        
       //  c = new Color(51,255,163);
         c= Color.white;
        
    }
    
    public Color getDefaultColor (){
        
       
        
        return c;
    }
    
    public boolean facultySignUp(int id,
                                 String firstName,
                                 String lastName,
                                 String dept,
                                 String pass,
                                 String email,
                                 String gender){
        
        
        
   String s=     "INSERT INTO `faculty` (`facultyid`, `firstName`, `lastName`,"
           + " `dept_name`, `password`, `email`, `gender`) "
           + "VALUES ('"+Integer.toString(id)+"', '"+firstName+"', '"+lastName+"', "
           + "'"+dept+"', '"+pass+"', '"+email+"', '"+gender+"')";
        
        try {
            return stmt.execute(s);
            
            
            
            
        } catch (SQLException ex) {
             
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
        
       
    }
    
    public boolean studentSignUp(int id,
                                 String firstName,
                                 String lastName,
                                 String dept,
                                 String pass,
                                 String email,
                                 String gender){
        
        
        
   String s=     "INSERT INTO `student` (`studentid`, `firstName`, `lastName`,"
           + " `dept_name`, `password`, `email`, `gender`) "
           + "VALUES ('"+Integer.toString(id)+"', '"+firstName+"', '"+lastName+"', "
           + "'"+dept+"', '"+pass+"', '"+email+"', '"+gender+"')";
        
        try {
             return  stmt.execute(s);
            
            
        } catch (SQLException ex) {
             
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
        
       
    }
    public String[] getArticleList(){
        
       // id = '"'+ id +'"';
        
     
        
         String s = "select * from article "  ;
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
             String result = "";
            while(rs.next()){
              
              result = result
                   //   +  rs.getString(1)+" " 
                      + rs.getString(2)+"<br>";
              
             
                
            }
            
                System.out.println(result);
            return  result.split("<br>");
        } catch (SQLException ex) {
           // Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return  null;
    }
    
    
    public ArrayList<String> getArticleLinks(int aid){
        
        ArrayList<String> content = new ArrayList();
        
        String query ="SELECT * FROM `article_links` WHERE `articleid`="+aid;
        
         try {
            rs=stmt.executeQuery(query);
            
            
            while(rs.next()){
              
              content.add(   rs.getString(2)+"\n" );
              
             
                
            }
            
                System.out.println(content);
                
                
           // return  result.split("<br>");
        } catch (SQLException ex) {
           // Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return content;
    }
    
    public Article getArticle(int id){
        
       // id = '"'+ id +'"';
        
        String articleid , articlename, description ,facultyid;
        Article a = null ;
        
        ArrayList<String> links = null;
        
         String s = "select * from article ";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                articleid=rs.getString(1);
                
                
                
                articlename=rs.getString(2);
                
                description=rs.getString(3);
                
                facultyid=rs.getString(4);
                
                
                
                links=this.getArticleLinks(Integer.parseInt(articleid ));
         
                System.err.println(links);
                     
                a= new Article(articleid,
                                articlename, description ,facultyid,
                               links);
               
                return a;
                }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return a;
    }
    
    
     public Article getArticle(String  name){
        
       // id = '"'+ id +'"';
        
        String articleid , articlename, description ,facultyid;
        Article a = null ;
        
        ArrayList<String> links = null;
        
        name ='"'+name+'"';
        
         String s = "select * from article where name LIKE "+name;
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                // if( i == id)
                 {
                articleid=rs.getString(1);
                
                
                
                articlename=rs.getString(2);
                
                description=rs.getString(3);
                
                facultyid=rs.getString(4);
                
                
                
                links=this.getArticleLinks(Integer.parseInt(articleid ));
         
                System.err.println(links);
                     
                a= new Article(articleid,
                                articlename, description ,facultyid,
                               links);
         
                
               
               
                return a;
                }
                 
                 //i++;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
            
                System.err.println(ex.getMessage());
        }
         
        return a;
    }
    
    
    public boolean facultyLogin (String email , String password){
        
        
        
        email = '"'+ email +'"';
        password = '"'+ password +'"';
        
        String s = "select * from faculty where "   + "email="+email+" and password="+password;
        
        try {
            rs=stmt.executeQuery(s);
            
            while(rs.next()){
                
                System.out.println("e.learning.SuperClass.facultyLogin()");
                
                p = new Person (Integer.parseInt( rs.getString(1) ),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                        
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7));
               
                
              //  if(t.equals(email))
              {       
                  //   System.out.println( t );
                    return true;
                    
                    
                    
               
                
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        return false;
    }
    
    
    public boolean studentLogin (String email , String password){
        
        email = '"'+ email +'"';
        password = '"'+ password +'"';
        
        String s = "select * from student where "   + "email="+email+" and password="+password;
        
        try {
            rs=stmt.executeQuery(s);
            
            while(rs.next()){
                
                
                  System.out.println("returnng true" );
                
                p = new Person (Integer.parseInt( rs.getString(1) ),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                        
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7));
           //     String t=  rs.getString("email");
                
                
                
              //  if(t.equals(email))
              {     
                
                  
                    return true;
                    
                    
                    
               
                
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
        return false;
    }
    
    
    public boolean connectDatabase(String ip , String database ,String database_admin , String password){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con=DriverManager.getConnection(
                        "jdbc:mysql://"+ip+":3306/"+database,database_admin,password);
                
                 stmt=con.createStatement();
                 
            } catch (SQLException ex) {
                Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return false;
    }
    
    
    public boolean addArticleLinks(int aid , String link){
        
        String query ="INSERT INTO `article_links` (`articleid`, `links`) "
                + "VALUES ('"+aid+"', '"+link+"');";
        
         try {
            return stmt.execute(query);
         
        } 
    catch (SQLException ex) {
             
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
         
         
         
         
        
       
    }
    
     public boolean addArticle(String name , String description  ,String link ){
        
          this.getArticleList();
          
          String query = "INSERT INTO `article` ( `articleid`,`name`, `description`, `facultyid`)"
                  + " VALUES ( NULL,'"+name+"', '"+description+"', '"+Integer.toString(p.id )+"');";
          
          
    /*try {
            return stmt.execute(query);
         
        } 
    catch (SQLException ex) {
             
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
          
          
          */
    
       int aid;
    
         try {
           // stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
        //    if(returnLastInsertId)
            {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                aid = rs.getInt(1);
            }
            
             
            this.addArticleLinks(aid, this.p.firstName+" :"+ link);
            
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    
    
          
        
        return false;
    }
    
    
    public boolean addArticle(String name , String description  ){
        
          this.getArticleList();
          
          String query = "INSERT INTO `article` ( `articleid`,`name`, `description`, `facultyid`)"
                  + " VALUES ( NULL,'"+name+"', '"+description+"', '"+Integer.toString(p.id )+"');";
          
          
    /*try {
            return stmt.execute(query);
         
        } 
    catch (SQLException ex) {
             
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
          
          
          */
    
       int aid;
    
         try {
           // stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
        //    if(returnLastInsertId)
            {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                aid = rs.getInt(1);
            }
            
             
            
            
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    
    
          
        
        return false;
    }
    
    
    public boolean deleteArticle (int id){
        
        
       
        
       // id = '"'+ id +'"';
        
        String articleid , articlename, description ,facultyid;
        Article a = null ;
        
        ArrayList<String> links = null;
        
         String s = "select * from article ";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                articleid=rs.getString(1);
                
                
                
                articlename=rs.getString(2);
                
                description=rs.getString(3);
                
                facultyid=rs.getString(4);
                
                
                
                String l = "DELETE FROM `article` WHERE `article`.`articleid` = "+articleid;
                
              //  try {
               return  stmt.execute(l);
                
                 }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    
        
        
        
        
        
        return false ;
    }
    
    
    public boolean updateArticle (int id , String name , String description){
        
       
        
        String articleid , articlename, desc ,facultyid;
        Article a = null ;
        
        ArrayList<String> links = null;
        
         String s = "select * from article ";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                articleid=rs.getString(1);
                
                
                
                articlename=rs.getString(2);
                
                desc=rs.getString(3);
                
                facultyid=rs.getString(4);
                
                 String query ="UPDATE `article` SET `name` = '"+name+"', `description` = '"+description+"' "
                + "WHERE `article`.`articleid` = "+articleid;
                
               
                
              //  try {
               return  stmt.execute(query);
                
                 }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    
        
        
        
        
        return false ;
    }
    
    
    public int getTimeSlotId(int hour, int minute,  int day ,  int month , int year){
     
        String query= "SELECT `timeslotid` FROM `time_slot` "
                    + "WHERE `hour`='"+hour+"' AND `minute`='"+minute+"' AND "
                    + "`year`='"+year+"' AND`month`='"+month+"' AND `day`='"+day+"'";
            
         try {
            
                 rs=stmt.executeQuery(query);
            
          
            
            while(rs.next()){
           
                
                
                int id=Integer.parseInt(rs.getString(1) );
                
                return id;
           
               
                
                 }
                
            }
        
        catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return 0;
        
    }
    public int  createTimeSlot(int hour, int minute,  int day ,  int month , int year){
        
        int id = this.getTimeSlotId(hour, minute, day , month , year );
        
        System.err.println("Time slot id :"+id);
       
        if(id==0){
        
            
            String query= "INSERT INTO `time_slot` (`timeslotid`, `hour`, `minute`, `year`, `month`, `day`)"
                    + " VALUES (NULL, '"+hour+"', '"+minute+"', '"+year+"', '"+month+"', '"+day+"');";
         
            try {
                 
                 if(stmt.execute(query)){
                     
                     
                     
                     
                     
                    
                 }
                 
                 id = this.getTimeSlotId(hour, minute, day , month , year );
         
            } 
            catch (SQLException ex) {
             
                 Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
                 
                 
            
            }
            
             return id;
            
            
        }
        else {
            
            return id;
        }
            
        
        
      //  return 0;
       
    }
    
    
    public boolean createTest (  String name, String course_id, 
            String starting_time_slot_id, 
            String ending_time_slot_id ,
            int facultyid){
        
        
        String query = "INSERT INTO `test` (`testid`, `name`, `course_id`, `starting_timeslotid`, `ending_timeslotid`, `facultyid`) "
                + "VALUES (NULL, '"+name+"', '"+Integer.parseInt(course_id)+"', '"+
                
                Integer.parseInt(starting_time_slot_id)+"', '"+Integer.parseInt(ending_time_slot_id) + "', '"+
                facultyid+"');";
        
        
        
            try {
            return stmt.execute(query);
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    
    
     public String[] getTestList(){
        
       // id = '"'+ id +'"';
        
     
        
         String s = "select * from test"  ;
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
             String result = "";
            while(rs.next()){
              
              result = result
                    //  +  rs.getString(1)+" " 
                      + rs.getString(2)+"<br>";
              
             
                
            }
            
                System.out.println(result);
            return  result.split("<br>");
        } catch (SQLException ex) {
           // Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return  null;
    }

    Test getTest(int id) {
            
        Test a = null;
        
          int tid , facultyid;
           String name ,
           course_id,
           starting_time_slot_id,
           ending_time_slot_id
           ;
        
        TimeSlot sid = null , eid = null;
          //  String articleid , articlename, description ,facultyid;
      //  Article a = null ;
        
        ArrayList<String> links = null;
        
         String s = "select * from test";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                tid= Integer.parseInt( rs.getString(1) );
                
                
                
                name=rs.getString(2);
                
                course_id=rs.getString(3);
                
                starting_time_slot_id=rs.getString(4);
                
                ending_time_slot_id=rs.getString(5);
                
                facultyid=Integer.parseInt( rs.getString(6) );
                
                String l = "select * from time_slot  WHERE "   + "timeslotid="+Integer.parseInt(starting_time_slot_id);
                
               // try {
                ResultSet linkresult=stmt.executeQuery(l);
                
                 while(linkresult.next()){
                     
                   //  links.add(linkresult.getString(2));
                     
                     sid= new TimeSlot(Integer.parseInt(linkresult.getString(1)),
                                       Integer.parseInt(linkresult.getString(2)),
                             Integer.parseInt(linkresult.getString(3)),
                             Integer.parseInt(linkresult.getString(4)),
                             Integer.parseInt(linkresult.getString(5)),
                             Integer.parseInt(linkresult.getString(6))
    
                             
                     );
                 
                 
                 }
                 
                   l = "select * from time_slot  WHERE "   + "timeslotid="+Integer.parseInt(ending_time_slot_id);
                
              //  try {
                 linkresult=stmt.executeQuery(l);
                
                 while(linkresult.next()){
                     
                     //links.add(linkresult.getString(2));
                     
                     eid= new TimeSlot(Integer.parseInt(linkresult.getString(1)),
                                       Integer.parseInt(linkresult.getString(2)),
                             Integer.parseInt(linkresult.getString(3)),
                             Integer.parseInt(linkresult.getString(4)),
                             Integer.parseInt(linkresult.getString(5)),
                             Integer.parseInt(linkresult.getString(6))
    
                             
                     );
                 
                 
                 }
          //      }
         
                
                a= new Test( tid,  name, course_id, 
            starting_time_slot_id, 
             ending_time_slot_id ,
            facultyid);
                
                a.s=sid;
                a.e=eid;
                
               
                return a;
                }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        return a ;
    
    }
    
    
    public boolean updateTest (int id ,  String name, String course_id, 
            String starting_time_slot_id, 
            String ending_time_slot_id ,
            int facultyid){
        
        Test a = null;
        
          int tid ;
        
        TimeSlot sid = null , eid = null;
        
         String s = "select * from test";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                tid=Integer.parseInt( rs.getString(1) );
                
                
                
               
                
                 String query ="UPDATE `test` SET `name` = '"+name+"', `course_id` = '"+course_id+"',"
                         + " `starting_timeslotid` = '"+starting_time_slot_id+"', `ending_timeslotid` = '"+ending_time_slot_id+"', "
                         +"`facultyid` = '"+facultyid+"' "
                         + "WHERE `test`.`testid` ="+tid;
                
               
                
              //  try {
               return  !stmt.execute(query);
               
             //  stmt.ex
                
                 }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    
        
        
        
        
        return false ;
    }

    boolean deleteTest(int id) {
            
        String s = "select * from test";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                int tid=Integer.parseInt( rs.getString(1) );
                
                
                
               
                
                 String query ="DELETE FROM `test` WHERE `test`.`testid` ="+tid;
                
               
                
              //  try {
               return  !stmt.execute(query);
               
             //  stmt.ex
                
                 }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    
        
        
        
        
        return false ;
    
    }
    
    public QuestionAndAnswer getQuestionAndAnswer(int id,int testid){
        
        QuestionAndAnswer q=null;
        
           String s = "SELECT * FROM `questionandanswer` WHERE `testid`="+testid;
           
           int qid,fid,tid;
           String question , answer ;
           ArrayList<String> options= new ArrayList();
           
           
           
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                     
                qid=Integer.parseInt( rs.getString(1) );
                question= rs.getString(2);
                answer=rs.getString(3);
                fid=Integer.parseInt( rs.getString(4) );
                tid=Integer.parseInt( rs.getString(5) );
                
                
                
               
                
                 String query ="SELECT * FROM `questionandanswer_options` WHERE `questionid`="+qid;
                
                 ResultSet linkresult=stmt.executeQuery(query);
                
                 while(linkresult.next()){
                     
                   //  links.add(linkresult.getString(2));
                     
                    
                           options.add(  linkresult.getString(2) );
    
                             
                     
                 
                 
                 }
                 
                 q= new QuestionAndAnswer(qid,question,answer,fid,tid,options);
               
                 return q;
                
                 }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    
        
        
        
        
       // return false ;
        
        
        return q;
    }
    
    
    /* 
    String sql = "INSERT INTO table (column1, column2) values(?, ?)";
stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


stmt.executeUpdate();
if(returnLastInsertId) {
   ResultSet rs = stmt.getGeneratedKeys();
    rs.next();
   auto_id = rs.getInt(1);
}
    */
    
    public boolean createQuestionAndAnswer( int testid, int facultyid, String question, String answer, ArrayList<String> options) {
        int qid;
         String sql = "INSERT INTO `questionandanswer` (`questionid`, `question`, `answer`, `facultyid`, `testid`)"
                 + " VALUES ( NULL, '"+question+"', '"+answer+"', '"+facultyid+"', '"+testid+"');";
        
        
        
            try {
           // stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
        //    if(returnLastInsertId)
            {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                qid = rs.getInt(1);
            }
            
             for (int i=0 ; i<options.size();i++) {
                 
                 System.err.println(options.get(i));
                 sql="INSERT INTO `questionandanswer_options` (`questionid`, `options`)"
                         + " VALUES ('"+qid+"', '"+options.get(i)+"');";
                  stmt.execute(sql);
             }
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
            
         
            
       
        return false;
    }
    
    public boolean createQuestionAndAnswer( int qid,int testid, int facultyid, String question, String answer, ArrayList<String> options) {
        
         String query = "INSERT INTO `questionandanswer` (`questionid`, `question`, `answer`, `facultyid`, `testid`)"
                 + " VALUES ('"+qid+"', '"+question+"', '"+answer+"', '"+facultyid+"', '"+testid+"');";
        
        
        
            try {
             stmt.execute(query);
            
            
             for (int i=0 ; i<options.size();i++) {
                 
                 System.err.println(options.get(i));
                 query="INSERT INTO `questionandanswer_options` (`questionid`, `options`)"
                         + " VALUES ('"+qid+"', '"+options.get(i)+"');";
                 stmt.execute(query);
             }
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
            
         
            
       
        return false;
    }
    
    
    public String[] getQuestionList(int testid){
        
       // id = '"'+ id +'"';
        
     
        
         String s = "SELECT * FROM `questionandanswer` WHERE `testid`="+ testid ;
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
             String result = "";
            while(rs.next()){
              
              result = result
                      //+  rs.getString(1)+" " 
                      + rs.getString(2)+"<br>";
              
             
                
            }
            
                System.out.println(result);
            return  result.split("<br>");
        } catch (SQLException ex) {
           // Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return  null;
    }

    
    void updateQuestionAndAnswer(int qid,int testid, int facultyid, String question, String answer, ArrayList<String> options) {
       
        String query = "UPDATE `questionandanswer` "
                + "SET `question` = '"+question+"', `answer` = '"+answer+"', `facultyid` = '"+facultyid+"', `testid` = '"+testid+"' "
                + "WHERE `questionandanswer`.`questionid` = "+qid+";";
        
        
        
            try {
             stmt.execute(query);
             
                query= "DELETE FROM `questionandanswer` WHERE `questionandanswer`.`questionid` = "+qid;
                
              
                
                try{
                stmt.execute(query);
                
                  this.createQuestionAndAnswer(qid, testid, facultyid, question, answer, options);
                }
                catch(SQLException e){
                    
                    System.err.println(e.getMessage());
                    
                }
            
             for (int i=0 ; i<options.size();i++) {
                 
                 System.err.println(options.get(i));
                 query="INSERT INTO `questionandanswer_options` (`questionid`, `options`)"
                         + " VALUES ('"+qid+"', '"+options.get(i)+"');";
                 stmt.execute(query);
             }
            
            
            
            
        } catch (SQLException ex) {
             
             Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
          //   return false;
        }
            
         
            
       
     //   return false;
    
    }

    void deleteQuestionAndAnswer(int qid) {
        
         String   query= "DELETE FROM `questionandanswer` WHERE `questionandanswer`.`questionid` = "+qid;
                
              
                
                try{
                stmt.execute(query);
                
                 
                }
                catch(SQLException e){
                    
                    System.err.println(e.getMessage());
                    
                }
        
        }

    boolean setAnswer(int qid, int sid, int tid, String answer) {
                
               String query = "INSERT INTO `answer` (`questionid`, `studentid`, `testid`, `studentAnswer`)"
                       + " VALUES ('"+qid+"', '"+sid+"', '"+tid+"', '"+answer+"');";
        
        
               //INSERT INTO `answer` (`questionid`, `studentid`, `testid`, `studentAnswer`) VALUES ('1', '77', '2', 'kjn');
        
            try {
            return !stmt.execute(query);
            
            
            
            
        } catch (SQLException ex) {
             
                System.err.println("Set asnwer :"+ex.getMessage());
             //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
                
        
          }
    
    
     public static boolean inTime (int shour ,int smin ,int  sday ,int smonth,int syear,
                    int ehour ,int emin ,int  eday ,int emonth,int eyear){
        
      
        
        LocalDateTime c = LocalDateTime.now();
        LocalDateTime s = LocalDateTime.of(syear, smonth, sday, shour, smin);
        LocalDateTime e = LocalDateTime.of(eyear, emonth, eday, ehour, emin);
        
        System.err.println(c);
        
        return (c.isAfter(s) && c.isBefore(e)   );
     
        
    }
     
    
     void closeConnection (){
         
         try {
            // TODO add your handling code here:
            System.err.println("closig connection");
            
            ELearning.sc.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(studentHome.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
    int getScore(int studentid , int testid){
         
        String query = "SELECT COUNT(`questionid`) " +
"FROM answer NATURAL join questionandanswer " +
"WHERE (answer.studentAnswer LIKE questionandanswer.answer) AND (studentid="+studentid+") AND  (testid="+testid+")";
       
         
            try {
                rs=stmt.executeQuery(query);
           
            
             String result = "";
            while(rs.next()){
              
               return Integer.parseInt(  rs.getString(1) );
              
             
                
            }
            
            
             } catch (SQLException ex) {
                Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return 0;
     }
    
    
    

    boolean createAssignment(String name,
            String link ,
            String description,
            int sid,
            int eid,
            int facultyid
            ) {
        String query ="INSERT INTO `e-learning`.`assignment` (`assignmentid`, `name`, `description`, `link`, `starting_timeslotid`, `ending_timeslotid`, `facultyid`)"
                + " VALUES (NULL, '"+name+"', '"+description+"', '"+link+"', '"+sid+"', '"+eid+"', '"+facultyid+"');";
        
           try {
            return !stmt.execute(query);
            
            
            
            
        } catch (SQLException ex) {
             
                System.err.println("creating assignmentn :"+ex.getMessage());
             //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
         
        
        
        }
    
    
    public String[] getAssignmentList(){
        
       // id = '"'+ id +'"';
        
     
        
         String s = "SELECT * FROM `assignment` WHERE 1"  ;
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
             String result = "";
            while(rs.next()){
              
              result = result
                      //+  rs.getString(1)+" " 
                      + rs.getString(2)+"<br>";
              
             
                
            }
            
                System.out.println(result);
            return  result.split("<br>");
        } catch (SQLException ex) {
           // Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return  null;
    }
    
    
    public TimeSlot getTimeSlot(int id){
        
        String query ="SELECT * FROM `time_slot` WHERE `timeslotid` ="+id;
        
        try{
        
        rs=stmt.executeQuery(query);
        while(rs.next()){
              
             return new TimeSlot( Integer.parseInt( rs.getString(1) ),
                     Integer.parseInt( rs.getString(2)),
                             Integer.parseInt( rs.getString(3)),
                                     Integer.parseInt( rs.getString(4)),
                                             Integer.parseInt( rs.getString(5)),
                                             Integer.parseInt( rs.getString(6)) );
              }
        
        }
        catch (Exception e){
            
        }
         return null;
    }
    
    
    public AssignmentO getAssignment(int id){
        
       // id = '"'+ id +'"';
        
        String name;
            String link ;
            String description;
            int sid;
            int eid;
            int facultyid;
            int aid;
        AssignmentO a = null ;
        
        ArrayList<String> links = null;
        
         String s = "SELECT * FROM `assignment` WHERE 1";
                 //+ "WHERE "   + "articleid="+Integer.parseInt(id);
         
         //SELECT * FROM `article` WHERE articleid='0' or articlename like "Time"
            try {
            rs=stmt.executeQuery(s);
            
            int i=1;
            
            while(rs.next()){
                
                
               
                 if( i == id){
                aid= Integer.parseInt(rs.getString(1) );
                
                
                
                name=rs.getString(2);
                
                description=rs.getString(3);
                
                link=rs.getString(4);
                
                sid = Integer.parseInt( rs.getString(5) );
                
                eid = Integer.parseInt( rs.getString(6) );
                
                facultyid = Integer.parseInt( rs.getString(7) );
                
                
                
              
              
                a= new AssignmentO(aid,
                                name, description,link,sid ,eid,facultyid);
                
                a.sid= this.getTimeSlot(sid);
                a.eid= this.getTimeSlot(eid);
               
                return a;
                }
                 
                 i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return a;
    }

    boolean updateAssignment(int id ,String name,
            String link ,
            String description,
            int sid,
            int eid,
            int facultyid) {
       
        String query ="UPDATE `assignment` SET `name` = '"+name+"', `description` = '"+description+"', "
                + "`link` = '"+link+"', `starting_timeslotid` = '"+sid+"', `ending_timeslotid` = '"+eid+"', "
                + "`facultyid` = '"+facultyid+"' WHERE `assignment`.`assignmentid` ="+id;
        
          try {
            return !stmt.execute(query);
            
            
            
            
        } catch (SQLException ex) {
             
                System.err.println("creating assignmentn :"+ex.getMessage());
             //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
       
    
    }

    boolean deleteAssignment(int id) {
        
        String query ="DELETE FROM `assignment` WHERE `assignment`.`assignmentid` ="+id;
        
          try {
            return !stmt.execute(query);
          } catch (SQLException ex) {
             
                System.err.println("deleting assignmentn :"+ex.getMessage());
             //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
         }

    boolean addStudentAssignment(int sid, int aid, String fname) {
        
        String query = "INSERT INTO `studentassignment` (`assignmentid`, `filename`, `studentid`, `score`) "
                + "VALUES ('"+aid+"', '"+fname+"', '"+sid+"', NULL);";
        
         try {
            return !stmt.execute(query);
          } catch (SQLException ex) {
             
                System.err.println("creating assignmentn :"+ex.getMessage());
             //Logger.getLogger(SuperClass.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    
    }
    
    
    
    
}
