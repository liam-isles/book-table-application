(function() {

    var DashboardController =  function() {
        
    	var vm = this;
    	
    	vm.angular = "Big Books";
    	
    	vm.bootstrap = "Small Books";
    	
    	vm.html = "Round Books";
    	
    	vm.javaEE = "Scratch and Sniff";
            
    };

    angular.module('bookApp').controller('dashboardController', [DashboardController]);
}());