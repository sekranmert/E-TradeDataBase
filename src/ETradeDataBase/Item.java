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
public class Item {
   
    String ItemName;
    String Date;
    float Price;
    Item Link;
    
    @Override
    public String toString() {                               //toString method writen like customer class' method
       String retstr = ItemName + " ";
       retstr += Date + " ";
       retstr += Price;
       return retstr;
   }

    public String getItemName() {                           // get and set methods to acces variables
        return ItemName;
    }
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
    public float getPrice() {
        return Price;
    }
    public void setPrice(float Price) {
        this.Price = Price;
    }
    public Item getLink() {
        return Link;
    }
    public void setLink(Item Link) {
        this.Link = Link;
    }

}
