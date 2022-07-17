<div id="top"></div>

<!-- ABOUT THE PROJECT -->
## FreezerAPI

A simple API with the following functionality: 
- Add "food" to a freezer given a name, type and quantity. The foods are stored on a H2 database in memory. 
- Retrieve stored food using its ID or name
- Update foods in the database

The following endpoints are available:
- `/food` handles `GET`, `PUT` and `POST` requests to retrieve foods by ID, add a food into the database or update existing entries.
- `/food/search` handles `GET` requests and retrieves foods by name
- `/all` handles `GET` and returns all foods stored in the DB

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [![Spring][Spring.io]][Spring-url]

<p align="right">(<a href="#top">back to top</a>)</p>



## Implementation & Improvements

The API is split in three layers: the API, Service, and Data Access layers. A memory-based H2 databse is implemented, of which the dashboard can be 
accessed via localhost:8080/h2 by default. Spring JPA is used to link the database to the API, allowing for the seamless conversion of JSON to object
(in this case the "Food" object), object to JSON, and database transactions. 

Key improvements may come in the form of further error handling, making sure requests are valid and throwing more appropriate/varied error messages.
Unit test could also be added.


### Stack

For the best experience, please use the following:
* Java 17 or later
* Spring 2.7.1 or later
* Gradle 7.4.1 or later

### Test Cases

You may find a collection of sample requests for Postman in the `RequestsCollection.postman_collection.json` file.
Alternatively, the cURL requests are available in the `curl requests.txt` file. 

By default, these requests target port 8080.



<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[Spring.io]: https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg
[Spring-url]: https://spring.io/
