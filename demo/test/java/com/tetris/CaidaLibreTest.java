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
}