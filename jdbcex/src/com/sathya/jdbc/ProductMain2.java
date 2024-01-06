package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;

class ProductMain1 {
	public static void main(String[] args) {
	ProductDao dao = new ProductDao();
		int createResult = dao.createProducttable();
		System.out.println("Table creation status..."+createResult);
	}
}

public class ProductMain2{
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product product1 = new Product();
		product1.setProId("PR");
		product1.setProName("RICE");
		product1.setProPrice(456.5);
		int res = dao.saveProduct(product1);
		if(res==1) {
			System.out.println("data inserted successfully..."+res);
		}
		else {
			System.out.println("data insersion fail check once..."+res);
		}
		
	}
}
class ProductMain3{
	public static void main(String[]args) {
		ProductDao dao = new ProductDao();
		Product product = dao.findById("PQ");
		if(product!=null) {
			System.out.println("product available..");
			System.out.println(product.getProId()+" "+product.getProName()+" "+product.getProPrice());
		}
		else {
			System.out.println("produc not available...");
		}
	
	}
	
}

class ProductMain4 {
	public static void main(String[] args) { 
		ProductDao dao = new ProductDao();
		List<Product> products = dao.findAll();
		products.forEach(product->System.out.println(product));
	}
}
class ProductMain5 {
	public static void main(String[] args) { 
		ProductDao dao = new ProductDao();
		int count = dao.updateProduct(200, 5);
		System.out.println("updated records count.."+count);
	}
}
class ProductMain6{
	public static void main(String[]args){
		ProductDao dao = new ProductDao();
		int count=dao.deleteProductById("PS");
		System.out.println("deleted records"+count);
	}
	
}
class ProductMain7{
	public static void main(String[]args){
		ProductDao dao = new ProductDao();
		int count=dao.deleteProductByPrice(200);
		System.out.println("deleted records"+count);
	}
	
}
class ProductMain8 {
	public static void main(String[] args) { 
		ProductDao dao = new ProductDao();
		int count = dao.droptable();
		System.out.println("Table is dropped status...."+count);
	}
}
