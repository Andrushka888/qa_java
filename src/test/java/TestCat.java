import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Test
    public void TestCatSayMeow() {

        Feline feline = new Feline();
        Cat cat = new Cat(feline);

        String expectedCatSound = "Мяу";
        String actualCatSound = cat.getSound();

        assertEquals(expectedCatSound, actualCatSound);

    }

    @Mock
    private Feline predator;

    @Test
    public void TestCatEatingLikePredator() throws Exception {

        Cat cat = new Cat(predator);

        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedTypeEatingCat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualTypeEatingCat = cat.getFood();

        assertEquals(expectedTypeEatingCat, actualTypeEatingCat);
    }

}
