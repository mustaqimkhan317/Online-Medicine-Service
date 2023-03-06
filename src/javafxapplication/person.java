/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Souvik
 */
public class person {
    
    private final SimpleStringProperty doctor_id;
  
    private final SimpleStringProperty product_id;
    private final SimpleStringProperty product_name;
    private final SimpleStringProperty doctor_name;
    private final SimpleStringProperty dose;
    private final SimpleStringProperty stock;

    public person(String  doctor_id, String doctor_name, String product_id,String product_name, String dose, String stock) {
        
        this.doctor_id= new SimpleStringProperty(doctor_id);
        this.doctor_name= new SimpleStringProperty(doctor_name);
        this.product_id= new SimpleStringProperty(product_id);
        this.product_name= new SimpleStringProperty(product_name);
        this.dose= new SimpleStringProperty(dose);
          this.stock= new SimpleStringProperty(stock);
        
        
    }

    person(String rsgetString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String getDoctor_id() {
        return doctor_id.get();
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id.set(doctor_id);
    }

    public String getProduct_id() {
        return product_id.get();
    }

    public void setProduct_id(String product_id) {
        this.product_id.set(product_id);
    }
    public String getDoctor_name() {
        return doctor_name.get();
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name.set(doctor_name);
    }

    public String getProduct_name() {
        return product_name.get();
    }

    public void setProduct_name(String product_name) {
        this.product_name.set(product_name);
    }

    public String getDose() {
        return dose.get();
    }

    public void setDose(String dose) {
        this.dose.set(dose);
    }
    
     public String getStock() {
        return stock.get();
    }

    public void setStock(String stock) {
        this.stock.set(stock);
    }
    
    
}
