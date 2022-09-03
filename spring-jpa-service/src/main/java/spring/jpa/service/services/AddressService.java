package spring.jpa.service.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import spring.jpa.service.beans.Address;

public class AddressService {

	private EntityManager manager;
	private EntityTransaction transaction;
	
	public AddressService(EntityManager manager, EntityTransaction transaction) {
		this.manager = manager;
		this.transaction = transaction;
	}
	
	public void saveAddress(Address address) {
		
		transaction.begin();
		manager.persist(address);
		transaction.commit();
	}
	
	public void saveAllAddress(List<Address> address) {
		
		transaction.begin();
		manager.persist(address);
		transaction.commit();
	}
	
	public Address findAddress(int id) {
		
		return manager.find(Address.class, id);
	}
	
	public void updateAddress(Address address) {
		
		transaction.begin();
		
		Address addressOld = manager.find(Address.class, address.getId());
		
		addressOld.setAddress(address.getAddress());
		addressOld.setLandmark(address.getLandmark());
		addressOld.setState(address.getState());
		addressOld.setType(address.getType());
		addressOld.setZipcode(address.getZipcode());
		
		transaction.commit();
	}
}
