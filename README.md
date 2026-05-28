# SOOBWAY CAPSTONE

> ### About The Capstone
> Soobway is a java point-of-sale system for sandwich ordering inspired off of Subway. This projects featuring a JavaFX GUI, membership database, simulated checkout flow, and CLI.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-blue?style=flat-square)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Neon-green?style=flat-square&logo=postgresql)
![Maven](https://img.shields.io/badge/Build-Maven-red?style=flat-square&logo=apachemaven)

## Features

### Ordering

- Build-your-own sandwich with topping customization
- Preset signature sandwiches loaded from an enum configuration
- Drink and side selection screens
- Duplicate topping detection where extras are iterated and priced correctly.

### Membership & Discounts

- Email-based member lookup via a Neon PostgreSQL database
- Simple Regex email validation before database queries
- New user registration promotion on checkout for Discount.
- Membership tiers with discount.

|Tier   | Discount |
|-------|----------|
|Guest  | 0%       |
|BASIC  | 3%       |
|REWARDS| 15%      |

### GUI (JavaFX)

- A POS design inspired off of Toast, Inc. 
- Includes layout with a persistent order/checkout sidebar
- Content-swap navigation where the order sidebar state won't be lost
- A SCUFFED Animation? with a checkout simulation with a : spinner animation with checkmark on payment confirmation and x on payment failure.
- Audio feedback base on interactions taken in the GUI
- Receipt saves to file on order completion

-----

## Tech Stack Used

|Layer        | Technology                         |
|-------------|------------------------------------|
|Language     | Java 21                            |
|GUI Framework| JavaFX 21                          |
|UI Theme     | AtlantaFX — PrimerLight            |
|Database     | Neon PostgreSQL (https://neon.com) |
-----

## File Tree

```
src/
└── main/
    ├── java/
    │   └── com/pluralsight/soobwaycapstone/
    │       ├── Controllers/              # JavaFX screen controllers
    │       │   ├── HelloController.java
    │       │   ├── SignatureController.java
    │       │   ├── DrinksController.java
    │       │   └── CheckoutController.java
    │       ├── Database/
    │       │   └── Database.java         # Database Connection & Query
    │       ├── models/
    │       │   ├── enums/                
    │       │   ├── Item.java             
    │       │   ├── Sandwich.java
    │       │   ├── Drink.java
    │       │   ├── Side.java
    │       │   ├── Topping.java
    │       │   ├── Order.java
    │       │   ├── User.java
    │       │   └── Discount.java
    │       ├── ui/
    │       │   ├── IOrderUI.java         
    │       │   ├── ConsoleOrderUI.java
    │       │   └── Console.java
    │       ├── OrderManager.java         
    │       ├── OrderSession.java         
    │       ├── RecieptManager.java       
    │       └── HelloApplication.java     
    └── resources/
        └── com/pluralsight/soobwaycapstone/
            ├── asset/                   
            ├── hello-view.fxml
            ├── signatureitems-view.fxml
            ├── drinks-view.fxml
            ├── checkout-view.fxml
            └── style.css
```

-----

## Getting Started

### Prerequisites

- Java 21 or higher
- Environment variable: `DB_PW` with your own PostgreSQL credentials & Connection .

### How to Install

```
git clone https://github.com/yourusername/soobway-capstone.git
cd soobway-capstone
mvn clean install
```

### How to run

```
mvn javafx:run
```
You can also run `Main.java` directly from IntelliJ.

-----