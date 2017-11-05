package com.karthik.drools1.Tester;

import org.kie.api.runtime.StatelessKieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karthik.drools1.model.Product;

public class MainTester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		StatelessKieSession kieSession = (StatelessKieSession) applicationContext
				.getBean("applicationStatelessSession");

		Product product = new Product();
		product.setType("gold");

		kieSession.execute(product);
		System.out.println("The discount for the product " + product.getType() + " is " + product.getDiscount());

	}

}
