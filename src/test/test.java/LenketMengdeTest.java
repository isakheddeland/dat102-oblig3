package test.uke10.oblig;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class LenketMengdeTest {
    @Test
    public void testLeggTilOgInneholder() {
        LenketMengde<Integer> mengde = new LenketMengde<>();
        assertTrue(mengde.erTom());

        mengde.leggTil(5);
        assertFalse(mengde.erTom());
        assertTrue(mengde.inneholder(5));
    }
}
