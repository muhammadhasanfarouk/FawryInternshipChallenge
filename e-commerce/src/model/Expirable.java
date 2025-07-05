package model;

import java.time.LocalDate;

public interface Expirable extends Product {
    LocalDate getExpiryDate();
}
