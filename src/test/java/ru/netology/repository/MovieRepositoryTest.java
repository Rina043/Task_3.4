package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {
    private MovieRepository movieRepository = new MovieRepository();

    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);

    @BeforeEach
    public void setUp() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
    }

    @Test
    public void shouldAdd() {
        PurchaseItem[] actual = movieRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        movieRepository.removeById(idToRemove);
        PurchaseItem[] actual = movieRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotExists() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        int idToFind = 5;
        movieRepository.findById(idToFind);
        PurchaseItem expected = null;
        PurchaseItem actual = movieRepository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        int findId = 2;
        PurchaseItem actual = movieRepository.findById(findId);
        PurchaseItem expected = second;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        PurchaseItem actual = movieRepository.findById(findId);

        assertEquals(null, actual);
    }

    @Test
    public void shouldRemoveAll() {
        movieRepository.removeAll();
        PurchaseItem[] actual = movieRepository.findAll();
        PurchaseItem[] expected = new PurchaseItem[0];

        assertArrayEquals(expected, actual);
    }
}
