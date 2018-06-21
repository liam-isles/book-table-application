"use strict";

(function() {

    var BookController =  function(bookService, $log) {
        
    	var vm = this;
        
        vm.isHidden = false;
        
        vm.tempData = {'bookTitle' : '', 'genre' : '', 'yearPublished' : ''};

        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
        
        vm.deleteBook = function(bookToDelete)
        {
            bookService.deleteBook(bookToDelete);
             bookService.getBooks().then(function (results) {
                 vm.books = results;
             });
            
        };

        vm.saveBook = function(bookToAdd)
        {
            bookService.saveBook(vm.tempData);
            location.reload();

             }

        function init() {
        	bookService.getBooks().then(function (results) {
           	vm.books = results;
           	$log.log("In the book controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.books));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }
       
       init();
            
    };

    angular.module('bookApp').controller('bookController', ['bookService','$log', BookController]);
}());