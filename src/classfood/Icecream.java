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
public class Icecream {
    

    
    private int id_i;
    private String name_i;
    private int price_i;
  
    
    public Icecream(int ID_I, String Name_I, int Price_I)
    {
        this.id_i = ID_I;
        this.name_i = Name_I;
        this.price_i = Price_I;
        
    }

    
    
    public int getId()
    {
        return id_i;
    }
    
    public String getName()
    {
        return name_i;
    }
    
    public int getPrice()
    {
        return price_i;
    }
    
}