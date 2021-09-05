/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ETradeDataBase;

import java.io.FileNotFoundException;

/**
 *
 * @author Sekran Mert Kılıç 52522588108
 */
public class ETradeDataBase {

    /**
     * @param args the command line arguments
     * @throws ETradeDataBase.IDNotFoundException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IDNotFoundException, FileNotFoundException {
        // TODO code application logic here
        
        DataBase MyDataBase = new DataBase();
        Customer DummyCustomer = new Customer();
        
        MyDataBase.readFromFile("c:\\MyData.txt");
        Float exps = MyDataBase.getTotalTradeofCustomer(13456);
        System.out.println(MyDataBase.searchCustomer(13456)+ " Total Expense :" + exps);
        System.out.println("The Total Trade : "+MyDataBase.getTotalTrade());
        MyDataBase.listItems(13456);
        
        Customer newc;
        newc = MyDataBase.getNewCustomer("Ali", "Veli", 4950);
        MyDataBase.addCustomer(newc);
        MyDataBase.addNewItem(4950,"Karburator", "Monday", (float) 145.8);
        MyDataBase.addNewItem(4950,"Laptop","Tuesday", (float)2340);
        System.out.println("The Total Trade : "+ MyDataBase.getTotalTrade());
        MyDataBase.listItems(4950);  
            
    }
    
}
