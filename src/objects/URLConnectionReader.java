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
import e.learning.ELearning;
import e.learning.Study;
import java.net.*;
import java.io.*;

public class URLConnectionReader extends Thread {

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
        
        
        
        Article a = null;
        
        try{
            
              a = ELearning.sc.getArticle(  Study.jTextField1.getText() );
             
            
       
       if( !a.equals(null)
               
             
               ) 
       
       {
           
           try{
           Study.jTextArea1.setText(a.description);
           
           
           String s ="";
           
           for(int i=0 ;i<a.link.size();i++){
               
               s=s+a.link.get(i);
           }
           
           Study.jTextArea2.setText(s);
           
           }
           
           catch(Exception e){
               
                System.err.println(e.getMessage());
           }
           
       }
       
       
        }
        catch (Exception e){
            
            System.err.println(e.getMessage());
            
            
             if( this.getResult(Study.jTextField1.getText()).contains("nothing"))
          // try 
           {
            
        
           System.err.println("2nd else");
        Study.jTextArea1.setText(  this.search(Study.jTextField1.getText())  );
        
        }
        else 
          // catch(Exception exception)  
           {
             Study.jTextArea1.setText( this.getResult(Study.jTextField1.getText())  );
        }
        }
        
       
      //  this.interrupt();
         
        
        
        
    }
    
    private  BufferedReader br;
    private BufferedWriter bw;
    
    
    public URLConnectionReader(){
      
    }
  
      public String ExtractText( String s ){
        
                      String extracted="";
        //
        
        int c=1;
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='<' )
               {
                   while(s.charAt(i)!='>')
                   {
                       i++;
                   }
               }
            
            else if(s.charAt(i)=='/' && s.charAt(i+1)=='n' ){
                 extracted= extracted+ "\n";
                
                i=i+1;
            }
            
             else if(s.charAt(i)=='['  ){
                 
                  while(s.charAt(i)!=']')
                   {
                       i++;
                   }
               }
            
              else {
                
             
                     extracted= extracted+ Character.toString( s.charAt(i) );   
                   
                   
                   c++;
            }
        }
        
         return extracted;
        
      }
      
     //  BufferedReader br ;
    BufferedReader i;
    
      public String getResult(String in) {
        
          char[] t = in.toCharArray();
          
         t[0] = Character.toUpperCase(t[0] ) ;
         
         in = Character.toString(t[0]);
         
         for(int i=1 ; i< t.length ;i++){
             in = in + Character.toString(
                    Character.toLowerCase( t[i] )
             );
         }
          System.out.println(in);
        
          InputStream inp = URLConnectionReader.class.getResourceAsStream("Oxford English Dictionary.txt");
          br = new BufferedReader (new InputStreamReader(inp)) ;
        
          String s="";
          
          String buffer="";
            
           
              while (true){
          
                  if(s.contains(in+"  "))
                  buffer+=s+"\n";     
                  
                try {
                    s= br.readLine();
                } catch (IOException ex) {
                  //  Logger.getLogger(OxfordDictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            if(s==null) break;
           
        }
              
              if(buffer.equals("")) return 
                       "nothing";
              return 
                      buffer;
    }
    
   public String search(String query){
        
       String out="";
       
       String return_out = null;
       
       //File f = new File(query+".html");
       
       Article a = ELearning.sc.getArticle(  Study.jTextField1.getText() );
       
        {
        
         try{
        
         {
            
       URL url = new URL("https://en.wikipedia.org/wiki/"+query);
        //      URL url = new URL("https://www.google.com/?gws_rd=ssl#q="+query);
        
        
        URLConnection yc = url.openConnection();
        
        
        
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()))) {
            
        //    bw= new BufferedWriter(new FileWriter(new File(query+".html")));
            String inputLine;
            
            int i=0;
            int j=0;
            String similarities ="";
            while ((inputLine = in.readLine()) != null)
                
            {
                //System.out.println(inputLine);
                if(i==2) break;
                
              //  bw.append(inputLine);
                if(inputLine.contains("<p>")  )
                    
                {
                    i++;
                 System.out.println(inputLine);
                 out=out+inputLine+"\n\n";
                 
                
            //     bw.append(inputLine);
                
                 }
                
                  if(i<=1 && j==4 ) break;
                 if( inputLine.contains("<li>" )   )
                    
                {
                    j++;
                 System.out.println(inputLine);
                 similarities=similarities +" >>> "+inputLine+"\n\n";
                 
                
             //    bw.append(similarities);
                
                 }
            }
            out = out+ similarities;
            
          //  bw.close();
        }
    }
         
        }
        
        catch (Exception e){
            
            System.err.println(e.getMessage());
            
        }
        
        return_out=out;
    }
      
       String o=this.ExtractText(return_out);
    
       br =null;
     //  bw=null;
       return o;
     }
 }