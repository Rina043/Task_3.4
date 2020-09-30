package ru.netology.manager;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;
    private int defaultafishalength = 10;
    private int afishaLength;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieManager(MovieRepository repository, int afishaLength) {
        this.repository = repository;
        this.afishaLength = afishaLength;
    }

    public MovieManager() {

    }

    public void filmAdd(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem [] itemsInRepo = repository.findAll();
        int askedFilms = itemsInRepo.length;

        if (afishaLength <= 0) {
            if (defaultafishalength < itemsInRepo.length) {
                askedFilms = defaultafishalength;
            }
        } else {
            if (afishaLength < itemsInRepo.length) {
                askedFilms = afishaLength;
            }
        }

        PurchaseItem[] result = new PurchaseItem[askedFilms];
        for (int i = 0; i < result.length; i++) {
            int index = itemsInRepo.length - i - 1;
            result[i] = itemsInRepo[index];
        }
        return result;
    }
}
