package com.example.sid.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@Entity
@Getter
@Setter
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Внутренний ID

    @Column(unique = true, nullable = false)
    private int lotNumber; // Шестизначный номер лота

    @Column(unique = true, nullable = false)
    private String lotCode; // 4-значный код

    @Column(nullable = false)
    private String participantCode; // Код участника (3 буквы + 3 цифры)

    @Column
    private BigDecimal currentBid; // Текущая ставка, может быть null

    // Генерация номера и кода перед сохранением в БД
    @PrePersist
    public void prePersist() {
        if (lotNumber == 0) {
            this.lotNumber = generateLotNumber();
        }
        if (lotCode == null || lotCode.isEmpty()) {
            this.lotCode = generateLotCode();
        }
    }

    private int generateLotNumber() {
        // Для простоты можно просто сгенерировать случайный 6-значный номер
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    private String generateLotCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            code.append((char) ('A' + random.nextInt(26)));
        }
        return code.toString();
    }
}
