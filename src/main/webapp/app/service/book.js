"use strict";

(function () {

    
    function BookService (bookDal) {

        this.getBooks = function()
        {
        	console.log("in book service get books");
        	return bookDal.getBooks();
        };
        this.deleteBook = function(bookToDelete)
        {
        	return bookDal.deleteBook(bookToDelete);
        };
        this.saveBook = function(bookToSave)
        {
        	return bookDal.saveBook(bookToSave);
        };
    }
    
    angular.module("bookApp").service("bookService", ['bookDal', BookService]);

}());