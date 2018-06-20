package com.santander.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.santander.domain.Book;
import com.santander.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class BookDBRepository implements BookRepository {

	private static final Logger LOGGER = Logger.getLogger(BookDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	
	public String getAllBooks() {
		LOGGER.info("BookDBRepository getAllBooks");
		Query query = manager.createQuery("Select a FROM Book a");
		return util.getJSONForObject(query.getResultList());
	}

	
	@Transactional(REQUIRED)
	public String createBook(String book) {
		LOGGER.info("BookDBRepository createBook");
		Book aBook = util.getObjectForJSON(book, Book.class);
		manager.persist(aBook);
		return "{\"message\": \"book has been sucessfully added\"}";
	}

	
	@Transactional(REQUIRED)
	public String deleteBook(Long id) {
		LOGGER.info("BookDBRepository deleteBook");
		Book bookInDB = findBook(id);
		if (bookInDB != null) {
			manager.remove(bookInDB);
			return "{\"message\": \"book sucessfully deleted\"}";
		}
		return "{\"message\": \"book not found\"}";

	}

	private Book findBook(Long id) {
		LOGGER.info("BookDBRepository findBook");
		return manager.find(Book.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
