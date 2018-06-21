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
    }
    
    angular.module("bookApp").service("bookService", ['bookDal', BookService]);

}());