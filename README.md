# springboot-i18n-database


Stackoverflow Question : [How to localize individual values of domain objects in a REST API build with Spring Boot?](https://stackoverflow.com/questions/60189856/how-to-localize-individual-values-of-domain-objects-in-a-rest-api-build-with-spr)

This is an example of internationalized data using database.

Clone repository

```
git clone https://github.com/jestevez/springboot-i18n-database.git
```

Build

```
cd springboot-i18n-database
./mvnw clean install
```

Run

```
java -jar target/springboot-i18n-database-0.0.1-SNAPSHOT.jar
```

# API Endpoints

**/products/i18n/{id}**
 
View i18n product

Example in cURL with Accept-Language: en

```
curl --location --request GET 'http://localhost:2001/products/i18n/1'  --header 'Accept-Language: en'
```

Response (en)

```json
{
	"id": 1,
	"name": "printer paper",
	"price": 800.0,
	"createAt": "2020-02-14T12:07:04.803+0000"
}
```

Example in cURL with Accept-Language: es

```
curl --location --request GET 'http://localhost:2001/products/i18n/1'  --header 'Accept-Language: es'
```

Response (es)

```json
{
	"id": 1,
	"name": "papel de impresora",
	"price": 800.0,
	"createAt": "2020-02-14T12:07:04.803+0000"
}
```

**/products/{id}**

View product with all languages

```
curl --location --request GET 'http://localhost:2001/products/1'
```

Response

```json
{
	"id": 1,
	"name": "i18n.products.name.printer-paper",
	"price": 800.0,
	"createAt": "2020-02-14T12:07:04.803+0000",
	"resources": [{
		"language": "es",
		"reference": "i18n.products.name.printer-paper",
		"value": "papel de impresora"
	}, {
		"language": "en",
		"reference": "i18n.products.name.printer-paper",
		"value": "printer paper"
	}]
}
```
