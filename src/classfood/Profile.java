/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfood;

/**
 *
 * @author raiyan133
 */
public class Profile {
    
    private String name_p, date_p,numphone_p;
    private int id_p, numtable_p;
  
    
    public Profile(int ID_P,String Name_P, String Numphone_P, int Numtable_P,String Date_P)
    {
        this.id_p = ID_P;
        this.name_p = Name_P;
        this.numphone_p = Numphone_P;
        this.numtable_p = Numtable_P;
        this.date_p = Date_P;
       
    }

   
    

    
    
    public int getID()
    {
        return id_p;
    }
    public String getName()
    {
        return name_p;
    }
    
    public String getNumPhone()
    {
        return numphone_p;
    }
    
    public int getNumTable()
    {
        return numtable_p;
    }
    
    public String getDate()
    {
        return date_p;
    }
    
}
