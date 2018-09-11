package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Fdc
 */

public class Principal  extends Application {   
    static List <Elementos> conjuntoElementos = new ArrayList<>();
    
    static Button btEl1 = new Button();
    static Button btEl2 = new Button();
    static Button btEl3 = new Button();
    static Button btEl4 = new Button();
    static Button btEl5 = new Button();
    static Button btEl6 = new Button();
    static Button btEl7 = new Button();
    static Button btEl8 = new Button();
    static Button btEl9 = new Button();
    static Button btEl10 = new Button();
    
    static Elementos elemento1 = new Elementos ("Cobre (2)", 2, 63.54f, btEl1);
    static Elementos elemento2 = new Elementos ("Zinc",  2, 65.39f, btEl2);
    static Elementos elemento3 = new Elementos ("Hierro (3)",  3, 55.84f, btEl3);
    static Elementos elemento4 = new Elementos ("Oro (1)", 1, 196.96f, btEl4);
    static Elementos elemento5 = new Elementos ("Fósforo (5)", 5, 30.97f, btEl5);
    static Elementos elemento6 = new Elementos ("Sodio",  1, 23.0f, btEl6);
    static Elementos elemento7 = new Elementos ("Silicio",  4, 28.08f, btEl7);
    static Elementos elemento8 = new Elementos ("Boro",  3, 10.81f, btEl8);
    static Elementos elemento9 = new Elementos ("Oxígeno",  2, 16.0f, btEl9);
    static Elementos elemento10 = new Elementos ("Carbono",  4, 12.0f, btEl10);
    
    final Elementos elementoR1 = elementoRandom(conjuntoElementos);
    final Elementos elementoR2 = elementoRandom(conjuntoElementos);
    final Elementos elementoR3 = elementoRandom(conjuntoElementos);
    final Elementos elementoR4 = elementoRandom(conjuntoElementos);
    
    final Elementos elementoR5 = elementoRandom(conjuntoElementos);
    final Elementos elementoR6 = elementoRandom(conjuntoElementos);
    final Elementos elementoR7 = elementoRandom(conjuntoElementos);
    final Elementos elementoR8 = elementoRandom(conjuntoElementos);
    
    int index = 0;
    int miPuntaje=0;
    int puntajeEnemigo=0;
    List <Elementos> elementosEnemigos = new ArrayList<>();
    List <Elementos> misElementos = new ArrayList<>();
   
    //INICIO -------------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(new Insets (30,30,30,30));
        
        Text tituloEnemigo = new Text("Elemento Contrincante: ");
        Text miTitulo = new Text ("Elegir Elemento: ");
        Text instruccionesTitulo = new Text ("INSTRUCCIONES:");
        Text instrucciones0 = new Text ("Seleccionar Elemento --->> OK");
        GridPane.setColumnSpan(instrucciones0, 5);
        Text instrucciones1 = new Text ("Se generarán Elementos aleatorios para ambos equipos.");
        GridPane.setColumnSpan(instrucciones1, 5);
        Text instrucciones2 = new Text ("El daño de cada elemento sera su Número de valencia multiplicada por su Masa Atómica.");
        GridPane.setColumnSpan(instrucciones2, 5);
        Text instrucciones3 = new Text ("El numero de valencia, de los Elementos con mas de una, estará indicada entre paréntesis.");
        GridPane.setColumnSpan(instrucciones3, 5);
        
        GridPane.setConstraints(tituloEnemigo, 0, 0);
        GridPane.setConstraints(miTitulo, 0, 3);
        GridPane.setConstraints(instruccionesTitulo, 0, 7);
        GridPane.setConstraints(instrucciones0, 0, 8);
        GridPane.setConstraints(instrucciones1, 0, 9);
        GridPane.setConstraints(instrucciones2, 0, 10);
        GridPane.setConstraints(instrucciones3, 0, 11);
        
        
        
        //BOTONES ENEMIGOS:
        elementosEnemigos.add(elementoR1);
        elementosEnemigos.add(elementoR2);
        elementosEnemigos.add(elementoR3);
        elementosEnemigos.add(elementoR4);
        
        GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 1);
        
        //BOTON OK:
        Button bOk = new Button();
        bOk.setText(" OK ");
        GridPane.setConstraints(bOk, 4, 6);
        
        // MIS BOTONES:
        misElementos.add(elementoR5);
        misElementos.add(elementoR6);
        misElementos.add(elementoR7);
        misElementos.add(elementoR8);
        
        GridPane.setConstraints(misElementos.get(0).getBoton(), 1, 4);
        GridPane.setConstraints(misElementos.get(1).getBoton(), 2, 4);   
        GridPane.setConstraints(misElementos.get(2).getBoton(), 3, 4);    
        GridPane.setConstraints(misElementos.get(3).getBoton(), 4, 4);
        
        
        misElementos.get(0).getBoton().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 index =0;
            }
        });
        
        misElementos.get(1).getBoton().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                index =1;
            }
        });
        misElementos.get(2).getBoton().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                index=2;
            }
        });
        misElementos.get(3).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                
            @Override
            public void handle(ActionEvent event) {
                    index=3;           
            }
        });
        //
        
        bOk.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                switch (index){
                    case 0:
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(0).getBoton(),0));
                        break;
                    case 1:
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(1).getBoton(),1));
                        break;
                    case 2:
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(2).getBoton(),2));
                        break;
                    case 3: 
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(3).getBoton(),3));
                        break;
                }
            }
        });
        
        pane.getChildren().addAll(tituloEnemigo,elementosEnemigos.get(0).getBoton(),misElementos.get(0).getBoton(),misElementos.get(1).getBoton(),misElementos.get(2).getBoton(),misElementos.get(3).getBoton(),miTitulo,bOk,instruccionesTitulo,instrucciones0,instrucciones1,instrucciones2,instrucciones3);
        
        Scene scene = new Scene(pane, 600, 400);
        
        primaryStage.setTitle("Ap. Quimica (Valencias & Masa Atómica)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // -------------------------------------------------------------------------
    
    public Scene lanzarEscenaGeneral(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(new Insets (30,30,30,30));
        
        Text tituloEnemigo = new Text();
        tituloEnemigo.setText("Elemento Contrincante: ");
        Text miTitulo = new Text ();
        miTitulo.setText("Tus Elementos Disponibles: ");
        GridPane.setConstraints(tituloEnemigo, 0, 0);
        GridPane.setConstraints(miTitulo, 0, 3);
        
        switch (misElementos.size()){
            case 0:
                
                Scene scene = new Scene(lanzarEscenaFinal(primaryStage), 300, 300);
                return scene;
                
            case 1:
                //BOTONES ENEMIGOS:
                GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 1);
                        
                //MIS BOTONES:
                GridPane.setConstraints(misElementos.get(0).getBoton(), 1, 4);
                pane.getChildren().addAll(tituloEnemigo,elementosEnemigos.get(0).getBoton(),misElementos.get(0).getBoton(),miTitulo);
                
                misElementos.get(0).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(0).getBoton(),0));
                    }
                     });
                break;
            case 2:
                //BOTONES ENEMIGOS:
                GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 1);
                                        
                //MIS BOTONES:
                GridPane.setConstraints(misElementos.get(0).getBoton(), 1, 4);
                GridPane.setConstraints(misElementos.get(1).getBoton(), 2, 4);   
                pane.getChildren().addAll(tituloEnemigo,elementosEnemigos.get(0).getBoton(),misElementos.get(0).getBoton(),misElementos.get(1).getBoton(),miTitulo);
                
                misElementos.get(0).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(0).getBoton(),0));
                    }
                     });
                misElementos.get(1).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(1).getBoton(),1));
                    }
                     });
                break;
                
            case 3:
                //BOTONES ENEMIGOS:
                GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 1);
                
        
                //MIS BOTONES:
                GridPane.setConstraints(misElementos.get(0).getBoton(), 1, 4);
                GridPane.setConstraints(misElementos.get(1).getBoton(), 2, 4);   
                GridPane.setConstraints(misElementos.get(2).getBoton(), 3, 4 );
                
                pane.getChildren().addAll(tituloEnemigo,elementosEnemigos.get(0).getBoton(),misElementos.get(0).getBoton(),misElementos.get(1).getBoton(),misElementos.get(2).getBoton(),miTitulo);
                misElementos.get(0).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(0).getBoton(),0));
                    }
                     });
                misElementos.get(1).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(1).getBoton(),1));
                    }
                     });
                misElementos.get(2).getBoton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(lanzarEscenaReto(primaryStage,misElementos.get(2).getBoton(),2));
                    }
                     });
                break;
                            
        }
        
        Scene scene = new Scene(pane, 500, 300);
        return scene;
    }
    
    // -------------------------------------------------------------------------
    
    public Scene lanzarEscenaReto(Stage primaryStage,Button miBotonSeleccionado,int m){
        Button botonRespaldo=new Button ();
        botonRespaldo = miBotonSeleccionado;
        botonRespaldo.setDisable(true);
        elementosEnemigos.get(0).getBoton().setDisable(true);
        
        if(misElementos.get(m).getDaño() >= elementosEnemigos.get(0).getDaño()){
            miPuntaje++;
        }
        else{
           puntajeEnemigo++; 
        }
        
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(new Insets (30,30,30,30));
        
                
        Text titulo = new Text ("ELEMENTOS ELEGIDOS:");
        Text vs = new Text ("   VS   ");
        Text elContrincante = new Text ("Elemento Contrincante");
        Text tuElemento = new Text ("Tu Elemento Elegido");
        Button bOk = new Button();
        bOk.setText(" CONTINUAR ");
        bOk.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(lanzarEscenaGeneral(primaryStage));
            }
        });
        Text daño1 = new Text("Daño: "+elementosEnemigos.get(0).getDaño());
        Text daño2 = new Text ("Daño: "+misElementos.get(m).getDaño());
        
        GridPane.setConstraints(titulo, 1, 0);
        GridPane.setConstraints(vs, 2, 1);
        GridPane.setConstraints(elContrincante, 1, 1);
        GridPane.setConstraints(tuElemento, 3, 1);
        
        GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 2);
        GridPane.setConstraints(daño1, 1, 3);
        
        GridPane.setConstraints(botonRespaldo, 3, 2);
        GridPane.setConstraints(daño2, 3, 3);
        
        GridPane.setConstraints(bOk, 1, 4);
        GridPane.setColumnSpan(titulo, 2);
        
        pane.getChildren().addAll(titulo,elementosEnemigos.get(0).getBoton(),daño1,daño2,elContrincante,tuElemento,vs,botonRespaldo,bOk);
        
        Scene scene = new Scene(pane, 500,300);
        elementosEnemigos.remove(0);
        misElementos.remove(m);
        return scene;
    }
    //ESCENA FINAL:
    public GridPane lanzarEscenaFinal(Stage primaryStage){
        
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(new Insets (30,30,30,30));
        
        Text titulo = new Text ("FIN DEL JUEGO:");
        GridPane.setConstraints(titulo, 1, 0);
        String resultado = "nulo";
        
        if(miPuntaje>puntajeEnemigo){
            resultado = "GANASTE !";
        }
        if (miPuntaje==puntajeEnemigo){
            resultado = "EMPATE !";
        }
        if(miPuntaje<puntajeEnemigo){
            resultado = "PERDISTE !";
        }
        
        Text indicadorResultado = new Text(resultado);
        GridPane.setConstraints(indicadorResultado, 2, 1);
        
        Text valorResultado1 = new Text("Tu Puntaje Final: ");
        GridPane.setConstraints(valorResultado1, 1, 3);
        Text valorResultado_1 = new Text (""+miPuntaje);
        GridPane.setConstraints(valorResultado_1, 2, 3);
        
        Text valorResultado2 = new Text ("Puntaje Contrincante Final: ");
        GridPane.setConstraints(valorResultado2, 1, 4);
        Text valorResultado_2 = new Text (""+puntajeEnemigo);
        GridPane.setConstraints(valorResultado_2, 2, 4);

        pane.getChildren().addAll(titulo,indicadorResultado,valorResultado1,valorResultado_1,valorResultado2,valorResultado_2);
        
        return pane;
    }
    // -------------------------------------------------------------------------
    
    public Elementos elementoRandom(List conjuntoElementos){
        Random random = new Random ();
        int x = random.nextInt(conjuntoElementos.size());
        Elementos elementoElegido = (Elementos) conjuntoElementos.get(x);
        conjuntoElementos.remove(x);
        return elementoElegido;
    }
    
    public static void main(String[] args) {              //MAIN:
    btEl1.setText(elemento1.getNombreDelElemento());
    btEl2.setText(elemento2.getNombreDelElemento());
    btEl3.setText(elemento3.getNombreDelElemento());
    btEl4.setText(elemento4.getNombreDelElemento());
    btEl5.setText(elemento5.getNombreDelElemento());
    btEl6.setText(elemento6.getNombreDelElemento());
    btEl7.setText(elemento7.getNombreDelElemento());
    btEl8.setText(elemento8.getNombreDelElemento());
    btEl9.setText(elemento9.getNombreDelElemento());
    btEl10.setText(elemento10.getNombreDelElemento());
    conjuntoElementos.add(elemento1);
    conjuntoElementos.add(elemento2);
    conjuntoElementos.add(elemento3);
    conjuntoElementos.add(elemento4);
    conjuntoElementos.add(elemento5);
    conjuntoElementos.add(elemento6);
    conjuntoElementos.add(elemento7);
    conjuntoElementos.add(elemento8);
    conjuntoElementos.add(elemento9);
    conjuntoElementos.add(elemento10);
    
    launch(args);
    }
    
}
