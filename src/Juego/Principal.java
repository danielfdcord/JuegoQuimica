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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    static Elementos elemento2 = new Elementos ("Aluminio",  3, 26.98f, btEl2);
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
        pane.setVgap(18);
        pane.setHgap(20);
        pane.setPadding(new Insets (20,20,20,20));
        
        Text titulo = new Text("Presentacion Trabajo Quimica: ");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        titulo.setFill(Color.BEIGE);
        GridPane.setColumnSpan(titulo, 3);
        
        Text nombre = new Text("Fabiana Fernandez de Cordova R. ");
        nombre.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 15));  
        nombre.setFill(Color.BEIGE);
        GridPane.setColumnSpan(nombre, 3);
        
        Text instruccionesTitulo = new Text ("Instrucciones:");
        instruccionesTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        instruccionesTitulo.setFill(Color.BEIGE);
        Text instrucciones0 = new Text ("Se generarán Elementos aleatorios para ambos equipos.");
        instrucciones0.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        instrucciones0.setFill(Color.BEIGE);
        GridPane.setColumnSpan(instrucciones0, 5);
        Text instrucciones1 = new Text ("El daño de cada elemento sera su Número de valencia multiplicada por su Masa Atómica.");
        instrucciones1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        instrucciones1.setFill(Color.BEIGE);
        GridPane.setColumnSpan(instrucciones1, 5);
        Text instrucciones2 = new Text ("El numero de valencia, de los Elementos con mas de una, estará subrayada.");
        instrucciones2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        GridPane.setColumnSpan(instrucciones2, 5);
        instrucciones2.setFill(Color.BEIGE);
        Text escuela = new Text ("Colegio Adventista");
        escuela.setFont(Font.font("Tahoma", FontWeight.BOLD, 13));
        GridPane.setColumnSpan(escuela, 5);
        escuela.setFill(Color.BEIGE);
        
        
        GridPane.setConstraints(titulo, 0, 0);
        GridPane.setConstraints(escuela, 0, 9);
        GridPane.setConstraints(nombre, 0, 10); 
        GridPane.setConstraints(instruccionesTitulo, 0, 3);
        GridPane.setConstraints(instrucciones0, 0, 4);
        GridPane.setConstraints(instrucciones1, 0, 5);
        GridPane.setConstraints(instrucciones2, 0, 6);
        
        
        Button continuar = new Button ();
        continuar.setText("Continuar");
        pane.getChildren().addAll(titulo,nombre,continuar,escuela,instruccionesTitulo,instrucciones0,instrucciones1,instrucciones2);
        continuar.setOnAction(new EventHandler<ActionEvent>() {
                
            @Override
            public void handle(ActionEvent event) {
                    primaryStage.setScene(lanzarEscenaPrimera(primaryStage));           
            }
        });
        GridPane.setConstraints(continuar, 0, 8);  
        
        pane.setStyle("-fx-background-image: url('curie.jpg')");
        
        Scene scene = new Scene (pane,550,350);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Ap. Quimica (Valencias & Masa Atómica)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // -------------------------------------------------------------------------
    
    public Scene lanzarEscenaPrimera(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(10);
        pane.setHgap(20);
        pane.setPadding(new Insets (15,20,10,20));
        
        Text tituloEnemigo = new Text("Elementos Contrincantes: ");
        tituloEnemigo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        GridPane.setColumnSpan(tituloEnemigo, 5);
        Text miTitulo = new Text ("Tus Elementos: ");
        miTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        GridPane.setColumnSpan(miTitulo, 5);
        
        
        Text instrucciones = new Text (" Seleccionar tu Elemento --->> OK");
        instrucciones.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        GridPane.setColumnSpan(instrucciones, 5);
        
        GridPane.setConstraints(tituloEnemigo, 0, 0);
        GridPane.setConstraints(miTitulo, 0, 3);
        GridPane.setConstraints(instrucciones, 0, 7);
        
        //BOTONES ENEMIGOS:
        elementosEnemigos.add(elementoR1);
        elementosEnemigos.add(elementoR2);
        elementosEnemigos.add(elementoR3);
        elementosEnemigos.add(elementoR4);
        
        GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 1);
        GridPane.setConstraints(elementosEnemigos.get(1).getBoton(), 2, 1);
        GridPane.setConstraints(elementosEnemigos.get(2).getBoton(), 3, 1);
        GridPane.setConstraints(elementosEnemigos.get(3).getBoton(), 4, 1);
        
        //BOTON OK:
        Button bOk = new Button();
        bOk.setText(" OK ");
        bOk.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
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
        
        pane.getChildren().addAll(tituloEnemigo,elementosEnemigos.get(0).getBoton(),elementosEnemigos.get(1).getBoton(),elementosEnemigos.get(2).getBoton(),elementosEnemigos.get(3).getBoton(),misElementos.get(0).getBoton(),misElementos.get(1).getBoton(),misElementos.get(2).getBoton(),misElementos.get(3).getBoton(),miTitulo,bOk,instrucciones);
        pane.setStyle("-fx-background-image: url('pastel2.jpg')");
        Scene scene = new Scene(pane, 600, 500);    
        return scene;
        }
    
    // ------------------------------------------------------------------------
    
    public Scene lanzarEscenaGeneral(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setVgap(20);
        pane.setHgap(20);
        pane.setPadding(new Insets (20,30,30,30));
        
        Text tituloEnemigo = new Text("Elemento Contrincante: ");
        GridPane.setColumnSpan(tituloEnemigo, 5);
        tituloEnemigo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        
        Text miTitulo = new Text ("Tus Elementos Disponibles:");
        GridPane.setColumnSpan(miTitulo, 5);
        miTitulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        GridPane.setConstraints(tituloEnemigo, 0, 0);
        GridPane.setConstraints(miTitulo, 0, 3);
        
        switch (misElementos.size()){
            case 0:
                
                Scene scene = new Scene(lanzarEscenaFinal(primaryStage), 370, 320);
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
        pane.setStyle("-fx-background-image: url('pastel22.jpg')");
        Scene scene = new Scene(pane, 600, 500);
        
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
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text vs = new Text ("   VS   ");
        vs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        Text elContrincante = new Text ("Elemento Contrincante");
        GridPane.setColumnSpan(elContrincante, 2);
       
        elContrincante.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text tuElemento = new Text ("Tu Elemento Elegido");
        tuElemento.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Button bOk = new Button();
        bOk.setText(" CONTINUAR ");
        bOk.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        bOk.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(lanzarEscenaGeneral(primaryStage));
            }
        });
        Text daño1 = new Text("Daño: "+elementosEnemigos.get(0).getDaño());
        daño1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Text daño2 = new Text ("Daño: "+misElementos.get(m).getDaño());
        daño2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        
        GridPane.setConstraints(titulo, 1, 0);
        GridPane.setConstraints(vs, 2, 2);
        GridPane.setConstraints(elContrincante, 1, 1);
        GridPane.setConstraints(tuElemento, 3, 1);
        
        GridPane.setConstraints(elementosEnemigos.get(0).getBoton(), 1, 2);
        GridPane.setConstraints(daño1, 1, 3);
        
        GridPane.setConstraints(botonRespaldo, 3, 2);
        GridPane.setConstraints(daño2, 3, 3);
        
        GridPane.setConstraints(bOk, 1, 4);
        GridPane.setColumnSpan(titulo, 2);
        
        pane.getChildren().addAll(titulo,elementosEnemigos.get(0).getBoton(),daño1,daño2,elContrincante,tuElemento,vs,botonRespaldo,bOk);
        
        pane.setStyle("-fx-background-image: url('pastel1.jpg')");
        Scene scene = new Scene(pane, 600,400);
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
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        GridPane.setColumnSpan(titulo, 2);
        GridPane.setConstraints(titulo, 1, 0);
        String resultado = "nulo";
        
        if(miPuntaje>puntajeEnemigo){
            resultado = "¡ GANASTE !";
        }
        if (miPuntaje==puntajeEnemigo){
            resultado = "¡ EMPATE !";
        }
        if(miPuntaje<puntajeEnemigo){
            resultado = "¡ PERDISTE !";
        }
        
        Text indicadorResultado = new Text(resultado);
        indicadorResultado.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
        GridPane.setConstraints(indicadorResultado, 1, 1);
        
        Text valorResultado1 = new Text("Tu Puntaje Final: ");
        valorResultado1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(valorResultado1, 1, 3);
        Text valorResultado_1 = new Text (""+miPuntaje);
        valorResultado_1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(valorResultado_1, 2, 3);
        
        Text valorResultado2 = new Text ("Puntaje Contrincante Final: ");
        valorResultado2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(valorResultado2, 1, 4);
        Text valorResultado_2 = new Text (""+puntajeEnemigo);
        valorResultado_2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(valorResultado_2, 2, 4);

        pane.getChildren().addAll(titulo,indicadorResultado,valorResultado1,valorResultado_1,valorResultado2,valorResultado_2);
        pane.setStyle("-fx-background-image: url('final.jpg')");
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
   
    btEl1.setStyle("-fx-background-image: url('cobre.jpg')");
    btEl1.setPrefSize(100,150);
    btEl2.setStyle("-fx-background-image: url('aluminio.jpg')");
    btEl2.setPrefSize(100,150);
    btEl3.setStyle("-fx-background-image: url('hierro.jpg')");
    btEl3.setPrefSize(100,150);
    btEl4.setStyle("-fx-background-image: url('oro.jpg')");
    btEl4.setPrefSize(100,150);
    btEl5.setStyle("-fx-background-image: url('fosforo.jpg')");
    btEl5.setPrefSize(100,150);
    btEl6.setStyle("-fx-background-image: url('sodio.jpg')");
    btEl6.setPrefSize(100,150);
    btEl7.setStyle("-fx-background-image: url('silicio.jpg')");
    btEl7.setPrefSize(100,150);
    btEl8.setStyle("-fx-background-image: url('boro.jpg')");
    btEl8.setPrefSize(100,150);
    btEl9.setStyle("-fx-background-image: url('oxigeno.jpg')");
    btEl9.setPrefSize(100,150);
    btEl10.setStyle("-fx-background-image: url('carbono.jpg')");
    btEl10.setPrefSize(100,150);
    
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
