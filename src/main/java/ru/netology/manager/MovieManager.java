package ru.netology.manager;
import ru.netology.domain.PurchaseItem;

public class MovieManager { private PurchaseItem[] items = new PurchaseItem[0];
    private int defaultafishalength = 10;
    private int afishaLength;

    public MovieManager() {
    }

    public MovieManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }


    public void add(PurchaseItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        // копируем поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getAll() {
        int askedFilms = items.length;

        if (afishaLength <= 0) {
            if (defaultafishalength < items.length) {
                askedFilms = defaultafishalength;
            }
        } else {
            if (afishaLength < items.length) {
                askedFilms = afishaLength;
            }
        }

        PurchaseItem[] result = new PurchaseItem[askedFilms];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
