package com.niit.daoimpl;
import java.util.*;
import com.niit.model.productmodel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.dao.DAO;


@Component
public class DAOimpl implements DAO {
	
	
	public productmodel addproduct()
	{

		productmodel m2=new productmodel();

	  m2.setId(12345);
	  m2.setBrand("shopdacjewellery");
	  m2.setName("ring");
	   
	   
	   return m2;
	}
	
	public void delete(productmodel m)
	{}
	public void updated(productmodel m)
	{}
	public void getprodbyid(productmodel m)
	{}
	}

