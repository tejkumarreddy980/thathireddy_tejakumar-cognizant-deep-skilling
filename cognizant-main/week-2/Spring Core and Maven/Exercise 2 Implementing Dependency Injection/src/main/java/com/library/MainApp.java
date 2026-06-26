package com.library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService b=c.getBean("bookService",BookService.class);
		b.showBooks();
	}

}
