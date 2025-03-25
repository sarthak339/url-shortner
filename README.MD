# URL SHORTENER USING SPRING BOOT
A URL shortener made using Spring Boot. This project provides REST APIs for a URL shortener tool that converts 
long URLs to tiny strings similar to tinylink or bit.ly but this project is a bit simpler.


`Make sure java version in your machine is 20 or above.`


## Technologies used
* Java 20
* Spring Boot 3.2.0
* H2 Database
* Hibernate
* Maven
* REST API
* Mockito
* JUnit5

## How to compile and run application
    git clone https://github.com/AbdulGaniShaikh/url-shortener-spring-boot.git
    mvn package 
    mvn spring-boot:run

## REST APIs

## generate a new tiny link

`POST /shorten?url={fullURL}`

### Params
| name | type   | nullable |
|------|--------|----------|
| url  | string | false    |

### Response
`status = 200 OK`

    {
        "shortenedURL": string,
        "fullURL": string,
        "date": date
    }

`note shortenedURL only contains the later part you need to add that is localhost:8080/`