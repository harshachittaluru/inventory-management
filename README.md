# Inventory Management

## Project Description

<p style='text-align: justify;'>This application is used for managing the inventory. In this project, inventory refers to items in the store/market. This application is used to add new items to the inventory, update the details of the item, get the details of the item and if needed, deleting the item from the database. </p>

## Technologies Used

| Category             | Name of the Technology |
| :------------------- | :--------------------- |
| Programming Language | Java(Version 21)       |
| Database             | MySQL                  |
| Backend Framework    | Spring Boot            |

## Setup the Project

- Open the [Spring Initialzer](https://start.spring.io/) -
  - Give the details of the project like name of the project
  - Package name, Java Version, Select Maven
  - Select dependencies - Spring Web, Spring Data JPA, Lombok, MySQL Connector
- Download and extract the project and import the project into IDEs like Eclipse or IntelliJ.
- To use this project in your local:
  - Clone this project in your local using `git clone git@github.com:harshachittaluru/inventory-management.git`
  - Run the server and make sure everything is setup correctly.

## List of all endpoints

### 1. Add Item to the Inventory

This endpoint is used to **add a new item** to the inventory.

### Request

- **Method**: `POST`
- **URL**: `/items/addItem`

### Request Body

```json
{
  "itemName": "Chocolates",
  "itemCategory": "Groceries",
  "itemPrice": 20
}
```

### Response Body

```json
{
  "success": true,
  "message": "Item added successfully!",
  "result": {
    "id": 7,
    "itemName": "Chocolates",
    "itemCategory": "Groceries",
    "itemPrice": 20.0
  }
}
```

### 2. Get All Items from the Inventory

This endpoint is used to **get all items** from the inventory.

### Request

- **Method**: `GET`
- **URL**: `/items/getAll`

### Response Body

```json
{
  "success": true,
  "message": "Items Fetched Successfully!",
  "result": [
    {
      "itemName": "Tomatoes",
      "itemCategory": "Vegetables",
      "itemPrice": 30.0
    },
    {
      "itemName": "Spinach",
      "itemCategory": "Vegetables",
      "itemPrice": 10.0
    },
    {
      "itemName": "Water Bottles",
      "itemCategory": "Groceries",
      "itemPrice": 17.29
    },
    {
      "itemName": "Chocolates",
      "itemCategory": "Groceries",
      "itemPrice": 20.0
    }
  ]
}
```

### 3. Get the Item details from the inventory using ID

This endpoint is used to **get an item details using ID** from the inventory.

### Request

- **Method**: `GET`
- **URL**: `/items/getItem/{id}`

### Path Variable

`id`

### Response Body

```json
{
  "success": true,
  "message": "Items Fetched Successfully!",
  "result": {
    "itemName": "Water Bottles",
    "itemCategory": "Groceries",
    "itemPrice": 17.29
  }
}
```

### 4. Update the Item details in the Inventory

This endpoint is used to **update the details of an item using ID** in the inventory.

### Request

- **Method**: `PUT`
- **URL**: `/items/updateItem/{id}?itemName={name}&itemCategory={category}&itemPrice={price}`

### Path Variable

`id`

### Request Parameters

```
# All are not mandatory, You can give values to all fields or any field.

itemName
itemCategory
itemPrice
```

### Response Body

```json
{
  "success": true,
  "message": "Item updated successfully!",
  "result": {
    "id": 5,
    "itemName": "Spinach",
    "itemCategory": "Vegetables",
    "itemPrice": 21.5
  }
}
```

### 5. Delete an Item from the Inventory

This endpoint is used to **delete an item using ID** from the inventory.

### Request

- **Method**: `DELETE`
- **URL**: `/items/deleteItem/{id}`

### Path Variable

`id`

### Response Body

```json
{
  "success": true,
  "message": "Items Deleted Successfully!",
  "result": 4
}
```
