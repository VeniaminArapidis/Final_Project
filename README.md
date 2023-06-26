# Final_Project
Final Project developed for TechPro Academy.


Simple CRM project.

Purpose of the project: Final assessment for the "TechPro Academy".

![Final_Project](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/03ac77c1-b4e5-4e25-8956-7493cb4768f1)



Full stack application that contains:

-Relational DataBase in MySQL.

![dataBase uml diagram](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/359603a8-b594-4939-bcc1-e96e861f1ac4)

-BackEnd generated with SpringBoot framework in JAVA.

-FrontEnd built with React js:

HomePage:

![HomePage](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/543d5292-3ba9-4e6a-9381-fc767e158321)

MakeAnOrder form:

![makeAnOrder](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/04d3b5b5-ea27-42d9-97b7-36be0f2dca87)

AddCustomer form: 

![AddCustomer](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/f8a7ebd2-167d-4920-8ed1-22d86c58a7d0)

Additem form:

![AddItem](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/c91c5452-91e4-426f-951a-63417cf5fda4)

Orders page:

![Orders Page](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/ebe6b411-8754-4e04-a207-31ebf96bad85)







After you clone the project, you must run it in a docker environment.
Each part of the project is designed to run in a single container.
Firstly you have to add IP at MYSQL_HOST variable(backend -> src -> main -> java -> com -> techpro -> project -> configuration -> "DockerSecrettsProcessor.java").
Check if the necessary ports are forwarded.  
Then run the script commandScript.sh with the command "./commandScript.sh". 
In case you want to stop the project containers you type the command "docker compose stop"
Be careful don't type the command "docker compose down" except if you want to recreate the containers.
To start them again you should type "docker compose start".
Sensitive info: In case the backend fails to connect to the db in your first installation. Try to run again the script.

To visit the UI you need to type the endpoint: localhost/3000.

Model:
Entity: People.
Entity: Items.
Entity: Orders.
Entity: OrderDetails.

Each of the above entities has a controller class.
The controller of the People entity has 5 methods.
-newPerson() -> Requires as params HashMap <String, String>, creates customer record. 
-updatePeople() -> Requires as params People newPeople and Integer PersonID, update the customer with the specified ID.
-findAllPeople() -> No params, returns all the customer records.
-getPeopleById() -> Requires as params Integer personID, returns the customer with the specified personID.
-deletePeople() -> Requires as params Integer personID, deletes the customer with the specified ID.
The controller of the Items entity has 5 methods.
-newItem() -> Requires as params HashMap <String, String>, creates item record.
-updateItems() -> Requires as params Items newItem and Integer itemId, update the item with the specified ID.
-findAllItems() -> No params, returns all item records.
-getItemById() -> Requires as params Integer itemId, returns the item with the specified ID.
-deleteItem() -> Requires as params Integer itemId, delete the item with the specified ID.
The controller of the Orders entity has 3 methods.
-findAllOrders() -> No params, returns all the order records.
-order() -> Requires as params HashMap <String, String>, creates order record. 
-deleteOrder() -> Requires as params Integer orderId, deletes order record and details record for the order.
The controller of the OrderDetails entity has a single method.
-findAllOrderDetails() -> No params, returns all the order details records.


-API DOCUMENTATION Link: 

http://localhost:8080/Techpro.html

![Response Time](https://github.com/VeniaminArapidis/Final_Project/assets/128240345/cdc33533-e9de-4319-8de3-1bd879744c4c)



