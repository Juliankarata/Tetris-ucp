package com.tetris;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BoardTest {

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
