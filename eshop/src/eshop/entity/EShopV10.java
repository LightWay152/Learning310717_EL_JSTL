package eshop.entity;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EShopV10 {
	public static Session openSession() {
		Configuration config = new AnnotationConfiguration().configure("eshop.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		demo4();
	}

	private static void demo4() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Username: ");;
		String id = scanner.nextLine();
		
		System.out.print("Password: ");;
		String pw = scanner.nextLine();		
		
		Session session = EShopV10.openSession();
		
		try {
			Customer user = (Customer) session.get(Customer.class, id);
			
			if(pw.endsWith(user.getPassword())){
				System.out.println("Login sucessfully!");
			}
			else{
				System.out.println("Invalid password!");
			}
		} catch (Exception e) {
			System.out.println("Invalid username!");
		}
	
	}

	private static void demo3() {	
		Category entity = new Category();
		entity.setName("Book");
		entity.setNameVN("Sách");
		
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {			
			session.save(entity);
			t.commit();
			System.out.println(">Insert successfully!");
		} catch (Exception e) {
			t.rollback();
			System.out.println(">Insert failed!");
		}
		
	}

	private static void demo2() {
		Session session = EShopV10.openSession();
		String hql = "FROM Product WHERE unitPrice BETWEEN :min AND :max";
		Query query = session.createQuery(hql);
		query.setDouble("min", 5.0);
		query.setDouble("max", 10.0);
		List<Product> list = query.list();
		
		for(Product p:list){
			System.out.println(">Name: "+p.getName());
			System.out.println(">UnitPrice: "+p.getUnitPrice());
			System.out.println();
		}
	}

	private static void demo1() {
		Session session = EShopV10.openSession();		
		OrderDetail detail = (OrderDetail) session.get(OrderDetail.class,100007);	
		Order order = detail.getOrder();
		Customer customer = order.getCustomer();
		Product product = detail.getProduct();
		Category category = product.getCategory();
		
		System.out.println(">OrderDetailId: "+detail.getId());
		System.out.println(">OrderId: "+order.getId());
		System.out.println(">ProductId: "+product.getId());
		System.out.println(">CustomerId: "+customer.getId());
		System.out.println(">CategoryId: "+category.getId());
	}

}
