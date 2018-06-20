package com.santander.integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.santander.service.repository.BookDBRepository;

@Path("/book")
public class BookEndpoint {

	private static final Logger LOGGER = Logger.getLogger(BookEndpoint.class);

	@Inject
	private BookDBRepository repos;

	@Path("/repos")
	@GET
	@Produces({ "application/json" })
	public String getAllBooks() {
		LOGGER.info("BookEndpoint + getAllBooks");
		return repos.getAllBooks();
	}

	@Path("/repos")
	@POST
	@Produces({ "application/json" })
	public String createBook(String book) {
		LOGGER.info("BookEndpoint + addBook");
		return repos.createBook(book);
	}

	@Path("/repos/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBook(@PathParam("id") Long id) {
		LOGGER.info("AccountEndpoint + deleteBook");
		return repos.deleteBook(id);

	}

	public void setService(BookDBRepository repos) {
		LOGGER.info("BookEndpoint + setRepos");
		this.repos = repos;
	}

}