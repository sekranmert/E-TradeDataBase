/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ETradeDataBase;

/**
 *
 * @author sekra
 */
public class IDNotFoundException extends Throwable { // Exception for AddNewItem method

    
    public IDNotFoundException () {     //Found at internet #https://www.javatpoint.com/custom-exception
        super("IDNotFoundException");
    }
}
