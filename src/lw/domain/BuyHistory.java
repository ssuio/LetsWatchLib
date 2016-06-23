/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lw.domain.Member.birthdayFormat;

/**
 *
 * @author adm
 */
public class BuyHistory {
    private int number;
    private String orderId;
    private java.util.Date buydate;
    private String product;
    private int price;
    private PayWay pay;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    private String state;
    
    public BuyHistory(){
    super();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) throws LWException {
        if(buydate != null){
            buydate=buydate.replace('-', '/');
         try{
        Date d = birthdayFormat.parse(buydate);
        this.buydate=d;
        }catch(ParseException ex){
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, "日期格式不正確", ex);
            throw new LWException ("日期不正確 " + buydate, ex);
            
        }
        }else{
            this.buydate = null;
        }
    }

    public void setBuydate(java.util.Date buydate) throws LWException {
            this.buydate = buydate;
    }
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PayWay getPay() {
        return pay;
    }

    public void setPay(PayWay pay) {
        this.pay = pay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BuyHistory{" + "orderId=" + orderId + ", buydate=" + buydate + ", product=" + product + ", price=" + price + ", pay=" + pay + ", state=" + state + '}';
    }
    
    
}
