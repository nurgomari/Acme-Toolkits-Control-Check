package acme.features.inventor.chimpum;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chimpum.Chimpum;
import acme.entities.inventions.Invention;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorChimpumRepository extends AbstractRepository{
	
	@Query("SELECT c from Chimpum c where c.invention.inventor.id = ?1")
	List<Chimpum> findChimpumsByInventor(int masterId);
	
	@Query("SELECT c FROM SystemConfiguration c")
	SystemConfiguration getSystemConfiguration();
	
	@Query("SELECT c.invention FROM Chimpum c where c.id = ?1")
	Invention findInventionOfChimpum(int chimpumId);
	
	@Query("SELECT c FROM Chimpum c where c.id = ?1")
	Chimpum findChimpumById(int id);
}
