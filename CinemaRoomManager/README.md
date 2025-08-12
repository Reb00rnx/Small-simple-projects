# 🎬 Cinema Booking System

A Java console application for managing seat reservations in a movie theater with dynamic pricing and statistics.

## ✨ Features
- **Interactive Seat Map**: Visual representation of available/taken seats
- **Dynamic Pricing**:
  - $10 for front rows
  - $8 for back rows (in theaters >60 seats)
  - $10 flat rate for small theaters
- **Comprehensive Statistics**:
  - Ticket sales count
  - Occupancy percentage
  - Current vs. potential income
- **Input Validation**: Handles edge cases for seat selection


## 🛠 Technical Implementation
```java
public class Cinema {
    private String[][] sitsTab;  // Seat matrix
    private int income;          // Total potential income
    private int inc;             // Current earnings
    
    // Core methods
    void buyTicket() { /* Dynamic pricing logic */ }
    void showTheSeats() { /* ASCII seat map */ }
    void statistics() { /* Sales analytics */ }
}
