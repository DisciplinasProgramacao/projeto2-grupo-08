package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Grafo;
import classes.Vertice;

public class GrafoTest {
    private Grafo g;

    @BeforeEach
    public void setUp() {
        g = new Grafo("Novo Grafo");

        g.addVertice(1);
        g.addVertice(2);
        g.addAresta(1, 2);
    }

    @Test
    public void testOrdem() {
        assertEquals(g.ordem(), 2, 0.0001);
        g.addVertice(3);
        assertEquals(g.ordem(), 3, 0.0001);
    }

    @Test
    public void testGrafoCompleto() {
        g.addVertice(3);
        
        g.addAresta(1, 3);
        assertFalse(g.completo());

        g.addAresta(2, 1);
        assertFalse(g.completo());

        g.addAresta(2, 3);
        assertFalse(g.completo());

        g.addAresta(3, 2);
        assertFalse(g.completo());

        g.addAresta(3, 1);
        assertTrue(g.completo());

        Grafo completo = Grafo.grafoCompleto(22);
        assertTrue(completo.completo());
    }
}
