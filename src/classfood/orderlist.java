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
public class orderlist {
    private int id_c, sum;
    private String  uname;
    
  
    
    public orderlist(int ID_C, int Sum, String Uname )
    {
        this.id_c = ID_C;
       
        this.sum = Sum;
         this.uname = Uname;
        
    }

    
    
    
    public int getId_C()
    {
        return id_c;
    }
    
    public int getSum()
    {
        return sum;
    }
    public String getUname()
    {
        return uname;
    }
    
}
