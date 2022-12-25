import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {


    @Test
    public void TestFelineEatingLikePredator() throws Exception {

        Feline feline = new Feline();

        List<String> expectedTypeEatingFeline = List.of("Животные", "Птицы", "Рыба");
        List<String> actualTypeEatingFeline = feline.getFood("Хищник");

        assertEquals(expectedTypeEatingFeline, actualTypeEatingFeline);

    }

    @Test
    public void TestFelineFamilyIsCats() {

        Feline feline = new Feline();

        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);

    }

    @Test
    public void TestGetKittensJustOne() {

        Feline feline = new Feline();

        int expectedKittenCount = 1;
        int actualKittenCount = feline.getKittens();

        assertEquals(expectedKittenCount, actualKittenCount);

    }

    @Test
    public void TestGetKittensArbitraryQuantity() {

        Feline feline = new Feline();

        int expectedKittenArbitraryCount = 5;
        int actualKittenArbitraryCount = feline.getKittens(5);

        assertEquals(expectedKittenArbitraryCount, actualKittenArbitraryCount);

    }
}
