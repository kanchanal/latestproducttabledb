package com.niit.dao;
import java.util.List;


import com.niit.model.productmodel;

public interface DAO  {
	
	public productmodel addproduct();
	public void  delete(productmodel m);
	public  void updated(productmodel m);
	public void getprodbyid(productmodel m);

}