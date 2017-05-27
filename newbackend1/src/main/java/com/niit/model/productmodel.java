package com.niit.model;
import javax.persistence.*;

@Entity
@Table(name = "Product" )
public class productmodel {


   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "Id",unique=true)
   private int Id;

   @Column(name = "name")
   private String name;

   @Column(name = "brand")
   private String brand;

  
   public productmodel() {}
   public int getId() {
      return Id;
   
   
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public void setId(int Id) {
	this.Id = Id;
}}
