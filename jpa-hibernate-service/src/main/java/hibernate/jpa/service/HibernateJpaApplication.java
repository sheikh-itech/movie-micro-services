package hibernate.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.jpa.service.beans.Address;
import hibernate.jpa.service.services.AddressService;

public class HibernateJpaApplication 
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
    	
    	List<Address> adrs = addressService.findAllAddress();
    	System.out.println(adrs);
    	adrs.clear();
    	Address address1 = new Address("Tempo1", "Shyam Talkeej", "Narsinghpur", 222);
    	adrs.add(address1);
    	adrs.add(address);
    	addressService.saveAllAddress(adrs);
    	
    	manager.close();
    	factory.close();
    }
}
