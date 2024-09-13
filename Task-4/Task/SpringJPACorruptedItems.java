package ir.freeland.springboot.Task;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.EntityManager;

public class SpringJPACorruptedItems {
	
	
	private EntityManager entityManager;

	public void CorruptedItemRun() {
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.getTransaction();
		
		//find corrupted item from items
		transaction.begin();
		List<Item> allItems = session.createQuery("from Item i where i.category like '%category2%'", Item.class).getResultList();
		allItems.stream().forEach(i -> System.out.println(i));
		transaction.commit();
				
		// create
		transaction.begin();
		corruptedItems Citem = new corruptedItems();
		Citem.setId(10);
		Citem.setItem(allItems.get(0));
		Citem.setReason("Expired");
		session.persist(Citem);
		transaction.commit();

		// read
		transaction.begin();
		List<corruptedItems> allCItems = session.createQuery("from Item", corruptedItems.class).getResultList();
		allCItems.stream().forEach(c -> System.out.println(c));
		transaction.commit();

		// Update
		transaction.begin();
		allCItems.get(0).setReason("testUpdate");
		transaction.commit();

		// Delete
		transaction.begin();
		allItems.remove( allItems.get(0) );
		transaction.commit();

}
}
