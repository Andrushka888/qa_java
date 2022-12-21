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

    public TestLion(String lionGender) {
        this.lionGender = lionGender;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец"},
                {"Самка"}
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

        Lion lion = new Lion(feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        int expectedLionCount = 1;
        int actualLionCount = lion.getKittens();

        assertEquals(expectedLionCount, actualLionCount);

    }


    @Test
    public void TestLionHaveMane() throws Exception {

        Lion lion = new Lion(lionGender);

        boolean expectedLionSex = true;
        boolean actualLionSex = lion.doesHaveMane();

        assertEquals(expectedLionSex, actualLionSex);

    }


    @Test
    public void TestLionEatingLikePredator() throws Exception {

        Lion lion = new Lion(feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedTypeEatingLion = List.of("Животные", "Птицы", "Рыба");
        List<String> actualTypeEatingLion = lion.getFood();

        assertEquals(expectedTypeEatingLion, actualTypeEatingLion);

    }

}
