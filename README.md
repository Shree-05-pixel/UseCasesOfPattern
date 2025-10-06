# Educational Initiative Assignment

This repository demonstrates **a Console Application** and **6 core Java Design Patterns** with **real-time user input** examples x. Each pattern has a unique and relatable use case.

---
 ## EXERCISE 1 - JAVA Design Patterns with Usecases
# Design Patterns Classification

This document classifies common design patterns into their respective categories with a brief description.

## 1. Creational Patterns
- **Singleton Pattern**  
  Ensures that only one instance of a class is created and provides a global access point.

- **Factory Pattern**  
  Creates objects without specifying the exact class of object that will be created.

## 2. Structural Patterns
- **Adapter Pattern**  
  Converts the interface of a class into another interface that the client expects, allowing incompatible interfaces to work together.

- **Proxy Pattern**  
  Controls access to another object and can add additional behavior such as logging, caching, or access control.

## 3. Behavioral Patterns
- **Strategy Pattern**  
  Defines a family of algorithms, encapsulates each one, and makes them interchangeable.  
  (Can appear multiple times if demonstrating different use cases)

- **Observer Pattern**  
  Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.


## 1) Weather Update – Observer Pattern

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

---

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

---

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

---
---

 ## EXERCISE 2-Console Application
 

**Smart Home System**

**Overview**

This project simulates a Smart Home System that manages various smart devices such as lights, thermostats, and door locks. It allows users to add, remove, and control devices, set schedules, and add automation triggers. The system demonstrates the use of design patterns like Factory Method, Proxy, and Observer to achieve modularity and extensibility.

**Features**

- Add and Remove Devices: Easily manage devices in the system.

- Turn Devices On and Off: Control the state of devices manually.

- Set Schedules: Schedule actions for devices at specific times.

- Add Automation Triggers: Automate device actions based on conditions (e.g., temperature thresholds).

- Show Device Statuses: Display the current status of all devices.

- Show Schedules: View all scheduled actions.

- Authorized Users for Doors: Doors can only be unlocked for authorized users using the Proxy pattern.

**Design Patterns Used**

- Factory Method Pattern: Used to create different types of devices dynamically.

- Proxy Pattern: Provides security for sensitive devices like doors by allowing only authorized users to perform actions.

- Observer Pattern: Central hub notifies devices or observers whenever a state change occurs (e.g., automation triggers).

SmartHome/

│
├─ SmartHomeSystem.java       # Main program

├─ CentralHub.java            # Manages all devices and acts as Subject for Observer pattern

├─ Device.java                # Interface for all devices

├─ DeviceFactory.java         # Factory for creating devices

├─ DeviceProxy.java           # Proxy for secure access to devices like Door

├─ Door.java                  # Door device

├─ Light.java                 # Light device

├─ Thermostat.java            # Thermostat device

├─ Observer.java              # Observer interface

├─ Subject.java               # Subject interface

├─ Automation.java            # Manages automation triggers

├─ Trigger.java               # Represents a condition-action pair for automation

├─ Scheduler.java             # Manages scheduled actions

├─ Schedule.java              # Represents a schedule for a device


**Classes Overview**

*1)CentralHub:*
Manages all smart devices, schedules, and automation triggers. Implements the Subject interface for Observer pattern notifications.

*2)Device Interface:*
Defines common methods (turnOn, turnOff, getStatus, etc.) that all devices must implement.

*3)Light, Thermostat, Door:*
Concrete implementations of the Device interface. Thermostat supports temperature thresholds, and Door supports Proxy-based authorization.

*4)DeviceFactory:*
Factory class to create devices dynamically based on type.

*5)DeviceProxy:*
Proxy class that ensures only authorized users can control sensitive devices like doors.

*6)Automation & Trigger:*
Automation handles triggers (conditions + actions). Triggers specify conditions (like temperature thresholds) and actions (turning devices on/off).

*7)Scheduler & Schedule:*
Scheduler manages scheduled actions for devices. Schedule represents a device’s scheduled action at a specific time.

*8)Observer & Subject Interfaces:*
Implements Observer pattern to notify observers of state changes.
