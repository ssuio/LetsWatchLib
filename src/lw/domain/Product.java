/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

/**
 *
 * @author Patty
 */
public class Product {
    private String id;
    private String name;
    private String url;
    private int price ;
    private String description;
    private int status;
    
     public Product(){        
    }
     
         public Product(String id, String name, int Price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(Price);
    }   
        public String getId() {
        return id;
    }

    
    public void setId(String id) {
        if(id!=null){
            this.id = id;
        }else{
            System.err.println("產品編號不得為負數");
        }
    } 
     public String getName() {
        return name;
    }
      public void setName(String name) {
        if(name!=null && (name=name.trim()).length()>0){
            this.name = name;
        }else{
            System.err.println("產品名稱為必要欄位");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
       if(price>=0){
            this.price = price;
        }else{
            System.err.println("產品單價不得為負數");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null){
            description = description.trim();
        }        
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", url=" + url + ", price=" + price + ", description=" + description + ", status=" + status + '}';
    }
    
}
