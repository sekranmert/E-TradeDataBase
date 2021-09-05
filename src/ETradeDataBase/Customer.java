/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ETradeDataBase;

/**
 *
 * @author Sekran Mert Kılıç 52522588108
 */
public class Customer {

    private String Name;
    private String Surname;
    private int ID;
    private Item Link;
      
    @Override
    public String toString(){

        String retstr = "Name: " + Name;
        retstr = retstr + ", Surname: " + Surname;
        retstr = retstr + ", ID: " + ID;
        return retstr;
    }
    
    public String getName() {                   //get set methods to acces variables
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getSurname() {
        return Surname;
    }
   
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
   
    public int getID() {
        return ID;
    }
   
    public void setID(int ID) {
        this.ID = ID;
    }
   
    public Item getLink() {
        return Link;
    }
   
    public void setLink(Item link) {
        this.Link = link;
    }

}

