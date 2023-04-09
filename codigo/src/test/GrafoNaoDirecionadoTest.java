package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.GrafoNaoDirecionado;

public class GrafoNaoDirecionadoTest {
    private GrafoNaoDirecionado g;

    @BeforeEach
    public void setUp() {
        g = new GrafoNaoDirecionado("Grafo Direcionado");

        g.addVertice(1);
        g.addVertice(2);

        g.addAresta(1, 2);
    }

    @Test
    public void testAddAresta() {
        assertNotNull(g.existeAresta(2, 1));
        assertNotNull(g.existeAresta(1, 2));

        g.addVertice(3);

        g.addAresta(1, 3);
        assertNotNull(g.existeAresta(1, 3));
        assertNotNull(g.existeAresta(3, 1));

    }

    @Test
    public void testRemoveAresta() {
        assertNotNull(g.existeAresta(1, 2));
        assertNotNull(g.existeAresta(2, 1));

        assertNotNull(g.removeAresta(2, 1));
        assertNull(g.existeAresta(2, 1));
        assertNull(g.existeAresta(1,2));
    }
}
