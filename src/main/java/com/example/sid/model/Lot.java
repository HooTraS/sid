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

    @Column(nullable = false)
    private BigDecimal currentBid; // Текущая ставка

    public Lot() {
        this.lotNumber = generateLotNumber();
        this.lotCode = generateLotCode();
    }

    private int generateLotNumber() {
        return (int) (100000 + (id == null ? 0 : id));
    }

    private String generateLotCode() {
        Random random = new Random();
        return "" + (char) ('A' + random.nextInt(26)) +
                (char) ('A' + random.nextInt(26)) +
                (char) ('A' + random.nextInt(26)) +
                (char) ('A' + random.nextInt(26));
    }

}
