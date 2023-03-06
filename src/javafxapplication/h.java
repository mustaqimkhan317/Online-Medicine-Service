/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class h {
    private final SimpleStringProperty hpname;
  
    private final SimpleStringProperty hpID;
    private final SimpleStringProperty hamount;
    private final SimpleStringProperty hprice;

    public h(String  hpname, String hpID, String hamount,String hprice) {
        
        this.hpname= new SimpleStringProperty(hpname);
        this.hpID= new SimpleStringProperty(hpID);
        this.hamount= new SimpleStringProperty(hamount);
        this.hprice= new SimpleStringProperty(hprice);
    }
    
   
    public String getHpname() {
        return hpname.get();
    }

    public void setHpname(String hpname) {
        this.hpname.set(hpname);
    }

    public String getHpID() {
        return hpID.get();
    }

    public void setHpID(String hpID) {
        this.hpID.set(hpID);
    }
    public String getHamount() {
        return hamount.get();
    }

    public void setHamount(String hamount) {
        this.hamount.set(hamount);
    }

    public String getHprice() {
        return hprice.get();
    }

    public void setHprice(String hprice) {
        this.hprice.set(hprice);
    }

    
    
    
}
