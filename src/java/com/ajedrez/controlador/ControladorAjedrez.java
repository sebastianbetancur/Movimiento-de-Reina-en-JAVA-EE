/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajedrez.controlador;

import com.ajedrez.modelo.Coordenada;
import com.caracolesdecolores.controlador.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
@Named(value = "controladorAjedrez")
@SessionScoped
public class ControladorAjedrez implements Serializable {

    //Atributos
    private List<Coordenada> posicion = new ArrayList<>(); //Lista de coordenadas

    //Constructor
    public ControladorAjedrez() {
    }

    //Metodos
    public List<Coordenada> getPosicion() {
        return posicion;
    }

    public void setPosicion(List<Coordenada> posicion) {
        this.posicion = posicion;
    }

    public void posicionarFicha(int fila, int columna) { // Metodo que adiciona coordenada 
        //y validad que no se sobreponga y que tampoco se cruze con otras en la misma fila ó columna
        boolean validarCordenada = true;
        if (!posicion.isEmpty()) {
            for (Coordenada coordenada : posicion) {
                if (coordenada.getFila() == fila && coordenada.getColumna() == columna) {
                    JsfUtil.addErrorMessage("No puede adicionar otra reina en este espacio");
                    validarCordenada = false;
                }
            }
            if (validarCordenada) {
                if (validarPosicionesEnDiagonal(fila, columna)) {
                    if (validarPosicionesEnFila(fila)) {
                        if (validarPosicionesEnColumna(columna)) {
                            posicion.add(new Coordenada((byte) fila, (byte) columna));
                            JsfUtil.addSuccessMessage("Posicion guardada: " + fila + "." + columna);
                        }
                    }
                }
            }
        } else {
            posicion.add(new Coordenada((byte) fila, (byte) columna));
            JsfUtil.addSuccessMessage("Posicion guardada: " + fila + "." + columna);
        }
    }

    public String pintarPosicion(int fila, int columna) {//Metodo que me permite pintar la ficha de la reina

        for (Coordenada coordenada : posicion) {
            if (coordenada.getFila() == fila && coordenada.getColumna() == columna) {
                return "width: 100px; height: 50px; background-image: url('reinaAjedrez.png'); background-size: cover";
            }
        }
        if ((fila + columna) % 2 == 0) {
            return "background: black; width: 100px; height: 50px;";
        }
        return "width: 100px; height: 50px;";
    }

    public boolean validarPosicionesEnFila(int fila) {//Metodo que valida en todas las columnas
        for (Coordenada coordenada : posicion) {
            if (fila == coordenada.getFila()) {
                JsfUtil.addErrorMessage("Utlice reina en diferente fila");
                return false;
            }
        }
        return true;
    }

    public boolean validarPosicionesEnColumna(int columna) {//Metodo que valida en todas las filas
        for (Coordenada coordenada : posicion) {
            if (columna == coordenada.getColumna()) {
                JsfUtil.addErrorMessage("Utlice reina en diferente columna");
                return false;
            }
        }
        return true;
    }

    public boolean validarPosicionesEnDiagonal(int fila, int columna) {
        int i = fila;
        int j = columna;
        for (Coordenada coordenada : posicion) {
            while (i <= 8 || j <= 8) {
                if (coordenada.getFila() == i && coordenada.getColumna() == j) {
                    JsfUtil.addErrorMessage("Ya tiene otra reina en diagonal");
                    return false;
                }
                i++;
                j++;
            }
            i = fila;
            j = columna;
        }

        for (Coordenada coordenada : posicion) {
            while (i >= 1 || j >= 1) {
                if (coordenada.getFila() == i && coordenada.getColumna() == j) {
                    JsfUtil.addErrorMessage("Ya tiene otra reina en diagonal");
                    return false;
                }
                i--;
                j--;
            }
            i = fila;
            j = columna;
        }

        for (Coordenada coordenada : posicion) {
            while (i <= 8 || j >= 8) {
                if (coordenada.getFila() == i && coordenada.getColumna() == j) {
                    JsfUtil.addErrorMessage("Ya tiene otra reina en diagonal");
                    return false;
                }
                i++;
                j--;
            }
            i = fila;
            j = columna;
        }

        for (Coordenada coordenada : posicion) {
            while (i >= 8 || j <= 8) {
                if (coordenada.getFila() == i && coordenada.getColumna() == j) {
                    JsfUtil.addErrorMessage("Ya tiene otra reina en diagonal");
                    return false;
                }
                i--;
                j++;
            }
            i = fila;
            j = columna;
        }

        return true;
    }
}
