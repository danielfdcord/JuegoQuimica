
package Juego;

import javafx.scene.control.Button;

/**
 *
 * @author Daniel Fdc
 */
public class Elementos {
    
private final  String nombreDelElemento;
private final  int numeroValencia;
private final  float masaAtomica;
private final Button boton;

    public Elementos(String nombreDelElemento, int numeroValencia, float masaAtomica, Button boton) {
        this.nombreDelElemento = nombreDelElemento;
        this.numeroValencia = numeroValencia;
        this.masaAtomica = masaAtomica;
        this.boton = boton;
    }

    public String getNombreDelElemento (){
        return this.nombreDelElemento;
    }
            
    public int getDaño(){
        return (this.numeroValencia*(int)this.masaAtomica);
    }
    public Button getBoton(){
        return this.boton;
    }
}
