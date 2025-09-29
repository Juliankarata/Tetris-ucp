package com.tetris;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaidaLibreTest {

    @Test
    public void testPiezaOCaidaLibre() {
        Juego juego = new Juego(4, 6);
        Board tablero = juego.getTablero();

        Pieza piezaO = new PieceSquare(); 
        tablero.ponerPiezaActual(piezaO);

        boolean aterrizo = false;
        for (int i = 0; i < 20; i++) {
            tablero.moverAbajo();
            if (tablero.obtenerPiezaActual() == null) {
                aterrizo = true;
                break;
            }
        }

        assertTrue(aterrizo, "La pieza O debería aterrizar (caída libre)");
    }

    @Test
    public void testColisionEntrePiezas() {
        Juego juego = new Juego(4, 6);
        Board tablero = juego.getTablero();


        Pieza piezaO = new PieceSquare();
        tablero.ponerPiezaActual(piezaO);
        while (tablero.obtenerPiezaActual() != null) {
            tablero.moverAbajo();
        }

        Pieza piezaI = new PieceStick();
        tablero.ponerPiezaActual(piezaI);
        boolean colisiono = false;
        for (int i = 0; i < 20; i++) {
            boolean pudoMover = tablero.moverAbajo();
            if (!pudoMover) {
                colisiono = true;
                break;
            }
        }

        assertTrue(colisiono, "La segunda pieza debe colisionar con la primera y detenerse");
    }

    @Test
    public void testPiezaICaidaLibre() {
        Juego juego = new Juego(4, 6);
        Board tablero = juego.getTablero();

        Pieza piezaI = new PieceStick();
        tablero.ponerPiezaActual(piezaI);

        boolean aterrizo = false;
        for (int i = 0; i < 20; i++) {
            tablero.moverAbajo();
            if (tablero.obtenerPiezaActual() == null) {
                aterrizo = true;
                break;
            }
        }

        assertTrue(aterrizo, "La pieza I debería aterrizar (caída libre)");
    }




    @Test
    public void eliminaLineaCompletaYDesplazaFilasSuperiores() {
        Board tablero = new Board(4, 4);

        boolean[][] tableroInicial = {
            {false, false, false, false},
            {false, false, false, false},
            {false, true,  false, false},
            {true,  true,  true,  true}
        };

        tablero.establecerTablero(tableroInicial);

        int eliminadas = tablero.eliminarLineasCompletas();

        assertEquals(1, eliminadas, "Debe eliminar exactamente una línea completa");

        boolean[][] tableroResultante = tablero.obtenerTablero();

        boolean[][] esperado = {
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, true,  false, false}
        };

        assertArrayEquals(esperado[0], tableroResultante[0], "La fila 0 debe quedar vacía");
        assertArrayEquals(esperado[1], tableroResultante[1], "La fila 1 debe quedar vacía");
        assertArrayEquals(esperado[2], tableroResultante[2], "La fila 2 debe quedar vacía");
        assertArrayEquals(esperado[3], tableroResultante[3], "La fila 3 debe contener la pieza desplazada");

        // Comprobación adicional: la fila completamente vacía ahora está al tope
        assertFalse(tableroResultante[0][0], "La primera celda debe estar vacía luego del corrimiento");
    }
}