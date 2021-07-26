## Project Overview

An implementation of an online travel shopping application that allows Customers to book flights. 
The application would aggregate flights from numerous different airlines and display them to customers. Similar to 
SkyScanner, the business operates as a search engine and booking system for travel shopping.

> To simplify the application's implementation, you can pretend COVID-19 does not exist. You do not need to take into 
account travel caps, border closures, vaccination and quarantine requirements, etc. :wink:

## Application Domain

In this project, you and your team are tasked with implementing an online travel shopping application. Using the 
application, Customers can search for and book flights across Australia and globally.

There is only one Administrator of the application: the Administrator is not an Airline - instead they are a private 
company that aggregates flights.

The Administrator is responsible for managing the application and can view all users of the system. The Administrator is 
also responsible for creating airports in the system. Each airport should have a reference code - existing airport 
codes do not need to be followed but provides an illustration of what an airport code could be: [view](https://www.world-airport-codes.com/)

Airlines can then use the system to create flights between airports. A flight can contain none, one or many stopovers. 
A flight must be created with a flight code - existing airline codes do not need to be followed but provide an 
illustration of what an airline code could be: 
[view](https://www.iata.org/en/publications/directories/code-search/)

The application should allow Airlines to edit (e.g. time, date, etc.) and cancel flights. Airlines should be able to 
view all details for all Customers who have booked a seat on *one of their* flights.

Flights can only be created in the system by Airlines where an airport has been created in the system. For example, if 
the Administrator has not created Heathrow airport, an Airline cannot create a flight between Melbourne and Heathrow.

The application must provide Airlines the ability to select the type of the airplane that will be used for a flight. 
This will impact the number of tickets available, seat selection, etc.
As is standard in the airline industry, each flight should have seats reserved for first, business, and economy classes.
Prices may differ depending on ticket class, time of day, day of the year, etc.

Customers can use the application to book either one-way or return flights and should be able to support a booking for 
one or many tickets (for example, a family of 4 could book all 4 seats in one transaction).

When selecting a flight, the Customer has the ability to select an available seat they wish to occupy for the flight.

Customers can also use the application to view their prior or upcoming flight details.

> To simplify the application's implementation, you do not need to implement payment. A customer simply reserving a 
flight is sufficient.
