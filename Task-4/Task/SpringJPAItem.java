package ir.freeland.springboot.Task;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ir.freeland.springboot.persistence.model.Students;
import jakarta.persistence.EntityManager;

public class SpringJPAItem {
	
	
	private EntityManager entityManager;

	public void itemRun() {
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.getTransaction();

		// save
		transaction.begin();
		Item item = new Item();
		item.setName("item1");
		item.setCategory("category1");
		item.setPrice(152.25);
		session.persist(item);
		transaction.commit();

		// save
		transaction.begin();
		Item item2 = new Item();
		item2.setName("item2");
		item2.setCategory("category1");
		item2.setPrice(28.325);
		session.persist(item2);
		transaction.commit();

		// Create
		transaction.begin();
		Item item3 = new Item();
		item3.setName("item2");
		item3.setCategory("category2");
		item3.setPrice(123.00);
		session.persist(item2);
		transaction.commit();

		// Read
		transaction.begin();
		List<Item> allItems = session.createQuery("from Items", Item.class).getResultList();
		allItems.stream().forEach(i -> System.out.println(i));
		transaction.commit();

		// Update
		transaction.begin();
		allItems.get(1).setName("NewItem");
		transaction.commit();

		// Delete
		transaction.begin();
		session.remove( allItems.get(0) );
		transaction.commit();

}
}
