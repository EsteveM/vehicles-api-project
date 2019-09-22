# Vehicles API Project

This project is intended to build a Vehicles REST API to maintain vehicle data and to provide a complete view of vehicle details including price and address. The API is built using Java, Spring Boot and Maven, and can communicate with separate location and pricing services. The API is also documented and tested.

## Table of Contents

* [Description of the Project](#description-of-the-project)
* [Testing coverage](#testing-coverage)
* [Getting Started](#getting-started)
* [Contributing](#contributing)

## Description of the Project

As has already been mentioned, this project develops a Vehicles REST API that can communicate with separate location and pricing services. The last one is converted into a microservice. The API is tested using MockMvc, and documented using Swagger. The work that has been done is best described by explaining its main steps:


* Location Service (Boogle Maps): this is a pre-existent location service which simulates a maps WebService.
* Pricing Service: this REST WebService stores the price of a given vehicle. As part of this project, it has been converted into a microservice.
	* PricingController: this is the REST controller, which will not be needed once the Pricing Service is converted into a microservice.
	* PricingService: this is the REST service, which will not be needed either once the Princing Service is converted into a microservice.
	* Eureka server: it is created as part of the process of converting the REST API into a microservice. The microservice registers on it.
	* PriceMicroserviceApplicationTests: two additional tests have been added for the microservice.
* Vehicles API:
    * CarController: a number of methods have been implemented to process GET, POST, PUT and DELETE requests.
    * PriceClient: the format of a GET request to the pricing-service has been adapted because it has been converted into a microservice.
    * CarService: a number of tasks have been performed here:
    	* Maps and Pricing Web Clients created in VehiclesApiApplication are added as arguments and set.
    	* The method that gathers a list of all vehicles has been improved to include location anf price information.
    	* A method to find a car by ID from the repository if it exists has been implemented. The Pricing Web client is used to get the price. The Maps Web client is used to get the address for the vehicle.
    	* A method to delete a vehicle by id from the repository is implemented, if it exists.
    * CarControllerTest: a number of tests have been added, covering create car, list cars, find car, and delete car.
    * SwaggerConfig: Swagger is used to implement API documentation for the Vehicles API.

## Testing coverage

In this section, the eight tests covered are listed:

* CarControllerTest:
	* findCar: tests the read operation for a single car by ID.
	* deleteCar: tests the deletion of a single car by ID.
	* createCar: tests for successful creation of new car in the system.
	* listCars: tests if the read operation appropriately returns a list of vehicles.
	* contextLoads: tests context loading.
* PriceMicroserviceApplicationTests:
	* createPrice: tests for successful creation of new price in the system.
	* findPrice: tests the read operation for a single price by ID.
	* contextLoads: tests context loading.

## Getting Started

The procedure to obtain a functional a copy of the project on your local machine so that you can further develop and/or test it is explained in this section. These are the steps to be followed:

* Firstly, you have to download/clone the project files from this repository onto your local machine. Then, cd into the root folder where the project files are located.
* For your information, this is the result of the execution of the packaging step for the eureka, boogle-maps, PriceMicroservice, and vehicles-apli applications:
![eurekapackage](/ScreenShots/eurekapackage.png)
![booglemapspackage](/ScreenShots/booglemapspackage.png)
![PriceMicroServicepackage](/ScreenShots/PriceMicroServicepackage.png)
![VehiclesAPIpackage](/ScreenShots/VehiclesAPIpackage.png)
* This step creates these *jar* files: *eureka-0.0.1-SNAPSHOT.jar*, *boogle-maps-0.0.1-SNAPSHOT.jar*, *PriceMicroservice-0.0.1-SNAPSHOT.jar*, and *vehicles-api-0.0.1-SNAPSHOT.jar*, respectively.
* Now, secondly, you can execute the packaged applications. Note that all four applications must be running for all operations to perform correctly, although they are able to be launched on their own. Just run the *jar* files on four different terminal shell windows by typing:
	* `java -jar eureka/target/eureka-0.0.1-SNAPSHOT.jar`. This starts the Eureka server:
	![eurekarun](/ScreenShots/eurekarun.png)
	* Its console can be accessed at *http://localhost:8761/*. As you can see, no instances have been registered on the Eureka server yet:
	![eurekaconsole](/ScreenShots/eurekaconsole.png)
	* `java -jar boogle-maps/target/boogle-maps-0.0.1-SNAPSHOT.jar`. This starts the boogle-maps Webserver on port 9191:
	![booglemapsrun](/ScreenShots/booglemapsrun.png)
	* It is possible to check the boogle-maps Webserver on the command line by typing `curl http://localhost:9191/maps\?lat\=20.0\&lon\=30.0`:
	![booglemapscheck](/ScreenShots/booglemapscheck.png)
	* `java -jar PriceMicroservice/target/PriceMicroservice-0.0.1-SNAPSHOT.jar`. This starts the PRINCING-SERVICE microservice on port 8762:
	![PriceMicroServicerun](/ScreenShots/PriceMicroServicerun.png)
	* It is possible to check the PRICING-SERVICE microservice executing a POSTMAN request:
	![PriceMicroServicecheck](/ScreenShots/PriceMicroservicecheck.png)
	* For your information, the PRICING-SERVICE microservice is also registered with Eureka, as you can see in the Eureka console:
	![eurekaconsole2](/ScreenShots/eurekaconsole2.png)
	* `java -jar vehicles-api/target/vehicles-api-0.0.1-SNAPSHOT.jar`. This starts the vehicles API on port 8080:
	![vehiclesapirun](/ScreenShots/vehiclesapirun.png)
* Thirdly, the Vehicles API can be manually tested executing a number of POSTMAN requests:
	* The Vehicles API is able to create a new vehicle based on input from the user with a POST request:
	![vehiclesapi1](/ScreenShots/vehiclesapi1.png)
	* The Vehicles API can receive GET requests from a user, and read back either a list of all existing vehicles, or the data for a single vehicle. Please, note that the location and the pricing information is included. Note also that the first request shows a vehicle, and the second one a list of vehicles:
	![vehiclesapi2](/ScreenShots/vehiclesapi2.png)
	![vehiclesapi3](/ScreenShots/vehiclesapi3.png)
	* The Vehicles API can update an existing vehicle through input from the user. Please, note that the second car has four doors (first image), and then it is modified so that it has 6 doors:
	![vehiclesapi4](/ScreenShots/vehiclesapi4.png)
	![vehiclesapi5](/ScreenShots/vehiclesapi5.png)
	* The Vehicles API can delete an existing vehicle when requested by the user. Please, note how car 2 is deleted below:
	![vehiclesapi6](/ScreenShots/vehiclesapi6.png)
	![vehiclesapi7](/ScreenShots/vehiclesapi7.png)
* In the fourth place, if you want to run the supporting tests yourself, you have to:
	* Make sure the application is running. If you have followed along, this should be the case now.
	* Open a new terminal shell window, cd to the PriceMicroservice folder, and type, for instance, `mvn test`. Please, note how all tests pass:
	![vehiclestest1](/ScreenShots/vehiclestest1.png)
	![vehiclestest2](/ScreenShots/vehiclestest2.png)
	* Cd to the vehicles-api folder, and type, for instance, `mvn test`. Please, note how all tests pass:
	![vehiclestest3](/ScreenShots/vehiclestest3.png)
	![vehiclestest4](/ScreenShots/vehiclestest4.png)
* Finally, API documentation for the Vehicles API has been implemented using Swagger. All related API queries can be run from there. The documentation is available at *http://localhost:8080/swagger-ui.html* when the application is running. Below, you can see the Swagger-UI main page, and an example of an API query execution:
![swagger1](/ScreenShots/swagger1.png)
![swagger2](/ScreenShots/swagger2.png)

## Contributing

This repository contains all the work that makes up the project. Individuals and I myself are encouraged to further improve this project. As a result, I will be more than happy to consider any pull requests.