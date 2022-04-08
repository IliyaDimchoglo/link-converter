#Link Converter 
## Getting Started 

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-webservices)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Run application 
* docker compose up --build
* mvn clean install -DskipTests
* mvn spring-boot:run
* application will start at port 8080

### Usage

To convert a WebURL to Deep Link, you need to send a POST request to the following URL - http://localhost:8080/api/convert_to_deep.

To convert a Deep Link to Web URL, you need to send a POST request to the following URL - http://localhost:8080/api/convert_to_web.

##Example:
###To convert a deep link to web:

    curl --location --request POST 'http://localhost:8080/api/convert_to_web' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "link": "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064"
    }'

###To convert a web url to deep link:

    curl --location --request POST 'http://localhost:8080/api/convert_to_deep' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "link": "https://www.trendyol.com/sr?q=elbise"
    }'
