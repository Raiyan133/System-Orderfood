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
public class juice {
   private int id_ju;
    private String name_ju;
    private int price_ju;
  
    
    public juice(int ID_J, String Name_J, int Price_J)
    {
        this.id_ju = ID_J;
        this.name_ju = Name_J;
        this.price_ju = Price_J;
        
    }

    
    
    public int getId()
    {
        return id_ju;
    }
    
    public String getName()
    {
        return name_ju;
    }
    
    public int getPrice()
    {
        return price_ju;
    } 
}
