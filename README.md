# Online_Shop


## Project description
This project is a backend application for an online store. The customer can see the products in this store, having at the same time the possibility to sort them by certain criteria. Also, the manufacturer has the possibility to manage the products on the site. It can set the number of products in stock, the date a certain order was shipped, etc.

## Endpoints:

1. **Category**: this class contain:
- The name of category
- A list of products
- ***Methods***:
   - *Add new category:* 
   - *Edit category*
   - *Delete Category*
   - *Get all Category*

2. User: this class contain:
- The first and last name
- The email
- The username and the password
- The address
- The role
- ***Methods***:
   - *Register user*
   - *Login user*
   - *Edit user*
   - *Edit user pass*
   - *Delete user*
   - *Get all orders*

3. Inventory: this class contain
- The quantity of product
- The sales of product
- ***Methods***:
   - *Edit inventory*
   - *Delete inventory*
   - *Add inventory*
   - *Get all inventory*
 
 
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
 

5. Recorder: this class contain
- The date of the product was recorded
- The date of the product was expected

- ***Methods***:
   - *Add recorder*
   - *Edit recorder*
   - *Delete recorder*
   - *Get all recorders*

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
 
