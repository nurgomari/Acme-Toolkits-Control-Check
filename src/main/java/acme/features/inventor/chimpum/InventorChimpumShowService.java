package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.entities.inventions.Invention;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorChimpumShowService implements AbstractShowService<Inventor, Chimpum>{
	
	@Autowired
	protected InventorChimpumRepository repository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		final boolean result;
		final int chimpumId;
		final Invention invention;
		
		chimpumId = request.getModel().getInteger("id");
		invention = this.repository.findInventionOfChimpum(chimpumId);
		result=(invention != null && request.getPrincipal().getAccountId() == invention.getInventor().getUserAccount().getId());
	
		return result;
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;

		Chimpum result;
		int chimpumId;

		chimpumId = request.getModel().getInteger("id");
		result = this.repository.findChimpumById(chimpumId);

		return result;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String defaultCurrency =  this.repository.getSystemConfiguration().getSystemCurrency();
		
		final Money budget = MoneyExchange.of(entity.getBudget(), defaultCurrency).execute().getTarget();
		
		final Invention invention = entity.getInvention();
		final String name = invention.getName();
		final String code = invention.getCode();
		final String description = invention.getDescription();
		
		model.setAttribute("budget", budget);
		model.setAttribute("name", name);
		model.setAttribute("inventionCode", code);
		model.setAttribute("inventionDescription", description);
		request.unbind(entity, model, "code", "creationMoment", "title", "description", "startTime", "endTime","link");
		
	}

}
