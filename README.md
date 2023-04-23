# Online_Shop


## Project description
This project is a backend application for an online store. The customer can see the products in this store, having at the same time the possibility to sort them by certain criteria. Also, the manufacturer has the possibility to manage the products on the site. It can set the number of products in stock, the date a certain order was shipped, etc.

## Business requirements

1. As a customer, I want to be able to have my own account
2. As a customer, I want to be able to view existing orders
3. As a customer, I want to be able to add an order
4. As a producer, I want to be able to search for categories by name
5. As a producer, I want to see information about the inventory of a product
6. As a producer, I want to be able to divide the products according to certain categories
7. As a producer, I want to delete the product that is no longer of interest
8. As a producer, I want to be able to see all the categories that exist in the store
9. As a producer, I would like to see a list of all existing clients
10. As a producer, I want to be able to edit the data about a certain product

## Endpoints:

1. **Category**: this class contain:
- The name of category
- A list of products
- ***Methods***:
   - *Add new category:* 
   - *Edit category*
   - *Delete Category*
   - *Get all Category*
   - *Get category by name*

2. Customer: this class contain:
- The first and last name
- The email
- The username and the password
- The address
- ***Methods***:
   - *Add new customer*
   - *Login user*
   - *Edit customer*
   - *Edit user pass*
   - *Delete customer*
   - *Get all orders*

3. Inventory: this class contain
- The quantity of product
- The sales of product
- ***Methods***:
   - *Edit inventory*
   - *Delete inventory*
   - *Get all inventory*
   - *Get all inventories*
   - *Get all inventory where sales is empty
   - *Get all inventory where quantity is empty
 
4. Order: this class contain
- The date
- The price, without tax
- The price of tax
- The voucecher number
- Te total price
- The customer
- A list of products
- ***Methods***:
   - *Add order*
   - *Edit order*
   - *Delete order*
   - *Get all orders*
   - *Edit voucher*
   - *List of products*

5. Recorder: this class contain
- The date of the product was recorded
- The date of the product was expected

- ***Methods***:
   - *Add recorder*
   - *Edit recorder*
   - *Delete recorder*
   - *Get all recorders*
   - *Edit data expected*

6. Product: this class contain
- The title of product
- The price of product
- The description of product
- The specific category
- The inventory
- The list of products
- ***Methods***:
   - *Add product*
   - *Edit product*
   - *Delete product*
   - *Get all products*
   - *Get all product with price bigger then a value*
   - *Edit current category*

Test the methods here: [Postman](https://app.getpostman.com/join-team?invite_code=416bb38e64ac1f75e2dabca79bf62901&target_code=22fa6d99e38c4108df5067f169d980b8)
