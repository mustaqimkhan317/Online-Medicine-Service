/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

/**
 *
 * @author Souvik
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class product {
    
    private final SimpleStringProperty pptid;
    private final SimpleStringProperty pptname;
    private final SimpleStringProperty pptc;
    private final SimpleStringProperty ppts;
    private final SimpleStringProperty pptprice;

    public product(String  pptid, String pptname, String pptc,String ppts, String pptprice) {
        
        this.pptid= new SimpleStringProperty(pptid);
        this.pptname= new SimpleStringProperty(pptname);
        this.pptc= new SimpleStringProperty(pptc);
        this.ppts= new SimpleStringProperty(ppts);
        this.pptprice= new SimpleStringProperty(pptprice);
        //this.patient_name= new SimpleStringProperty(patient_name);
        
        
    }

    
   
    public String getPptid() {
        return pptid.get();
    }

    public void setPptid(String pptid) {
        this.pptid.set(pptid);
    }

    public String getPptname() {
        return pptname.get();
    }

    public void setPptname(String pptname) {
        this.pptname.set(pptname);
    }
    public String getPptc() {
        return pptc.get();
    }

    public void setPptc(String pptc) {
        this.pptc.set(pptc);
    }
    
    public String getPpts() {
        return ppts.get();
    }

    public void setPpts(String ppts) {
        this.ppts.set(ppts);
    }
    

    public String getPptprice() {
        return pptprice.get();
    }

    public void setPpptprice(String pptprice) {
        this.pptprice.set(pptprice);
    }
}
