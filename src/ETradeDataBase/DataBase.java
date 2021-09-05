/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ETradeDataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;                      
import java.util.logging.Logger;                               

/**
 *
 * @author Sekran Mert Kılıç 52522588108
 */
public class DataBase implements DB_Interface{
    
    Customer[] CustomerArray = new Customer[100];         //customer array
    private int CustomerCounter = 0;                      // array counter
    
    @Override
    public void addCustomer(Customer newCustomer) {
        CustomerArray[CustomerCounter] = newCustomer; // saves new customer to array
        CustomerCounter ++;                           // increases index
    }

    @Override
    public void listItems(int ID) {
        for(int i=0; i<CustomerCounter; i++){         //searchs array
            if(CustomerArray[i].getID()== ID){
                Item Dummy = CustomerArray[i].getLink();              //gets first item
                System.out.println(CustomerArray[i].toString() + ", Item List ; ");
                while(Dummy != null){                                //if null stops the loop
                    System.out.println(Dummy.toString());            //prints item
                    Dummy = Dummy.getLink();                         //goes to next one        
                }
            }    
        }
    }

    @Override
    public Customer getNewCustomer(String Name, String Surname, int ID) { //saves new customers atributes
        Customer NewCustomer;
        NewCustomer = new Customer();
        NewCustomer.setID(ID);
        NewCustomer.setName(Name);
        NewCustomer.setSurname(Surname);
        return NewCustomer;
    }

    @Override
    public void addNewItem(Integer ID, String ItemName, String Date, float Price) throws IDNotFoundException{
        boolean Throw = true;                                //Boolean variable to throw exception
        for(int i=0; i<CustomerCounter; i++){
            if(CustomerArray[i].getID()== ID){            
                Throw = false;                               //if ID is found makes throw function false 
                Item FirstItem = CustomerArray[i].getLink(); //saves item pointed by customer 
                Item NewItem = new Item();                   //creates new item
                NewItem.setDate(Date);
                NewItem.setItemName(ItemName);
                NewItem.setPrice(Price);
                NewItem.setLink(FirstItem);        //makes new item point first item
                CustomerArray[i].setLink(NewItem); // makes customers point new item 
                
            }            
        }
        if (Throw){                                     //if ID not found throws exception
            throw new IDNotFoundException();
        }
    }
    
    @Override
    public Float getTotalTradeofCustomer(int ID) {
        float Total = 0;
        for(int i=0; i<CustomerCounter; i++){
            if(CustomerArray[i].getID()== ID){                                  // finds ID
                Item Dummy = CustomerArray[i].getLink();                        //gets first item
                while(Dummy != null){                                           // adds all items
                    Total += Dummy.getPrice();
                    Dummy = Dummy.getLink();                                    // goes to next item
                }
            }
        }
        return (float) Total;                                                   //returns total       
    }

    @Override
    public Float getTotalTrade() {
        float Total = 0;
            for(int i=0; i<CustomerCounter; i++){                               //runs for all customers
                Item Dummy = CustomerArray[i].getLink();                        //gets first item
                while(Dummy != null){                                           // adds all items
                    Total += Dummy.getPrice();
                    Dummy = Dummy.getLink();                                    // goes to next item
                }   
            }
        return (float) Total;                                                   //returns total
    }

    @Override
    public void readFromFile(String path)throws FileNotFoundException {
        File file = new File(path); 
        
        try (Scanner NewFile = new Scanner(file)) {                                                    //because of exception I used try functipn
            while(NewFile.hasNextLine()){
                
                String NewString = NewFile.nextLine();              
                char Select = NewString.charAt(0);                                                     //if string start with number its an item
                if(Select < '0' || Select > '9'){                                                      
                    String[] Dummy = NewString.split(" ");                                             //get this methods from homework 2
                    int ID =  Integer.parseInt( Dummy[2]);                                             //saves first token as ID
                    Customer NewCustomer = getNewCustomer(Dummy[0],Dummy[1],ID);                       
                    addCustomer(NewCustomer);
                }
                else{                                                                                 
                    try {                                                                             
                        String[] Dummy = NewString.split(" ");
                        int ID =  Integer.parseInt(Dummy[0]);                                         //saves first token as ID
                        float Price = Float.parseFloat(Dummy[3]);                                     //saves last token as price
                        addNewItem(ID,Dummy[1],Dummy[2],Price);                                               
                    } 
                    catch (IDNotFoundException ex) {
                        Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        NewFile.close();                                                        //close scanner
        }
        System.out.println("The content of file has been read");
    }

    @Override
    public Customer searchCustomer(int ID) {
        for(int i=0; i<CustomerCounter; i++){
            if(CustomerArray[i].getID()== ID){                                  //search array
                System.out.println("Customer's "+ CustomerArray[i].toString());
                return CustomerArray[i];                                        //returns customer
            }
        }
         System.out.println("There is no such customer");
        return null;                                                            //if there is no such ID returns null
    }
    
}

