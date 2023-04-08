package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.GrafoCompleto;

public class GrafoCompletoTest {
    private GrafoCompleto g;

    @BeforeEach
    public void setUp() {
        g = new GrafoCompleto(5);
    }

    @Test
    public void testGrafoCompleto() {
        assertTrue(g.completo());

        GrafoCompleto novo = new GrafoCompleto(22);

        assertTrue(novo.completo());
    }
}
