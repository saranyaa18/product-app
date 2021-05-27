 package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		List<String> namelist;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println(" 1. Find All Products");
		System.out.println(" 2. Find the Product By Id");
		System.out.println(" 3. Find the Product By Name");
		System.out.println(" 4. Find the Product By Date");
		System.out.println(" 5. Update the Product Name Based on the Id");
		System.out.println(" 6. Update the Product Expiry date Based on the Id");
		System.out.println(" 7. Adding a Product");
		System.out.println(" 8. Deleting a Product By Id");
		System.out.println(" 9. Deleting a Product By ExpiryDate");
		System.out.println(" 10. Deleting a Product By Name");
		
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Find the Product By Name");
			System.out.println("Enter the Product Name");
			String name = scanner.next();
			try {
				Product product = service.FindByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 4:
			System.out.println("Find the Product By Date");
			try {
			 	date = "06/11/2021";
				dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				Product product=service.findByDate(LocalDate.parse(date,dateFormat));
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;

		case 5:
			System.out.println("Update the Product Name Based on the Id");
			date = "6/5/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 6:
			System.out.println("Update the Product Expiry date Based on the Id");
			date = "06/05/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			updateProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update_expire(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;

		case 7:
			System.out.println("Adding a Product");
			 date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date,dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 8:
			System.out.println("Deleting a Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 9:
			System.out.println("Deleting a Product By Date");
			try {
				 	date = "06/05/2019";
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					service.delete_date(LocalDate.parse(date,dateFormat));
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 10:
			System.out.println("Deleting a Product By Name");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.delete_name(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
		
		case 11:
			System.out.println("Find All Products Names");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;
			
		default:
			break;
		}
		scanner.close();
	}

}
