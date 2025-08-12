# 🎲 Dice Roller

A simple Java console application that simulates rolling a standard six-sided die.

## ✨ Features
- **Random Number Generation**: Produces a value between 1 and 6
- **Reusable Logic**: Encapsulated in a `roll()` method for repeated use
- **Object-Oriented Design**: Uses a `Random` object initialized in the constructor

## 🛠 Technical Implementation
```java
public class DiceRoller {
    Random random; // Random number generator
    int number;    // Last rolled number

    DiceRoller() {
        random = new Random();
    }

    void roll() {
        number = random.nextInt(6) + 1;
        System.out.println(number);
    }
}
