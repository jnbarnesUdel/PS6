package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	private static PersonDomainModel per1 = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddPerson() {
		
		PersonDAL.addPerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		
		assertNotNull(per2);
		
	}
	
	@Test
	public void UpdateDelete(){
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(), per2.getPersonID());
		
		per2.setLastName("Barnes");
		PersonDAL.updatePerson(per2);
		
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		assertEquals(per2.getLastName(), per3.getLastName());
		assertNotEquals(per1.getLastName(), per3.getLastName());
		
		PersonDAL.deletePerson(per1.getPersonID());
		
		PersonDomainModel per4 = PersonDAL.getPerson(per1.getPersonID());
		
		assertNull(per4);
		
		
	}

}
