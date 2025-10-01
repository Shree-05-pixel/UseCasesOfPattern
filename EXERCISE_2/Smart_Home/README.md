Smart Home System
Overview

This project simulates a Smart Home System that manages various smart devices such as lights, thermostats, and door locks. It allows users to add, remove, and control devices, set schedules, and add automation triggers. The system demonstrates the use of design patterns like Factory Method, Proxy, and Observer to achieve modularity and extensibility.

Features

Add and Remove Devices: Easily manage devices in the system.

Turn Devices On and Off: Control the state of devices manually.

Set Schedules: Schedule actions for devices at specific times.

Add Automation Triggers: Automate device actions based on conditions (e.g., temperature thresholds).

Show Device Statuses: Display the current status of all devices.

Show Schedules: View all scheduled actions.

Authorized Users for Doors: Doors can only be unlocked for authorized users using the Proxy pattern.

Design Patterns Used

Factory Method Pattern: Used to create different types of devices dynamically.

Proxy Pattern: Provides security for sensitive devices like doors by allowing only authorized users to perform actions.

Observer Pattern: Central hub notifies devices or observers whenever a state change occurs (e.g., automation triggers).