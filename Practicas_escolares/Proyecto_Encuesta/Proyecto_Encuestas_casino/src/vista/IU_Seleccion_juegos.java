package vista;

import Controlador.Controlador_Seleccion_Juego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class IU_Seleccion_juegos extends Application {

    // Lista donde se guardan los juegos seleccionados
    private List<String> juegosSeleccionados = new ArrayList<>();

    // Controlador que maneja la navegación
    private Controlador_Seleccion_Juego controladorSeleccionJuego;

    public static void main(String[] args){
        launch();
    }

    public void start(Stage stage){

        // Inicialización del controlador
        controladorSeleccionJuego =
                new Controlador_Seleccion_Juego(stage);

        // Layout principal
        GridPane gridPane=new GridPane();

        gridPane.setMinSize(500,300);
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // CheckBox de juegos disponibles
        CheckBox juego_1=new CheckBox("Poker");
        CheckBox juego_2=new CheckBox("Ruleta");
        CheckBox juego_3=new CheckBox("BlackJ");
        CheckBox juego_4=new CheckBox("Dados");
        CheckBox juego_5=new CheckBox("P&B");
        CheckBox juego_6=new CheckBox("PKCaribbean");
        CheckBox juego_7=new CheckBox("PKTexas");
        CheckBox juego_8=new CheckBox("Slots");

        // Cargar imágenes de los juegos
        Image img=new Image(
                getClass().getResourceAsStream("/Poker.jpg"));

        Image img2=new Image(
                getClass().getResourceAsStream("/Ruleta.jpg"));

        Image img3=new Image(
                getClass().getResourceAsStream("/BlackJ.jpg"));

        Image img4=new Image(
                getClass().getResourceAsStream("/Dados.jpg"));

        Image img5=new Image(
                getClass().getResourceAsStream("/P&B.jpg"));

        Image img6=new Image(
                getClass().getResourceAsStream("/PKCaribbean.jpg"));

        Image img7=new Image(
                getClass().getResourceAsStream("/PKtexas.jpg"));

        Image img8=new Image(
                getClass().getResourceAsStream("/Slots.jpg"));

        // Crear contenedores de imagen
        ImageView imgView=new ImageView(img);
        ImageView imgView2=new ImageView(img2);
        ImageView imgView3=new ImageView(img3);
        ImageView imgView4=new ImageView(img4);
        ImageView imgView5=new ImageView(img5);
        ImageView imgView6=new ImageView(img6);
        ImageView imgView7=new ImageView(img7);
        ImageView imgView8=new ImageView(img8);

        // Ajustar tamaño de imágenes
        imgView.setFitWidth(150);
        imgView.setFitHeight(150);

        imgView2.setFitWidth(150);
        imgView2.setFitHeight(150);

        imgView3.setFitWidth(150);
        imgView3.setFitHeight(150);

        imgView4.setFitWidth(150);
        imgView4.setFitHeight(150);

        imgView5.setFitWidth(150);
        imgView5.setFitHeight(150);

        imgView6.setFitWidth(150);
        imgView6.setFitHeight(150);

        imgView7.setFitWidth(150);
        imgView7.setFitHeight(150);

        imgView8.setFitWidth(150);
        imgView8.setFitHeight(150);

        // Asociar imágenes a los CheckBox
        juego_1.setGraphic(imgView);
        juego_2.setGraphic(imgView2);
        juego_3.setGraphic(imgView3);
        juego_4.setGraphic(imgView4);
        juego_5.setGraphic(imgView5);
        juego_6.setGraphic(imgView6);
        juego_7.setGraphic(imgView7);
        juego_8.setGraphic(imgView8);

        // Botón para continuar
        Button botonRegistro=new Button("Continuar");

        // Guardar selección de juegos
        juego_1.setOnAction(e->{

            if(juego_1.isSelected()){
                juegosSeleccionados.add("POKER");
            }
            else{
                juegosSeleccionados.remove("POKER");
            }

        });

        juego_2.setOnAction(e->{

            if(juego_2.isSelected()){
                juegosSeleccionados.add("RULETA");
            }
            else{
                juegosSeleccionados.remove("RULETA");
            }

        });

        juego_3.setOnAction(e->{

            if(juego_3.isSelected()){
                juegosSeleccionados.add("BLACKJACK");
            }
            else{
                juegosSeleccionados.remove("BLACKJACK");
            }

        });

        // (Misma lógica para los demás juegos)
        juego_4.setOnAction(e->{

            if(juego_4.isSelected()){
                juegosSeleccionados.add("DADOS");
            }
            else{
                juegosSeleccionados.remove("DADOS");
            }

        });

        juego_5.setOnAction(e->{

            if(juego_5.isSelected()){
                juegosSeleccionados.add("PNB");
            }
            else{
                juegosSeleccionados.remove("PNB");
            }

        });

        juego_6.setOnAction(e->{

            if(juego_6.isSelected()){
                juegosSeleccionados.add("PKCARIBBEAN");
            }
            else{
                juegosSeleccionados.remove("PKCARIBBEAN");
            }

        });

        juego_7.setOnAction(e->{

            if(juego_7.isSelected()){
                juegosSeleccionados.add("PKTEXAS");
            }
            else{
                juegosSeleccionados.remove("PKTEXAS");
            }

        });

        juego_8.setOnAction(e->{

            if(juego_8.isSelected()){
                juegosSeleccionados.add("SLOTS");
            }
            else{
                juegosSeleccionados.remove("SLOTS");
            }

        });

        // Ir a la siguiente IU con los juegos seleccionados
        botonRegistro.setOnAction(e->
                controladorSeleccionJuego
                        .IU_Encuesta(juegosSeleccionados)
        );

        // Botón para cerrar sesión
        Button cerrar=new Button("Cerrar sesión");

        cerrar.setOnAction(e->
                controladorSeleccionJuego.regresar()
        );

        // Botón de ayuda
        Button ayuda=new Button("Ayuda");

        ayuda.setOnAction(e->
                controladorSeleccionJuego
                        .IU_Centros_Ayuda()
        );

        // Texto informativo
        Text texto=new Text(
                "Si tienes problemas con apuestas presiona ayuda");

        texto.setFont(
                Font.font("Arial",
                        FontWeight.BOLD,18));

        // Agregar componentes al layout
        gridPane.add(juego_1,0,0);
        gridPane.add(juego_2,1,0);
        gridPane.add(juego_3,2,0);

        gridPane.add(juego_4,0,1);
        gridPane.add(juego_5,1,1);
        gridPane.add(juego_6,2,1);

        gridPane.add(juego_7,0,2);
        gridPane.add(juego_8,1,2);

        gridPane.add(botonRegistro,3,2);

        gridPane.add(cerrar,4,2);

        gridPane.add(texto,0,4,3,1);

        gridPane.add(ayuda,1,5);

        // Crear escena
        Scene scene=new Scene(gridPane,900,650);

        stage.setTitle("Selección juegos");

        stage.setScene(scene);

        stage.show();

    }

}