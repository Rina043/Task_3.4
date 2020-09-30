package ru.netology.manager;
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
class MovieManagerTest {
    @Mock
   MovieRepository movieRepository;
    @InjectMocks
   MovieManager movieManager = new MovieManager();
    PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
     PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 12);
     PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
   PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);
   PurchaseItem fifth = new PurchaseItem(5, 5, "url5", "name5", "genre2", 12);
     PurchaseItem sixth = new PurchaseItem(6, 6, "url6", "name6", "genre3", 18);
     PurchaseItem seventh = new PurchaseItem(7, 7, "url7", "name7", "genre1", 6);
     PurchaseItem eighth = new PurchaseItem(8, 8, "url8", "name8", "genre2", 12);
     PurchaseItem ninth = new PurchaseItem(9, 9, "url9", "name9", "genre3", 18);
     PurchaseItem tenth = new PurchaseItem(10, 10, "url10", "name10", "genre1", 6);

    @Test
    void shouldDisplayTenAsByDefaultIfZero() {
        movieManager = new MovieManager(movieRepository,0);

        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }
    @Test
    void shouldDisplayTenAsByDefaultIfLessZero() {
        movieManager = new MovieManager(movieRepository,-1);

        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void shouldDisplayLastOneAsByDefaultIfZero() {
        movieManager = new MovieManager(movieRepository,0);

        PurchaseItem[] returned = new PurchaseItem[]{first};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }
    @Test
    void shouldDisplayOneAsByDefaultIfLessZero() {
        movieManager = new MovieManager(movieRepository,-1);

        PurchaseItem[] returned = new PurchaseItem[]{first};
        doReturn(returned).when(movieRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{first};
        PurchaseItem[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);

        verify(movieRepository, times(1)).findAll();
    }

}