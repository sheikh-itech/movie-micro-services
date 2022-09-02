package spring.jpa.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.jpa.service.beans.DeliveryAgent;
import spring.jpa.service.repositories.DeliveryAgentRepository;

@RestController
@RequestMapping("agent")
public class DeliveryAgentResource {

	@Autowired
	private DeliveryAgentRepository agentRepo;
	
	@RequestMapping("register")
	public String registerAgent(@RequestBody DeliveryAgent agent) {
		
		agentRepo.save(agent);
		
		return "Agent detail saved";
	}
}
