package spring.jpa.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.jpa.service.beans.DeliveryAgent;

@Repository
public interface DeliveryAgentRepository extends CrudRepository<DeliveryAgent, Integer>{

}
