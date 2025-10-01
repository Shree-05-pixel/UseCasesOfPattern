# UseCasesOfPattern
# Java Design Patterns Examples – User Input Based

This repository demonstrates **6 core Java Design Patterns** with **real-time user input** examples. Each pattern has a unique and relatable use case.

---

##1) Weather Update – Observer Pattern

### Overview
Simulates a **Weather Station** where multiple display devices (Phone, Tablet, Laptop) automatically receive updates when the temperature changes. Demonstrates the **Observer pattern** for decoupled communication between the weather data and display devices.

### Features
- Enter new temperatures dynamically.
- Add or remove display devices at runtime.
- Automatic updates to all registered devices.

### Design Patterns Used
- **Observer Pattern:** Central hub (ConcreteWeatherData) notifies display devices (Observers) whenever temperature changes.

### Project Structure
WeatherObserverPattern/
├── WeatherData.java # Subject interface
├── ConcreteWeatherData.java # Concrete Subject
├── DisplayDevice.java # Observer interface
├── ConcreteDisplayDevice.java # Concrete Observer
├── Main.java # User input and observer registration


---

## 2️)Payment Selection – Strategy Pattern

### Overview
E-commerce payment system where the user can select **Credit Card, UPI, or Cash on Delivery** at runtime. Demonstrates **Strategy pattern** for dynamic algorithm selection.

### Features
- Supports multiple payment methods.
- User selects payment strategy at runtime.
- Extensible to add more payment methods.

### Design Patterns Used
- **Strategy Pattern:** Payment algorithms are encapsulated and interchangeable at runtime.

### Project Structure
StrategyPatternPayment/
├── PaymentStrategy.java # Strategy interface
├── CreditCardPayment.java # Concrete Strategy
├── UPIPayment.java # Concrete Strategy
├── CashOnDeliveryPayment.java# Concrete Strategy
├── PaymentContext.java # Context class
├── Main.java # User input and strategy selection



## 3️)Universal Mobile Charger – Adapter Pattern

### Overview
Simulates a **Universal Charger** that adapts to different phone brands (Samsung, iPhone, OnePlus). Demonstrates **Adapter pattern** for compatibility between incompatible interfaces.

### Features
- Supports multiple phone brands.
- Converts universal charger output to brand-specific charging.
- User input selects the phone brand dynamically.

### Design Patterns Used
- **Adapter Pattern:** Converts universal charger interface to phone-specific charging methods.

### Project Structure
AdapterPatternCharger/
├── MobileCharger.java # Target interface
├── SamsungCharger.java # Adaptee
├── IphoneCharger.java # Adaptee
├── OnePlusCharger.java # Adaptee
├── UniversalChargerAdapter.java # Adapter class
├── Main.java # User input


---

## 4️) Food Delivery App – Factory Pattern

### Overview
Food Delivery App where the user selects **cuisine type** (Indian, Chinese, Italian). Demonstrates **Factory pattern** for dynamic object creation.

### Features
- User selects cuisine at runtime.
- Factory creates appropriate food object.
- Easily extendable for new cuisines.

### Design Patterns Used
- **Factory Pattern:** Encapsulates object creation based on user input.

### Project Structure

FactoryPatternFood/
├── Food.java # Product interface
├── IndianFood.java # Concrete Product
├── ChineseFood.java # Concrete Product
├── ItalianFood.java # Concrete Product
├── FoodFactory.java # Factory class
├── Main.java # User input and object creation

## 5️) Logger System – Singleton Pattern

### Overview
A logging system where **only one instance of Logger exists**. Demonstrates **Singleton pattern** for global access and consistent logging.

### Features
- Single global instance of Logger.
- Record multiple log messages.
- Ensures consistency across application.

### Design Patterns Used
- **Singleton Pattern:** Ensures only one instance of Logger is created.

### Project Structure
SingletonPatternLogger/
├── Logger.java # Singleton Logger class
├── Main.java # User input and logging demonstration


---

## 6️) Smart Door Access – Proxy Pattern

### Overview
Smart Home Door access controlled via **PIN authentication**. Demonstrates **Proxy pattern** for access control and security.

### Features
- PIN-based access for authorized users.
- Proxy ensures RealSmartDoor is not accessed directly.
- Easily extendable for advanced authentication (fingerprint, face recognition).

### Design Patterns Used
- **Proxy Pattern:** Provides security and controlled access to sensitive devices.

### Project Structure

ProxyPatternSmartDoor/
├── SmartDoor.java # Subject interface
├── RealSmartDoor.java # Real Subject
├── SmartDoorProxy.java # Proxy class
├── Main.java # User input and door access
