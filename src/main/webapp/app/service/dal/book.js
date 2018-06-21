"use strict";

(function () {

    function BookDal (dal) {

        this.getBooks = function () {
            return dal.http.GET("rest/book/repos");
        };

        this.saveBook = function (bookToSave) {
            return dal.http.POST("rest/book/repos", bookToSave);
        };

        this.updateBook = function (bookToUpdate) {
            return dal.http.PUT("rest/book/repos/", bookToUpdate);
        };

        this.deleteBook = function (bookToDelete) {
            return dal.http.DELETE("rest/book/repos/", bookToDelete);
        };
    }
    
    angular.module("bookApp").service("bookDal", ["dal", BookDal]);
}());