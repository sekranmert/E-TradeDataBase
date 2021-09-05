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
public interface DB_Interface {
    
    /**
     *
     * @param ID
     * @param ItemName
     * @param Date
     * @param Price
     * @throws IDNotFoundException
     */
    public void addNewItem (Integer ID, String ItemName, String Date, float Price) throws IDNotFoundException;
    public void addCustomer(Customer newCustomer);
    public void listItems(int ID);
    public Customer getNewCustomer(String Name, String Surname, int ID);
    public Float getTotalTradeofCustomer(int ID);
    public Float getTotalTrade();
    public void readFromFile(String path)throws FileNotFoundException;
    public Customer searchCustomer(int ID);
    
}
