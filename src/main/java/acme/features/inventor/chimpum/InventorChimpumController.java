package acme.features.inventor.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.chimpum.Chimpum;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorChimpumController extends AbstractController<Inventor, Chimpum>{
	
	@Autowired
	protected InventorChimpumListService	listService;
	
	@Autowired
	protected InventorChimpumShowService	showService;
	
	
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
		//super.addCommand("create", this.createService);
		//super.addCommand("delete", this.deleteService);
		//super.addCommand("update", this.updateService);
		
	}

}
