package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.MovieManager;
import ru.netology.repository.MovieRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerDefaultTest {
    @Mock
    MovieRepository movieRepository;
    @InjectMocks
    MovieManager movieManager = new MovieManager(movieRepository);
    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
    private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);
    private PurchaseItem fifth = new PurchaseItem(5, 5, "url5", "name5", "genre2", 12);
    private PurchaseItem sixth = new PurchaseItem(6, 6, "url6", "name6", "genre3", 18);
    private PurchaseItem seventh = new PurchaseItem(7, 7, "url7", "name7", "genre1", 6);
    private PurchaseItem eighth = new PurchaseItem(8, 8, "url8", "name8", "genre2", 12);
    private PurchaseItem ninth = new PurchaseItem(9, 9, "url9", "name9", "genre3", 18);
    private PurchaseItem tenth = new PurchaseItem(10, 10, "url10", "name10", "genre1", 6);
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "url11", "name11", "genre2", 12);

    @BeforeEach
    void setup() {
        movieManager = new MovieManager(movieRepository);

    }

    @Test
    void shouldDisplayLastTenIfTen() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }
    @Test
    void shouldDisplayLastTenIfMore() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void shouldDisplayLastOneIfOne() {
        PurchaseItem[] returned = new PurchaseItem[]{first};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        PurchaseItem[] returned = new PurchaseItem[]{};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }


}