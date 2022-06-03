package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorChimpumListService implements AbstractListService<Inventor, Chimpum>{
	
	@Autowired
	protected InventorChimpumRepository repository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Chimpum> findMany(final Request<Chimpum> request) {
		Collection<Chimpum> result;
		
		final Integer inventorId = request.getPrincipal().getActiveRoleId();
		
		result = this.repository.findChimpumsByInventor(inventorId);

		return result;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert model != null;
		assert entity!=null;
		
		final String defaultCurrency = this.repository.getSystemConfiguration().getSystemCurrency();
		
		final Money budget = MoneyExchange.of(entity.getBudget(), defaultCurrency).execute().getTarget();
		
		model.setAttribute("budget", budget);
		
		request.unbind(entity, model, "code", "title", "description");
		
	}

}
