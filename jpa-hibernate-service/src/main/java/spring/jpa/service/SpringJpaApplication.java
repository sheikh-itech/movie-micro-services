package spring.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import spring.jpa.service.beans.Address;
import spring.jpa.service.services.AddressService;

public class SpringJpaApplication 
{
	private static AddressService addressService;
	
    public static void main( String[] args )
    {

    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
    	EntityManager manager = factory.createEntityManager();
    	EntityTransaction transaction = manager.getTransaction();
    	
    	
    	
    	Address address = new Address("Tempo1", "Shyam Talkeej", "Narsinghpur", 222);
    	
    	addressService = new AddressService(manager, transaction);
    	//addressService.saveAddress(address);
    	address = addressService.findAddress(1);
    	System.err.println(address);
    	address.setState("MP");
    	addressService.updateAddress(address);
    	
    	
    	
    	
    	
    	
    	manager.close();
    	factory.close();
    }
}
