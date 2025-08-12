# 🔐 Encrypt / Decrypt CLI

A Java console application for encrypting and decrypting text using:
- **Shift** (Caesar cipher for A–Z, a–z)
- **Unicode** (shifts all characters in ASCII/Unicode range)

## ✨ Features
- **Modes**: `enc` (encrypt) or `dec` (decrypt)
- **Algorithms**: `shift` or `unicode`
- **Input options**: direct text (`-data`) or file (`-in`)
- **Output**: print to console or save to file (`-out`)
- **Custom key**: set shift amount with `-key`

## 🛠 Technical Implementation
```java
String result = mode.equals("enc")
    ? enc(text, key, alg)
    : dec(text, key, alg);
