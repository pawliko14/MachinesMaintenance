package net.codejava.spring.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;

import org.junit.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.spring.model.Machine;

public class MachineDAOTest {
	private DriverManagerDataSource dataSource;
	private MachineDAO dao;
	
	@Before
	public void SetDriverSettings()
	{
		dataSource = new  DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://192.168.90.182:3306/maintenance");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		dao = new MachineDAOImpl(dataSource);

	}
	
	@Test
	public	void testSaveOrUpdate() {
		Machine contact = new Machine("maszynka test", "kod test", "wydzial test", "gniazdo test", "sprawnosc test");			
		int result  = dao.saveOrUpdate(contact);
		
		
		assertTrue(result >0);
		System.out.println("test completed, result : " + result);

		
	}

	@Test
	public	void testDelete() {
		Integer id = 299;
		int result = dao.delete(id);
		
		assertTrue(result > 0 );

	}

	@Test
	public	void testGet() {
		Integer id = 100;
		Machine machine = dao.get(id);
		
		System.out.println("retriving data where id : "+ id + " succedded" );
		assertNotNull(machine);
				
	}

	@Test
	public	void testList() {
		fail("Not yet implemented");
	}

}
