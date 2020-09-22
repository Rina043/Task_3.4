package ru.netology.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PurchaseItem {
    private int id;
    private int movieId;
    private String imageUrl;
    private String name;
    private String genre;
    private int ageLimit;

    public PurchaseItem(int i, int i1, String url3, String name3, String genre3, int i2) {
    }
}
