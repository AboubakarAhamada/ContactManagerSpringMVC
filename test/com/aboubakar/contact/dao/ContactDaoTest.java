package com.aboubakar.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aboubakar.contact.model.Contact;

class ContactDaoTest {
	
	private DriverManagerDataSource dataSource;
	private ContactDao dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_example?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("aboubakar");
		
		dao = new ContactDaoImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Contact contact = new Contact("Someone name's", "him@gmail.com","somewhere","00258");
		int result = dao.save(contact);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(1, "Toni Kroos", "t.kroos@yahoo.gm","Frankfort","0808080808");
		int result = dao.update(contact);
		
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		Integer id =1;
		Contact contact = dao.get(id);
		if(contact !=null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id =3;
		int result = dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact>listContacts = dao.list();
		
		for(Contact contact : listContacts) {
			System.out.println(contact);
		}
		assertTrue(!listContacts.isEmpty());
	}

}
