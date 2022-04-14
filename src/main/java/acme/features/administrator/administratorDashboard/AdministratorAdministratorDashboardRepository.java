package acme.features.administrator.administratorDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAdministratorDashboardRepository extends AbstractRepository {

	
	@Query("select count(c) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT")
	Double findNumberComponents();
	
	@Query("select concat(c.technology,':', c.retailPrice.currency,':', avg(c.retailPrice.amount)) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, c.retailPrice.currency")
	List<String> findAverageRetailPriceComponent();
	
	@Query("select concat(c.technology,':', c.retailPrice.currency,':',stddev(c.retailPrice.amount)) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, c.retailPrice.currency")
	List<String> findDeviationRetailPriceComponent();
	
	@Query("select concat(c.technology,':', c.retailPrice.currency,':', min(c.retailPrice.amount)) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, c.retailPrice.currency")
	List<String> findMinimumRetailPriceComponent();
	
	@Query("select concat(c.technology,':', c.retailPrice.currency,':', max(c.retailPrice.amount)) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, c.retailPrice.currency")
	List<String> findMaximumRetailPriceComponent();
	
	
	
	
	
	@Query("select count(t) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL")
	Double findNumberTools();

	@Query("select concat(t.retailPrice.currency, ':', avg(t.retailPrice.amount)) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
	List<String> findAverageRetailPriceTools();
	
	@Query("select concat(t.retailPrice.currency, ':', stddev(t.retailPrice.amount)) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
	List<String> findDeviationRetailPriceTools();
	
	@Query("select concat(t.retailPrice.currency, ':', min(t.retailPrice.amount)) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
	List<String> findMinimumRetailPriceTools();
	
	@Query("select concat(t.retailPrice.currency,':', max(t.retailPrice.amount)) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
	List<String> findMaximumRetailPriceTools();
	
	
	
	
	@Query("select concat(p.status, ':', count(p)) from Patronage p group by p.status")
	List<String> findNumberPatronages();
	
	@Query("select concat(p.status, ':',avg(p.budget.amount)) from Patronage p group by p.status")
	List<String> findAverageBudgetPatronage();
	
	@Query("select concat(p.status, ':',stddev(p.budget.amount)) from Patronage p group by p.status")
	List<String> findDeviationBudgetPatronage();
	
	@Query("select concat(p.status, ':',min(p.budget.amount)) from Patronage p group by p.status")
	List<String> findMinimumBudgetPatronage();
	
	@Query("select concat(p.status, ':',max(p.budget.amount)) from Patronage p group by p.status")
	List<String> findMaximumBudgetPatronage();
	
	
//	@Query("select count(c) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT")
//	Double findNumberComponents();
//	
//	@Query("select c.technology, c.retailPrice.currency, avg(c.retailPrice.amount) from Invention c where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, c.retailPrice.currency")
//	List<String> findAverageRetailPriceComponent();
//	
//	@Query("select c.technology, m.currency, stddev(m.amount) from Invention c join c.retailPrice m where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, m.currency")
//	List<String> findDeviationRetailPriceComponent();
//	
//	@Query("select c.technology, m.currency, min(m.amount) from Invention c join c.retailPrice m where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, m.currency")
//	List<String> findMinimumRetailPriceComponent();
//	
//	@Query("select c.technology, m.currency, max(m.amount) from Invention c join c.retailPrice m where c.inventionType=acme.entities.inventions.InventionType.COMPONENT group by c.technology, m.currency")
//	List<String> findMaximumRetailPriceComponent();
//	
//	
//	
//	
//	
//	@Query("select count(t) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL")
//	Double findNumberTools();
//
//	@Query("select t.retailPrice.currency, avg(t.retailPrice) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
//	List<String> findAverageRetailPriceTools();
//	
//	@Query("select t.retailPrice.currency, stddev(t.retailPrice) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
//	List<String> findDeviationRetailPriceTools();
//	
//	@Query("select t.retailPrice.currency, min(t.retailPrice) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
//	List<String> findMinimumRetailPriceTools();
//	
//	@Query("select t.retailPrice.currency, max(t.retailPrice) from Invention t where t.inventionType=acme.entities.inventions.InventionType.TOOL group by t.retailPrice.currency")
//	List<String> findMaximumRetailPriceTools();
//	
//	
//	
//	
//	@Query("select p.status,count(p) from Patronage p group by p.status")
//	List<String> findNumberPatronages();
//	
//	@Query("select p.status,avg(p.budget) from Patronage p group by p.status")
//	List<String> findAverageBudgetPatronage();
//	
//	@Query("select p.status,stddev(p.budget) from Patronage p group by p.status")
//	List<String> findDeviationBudgetPatronage();
//	
//	@Query("select p.status,min(p.budget) from Patronage p group by p.status")
//	List<String> findMinimumBudgetPatronage();
//	
//	@Query("select p.status,max(p.budget) from Patronage p group by p.status")
//	List<String> findMaximumBudgetPatronage();
	
}
