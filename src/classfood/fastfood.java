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
public class fastfood {
    private int id_f;
    private String name_f;
    private int price_f;
  
    
    public fastfood(int ID_F, String Name_F, int Price_F)
    {
        this.id_f = ID_F;
        this.name_f = Name_F;
        this.price_f = Price_F;
        
    }

    
    
    public int getId()
    {
        return id_f;
    }
    
    public String getName()
    {
        return name_f;
    }
    
    public int getPrice()
    {
        return price_f;
    }
}
