# Taco-Adder!

## What it does 
  - Returns the price of an order of tacos  with a bulk discount if applicable.

## Run Server
  - ```./mvnw spring-boot:run```

## Tests
  - `mvn clean test`
  
## Request Format
```
POST /orders/total 
Content-type: application/json
{
  "veg": 1, 
  "chicken": 2,
  "beef": 3
  "chorizo": 4 //number of tacos
}
```   

## Usage
   `curl 'http://localhost:8080/orders/total'  -H 'Content-Type: application/json'  --data '{"veg":4,"chicken":3,"beef":2,"chorizo":1}' `<br>


## Notes
- Prices and bulk discounts can be set as application properties, configurable during deployment.

[<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/001_Tacos_de_carnitas%2C_carne_asada_y_al_pastor.jpg/2560px-001_Tacos_de_carnitas%2C_carne_asada_y_al_pastor.jpg" width=400 alt="tacos" style="margin-top:20px;">]

