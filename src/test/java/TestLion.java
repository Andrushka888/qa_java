import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLion {
    private final String lionGender;
    private final boolean expectedPresenceMane;
    public TestLion(String lionGender, boolean expectedPresenceMane) {
        this.lionGender = lionGender;
        this.expectedPresenceMane = expectedPresenceMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Нечто иное", false},
                {"Самка", false}
        };
    }

    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestCountLionIsOne() throws Exception {
    try {
        Lion lion = new Lion(lionGender,feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedLionCount = 1;
        int actualLionCount = lion.getKittens();
         assertEquals(expectedLionCount, actualLionCount);
    } catch(Exception exception) {
            System.out.println("Должны использоваться только допустимые значения пола животного - Самец или Самка");
       }
    }

    @Test
    public void TestLionHaveMane() throws Exception {
        try {
        Lion lion = new Lion(lionGender, feline);
        boolean expectedPresenceManeIfLionIsMale = expectedPresenceMane;
        boolean actualPresenceMane = lion.doesHaveMane();

        assertEquals("Грива должна быть только у самца, иначе false", expectedPresenceManeIfLionIsMale, actualPresenceMane);
    } catch(Exception exception) {
        System.out.println("Должны использоваться только допустимые значения пола животного - Самец или Самка");
        }
    }

    @Test
    public void TestLionEatingLikePredator() throws Exception {
        try {
        Lion lion = new Lion(lionGender, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedTypeEatingLion = List.of("Животные", "Птицы", "Рыба");
        List<String> actualTypeEatingLion = lion.getFood();
        assertEquals(expectedTypeEatingLion, actualTypeEatingLion);
        } catch(Exception exception) {
            System.out.println("Должны использоваться только допустимые значения пола животного - Самец или Самка");
        }
    }
}
