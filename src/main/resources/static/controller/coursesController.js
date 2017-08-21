(function() {

    courses.controller('coursesController',coursesController);

    function coursesController($scope, $timeout) {
        
        $scope.initCourses = init;
        
        
        
        function init(){
            console.log("courses initializatiated");
        }
        
    }
})();