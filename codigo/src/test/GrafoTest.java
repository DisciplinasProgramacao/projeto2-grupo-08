package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.GrafoDirecionado;
import app.Lista;

public class GrafoTest {

    private GrafoDirecionado g;

    @BeforeEach
    public void setUp() {
        g = new GrafoDirecionado("Grafo Direcionado");

        g.addVertice(1);
        g.addVertice(2);

        g.addAresta(1, 2);
    }

    @Test
    public void testAddEExisteVertice() {
        assertNotNull(g.existeVertice(1));
        assertNotNull(g.existeVertice(2));
        assertNull(g.existeVertice(3));
        g.addVertice(3);
        assertNotNull(g.existeVertice(3));
    }

    @Test
    public void testOrdem() {
        assertEquals(g.ordem(), 2, 0.0001);
        g.addVertice(3);
        assertEquals(g.ordem(), 3, 0.0001);
    }

    @Test
    public void testTamanho() {
        assertEquals(g.tamanho(), 3, 0.0001);
        g.addVertice(3);
        assertEquals(g.tamanho(), 4, 0.0001);
        g.addAresta(1, 3);
        g.addAresta(2, 1);
        assertEquals(g.tamanho(), 6, 0.0001);
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
    }

    @Test
    public void testSubgrafo() {
        g.addVertice(3);
        g.addVertice(4);
        g.addVertice(5);

        g.addAresta(2, 3);
        g.addAresta(3, 4);
        g.addAresta(4,5);
        g.addAresta(5, 1);
        g.addAresta(2, 4);
        g.addAresta(2, 5);
        g.addAresta(1, 3);
        g.addAresta(1, 5);

        Lista<Integer> verticesSub = new Lista<Integer>();
        verticesSub.add(2);
        verticesSub.add(4);
        verticesSub.add(5);

        GrafoDirecionado subgrafo = (GrafoDirecionado) g.subGrafo(verticesSub);

        assertNull(subgrafo.existeVertice(1));
        assertNotNull(subgrafo.existeVertice(2));
        assertNull(subgrafo.existeVertice(3));
        assertNotNull(subgrafo.existeVertice(4));
        assertNotNull(subgrafo.existeVertice(5));

        assertNull(subgrafo.existeAresta(1, 2));
        assertNull(subgrafo.existeAresta(2, 3));
        assertNull(subgrafo.existeAresta(3, 4));
        assertNotNull(subgrafo.existeAresta(4, 5));
        assertNull(subgrafo.existeAresta(5, 1));
        assertNotNull(subgrafo.existeAresta(2, 4));
        assertNotNull(subgrafo.existeAresta(2, 5));
        assertNull(subgrafo.existeAresta(1, 3));
        assertNull(subgrafo.existeAresta(1, 5));
    }
    
}
