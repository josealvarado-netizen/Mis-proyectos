//Bibliotecas necesarias
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controlador {

    // Método que abre el archivo y muestra su contenido en el text area
    public void Abrir_archivo(Stage parentStage, TextArea areaTexto) {
        FileChooser fileChooser = new FileChooser();
        //FileChooser es una clase de JavaFx que permite mostrar una ventana emergente
        //Para que el usuario seleccioene un archivo de su sistema operativo
        // new filechooser() crea una nueva instancia del selector de archivos

        //titulo de la ventana
        fileChooser.setTitle("Abrir archivo seleccionado");

        // Mostrar el diálogo
        File archivo = fileChooser.showOpenDialog(parentStage);
        //File archivo es una variable de tipo file que almacena la ruta del archivo
        // fileChooser.showOpenDialog abre una ventana del sistema para seleccion de un archivo
        //el parenstage hace que las ventanas esten vinculasdas
        if (archivo != null) { // compra que la direccion del archivo sea diferente de null
            try { //Bloque para el manejo de errores
                String contenido = new String(Files.readAllBytes(Paths.get(archivo.getAbsolutePath())));
                //Se optiene la direccion de del archivo
                //convierte el arreglo en una cadena de bayts
                //se convierte el arreglo de bayts a String y posteriormente lo almacena en la variable contenido
                areaTexto.setText(contenido);//Posteriormente lo pone en el text area principal
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Metodo para guardar el archivo
    public void Guardar_archivo(Stage parentStage, TextArea areaTexto) {
        FileChooser fileChooser = new FileChooser();
        //FileChooser es una clase de JavaFx que permite mostrar una ventana emergente
        //Para que el usuario seleccioene un archivo de su sistema operativo
        // new filechooser() crea una nueva instancia del selector de archivos

        //Nombre de la ventana
        fileChooser.setTitle("Guardar archivo como");

        // Sugerir extensión .ru
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos RU (*.ru)", "*.ru");
        // FileChooser.ExtensionFilter define filtros basados en una extension y lo filtra
        //new FileChooser.ExtensionFilter(...) crea una nueva instancia del la extencion o filtro
        //Archivos RU (*.ru)	Es el texto descriptivo que se mostrará en la ventana
        //*.ru es la extencion de archivo con el que se guardaran los documentos


        fileChooser.getExtensionFilters().add(extFilter);
        //Ese filtro indica que el usuario solo verá archivos con la extensión .ru al desplegar la ventana

        // Sugerir nombre de archivo
        fileChooser.setInitialFileName("nuevo_archivo.ru");

        // Mostrar diálogo de guardado
        File archivo = fileChooser.showSaveDialog(parentStage);

        if (archivo != null) { //compara si el archivo es diferente de null

            //intenta guardar el contenido de un TextArea en un archivo, y si ocurre un error.
            try (FileWriter writer = new FileWriter(archivo)) {
                writer.write(areaTexto.getText());
                //areaTexto.getText() obtiene el texto que el usuario haya escrito
                //writer.write(...) lo escribe en el archivo.
            } catch (IOException e) {
                e.printStackTrace(); // No se hace nada más
            }
        }
    }

    // Este método procesa el código ingresado usando Lanzador y muestra su salida
    public void Ejecutar_codigo(String codigo) {
        try {
            // Guardar referencias originales
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;

            // Redirigir System.in con el código del TextArea
            System.setIn(new ByteArrayInputStream(codigo.getBytes(StandardCharsets.UTF_8)));//ew ByteArrayInputStream(...): crea un flujo que simula ser la entrada del teclado.


            // Redirigir System.out a un stream para capturar lo que imprime
            ByteArrayOutputStream outputCapturado = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputCapturado));

            // Ejecutar el lanzador
            Lanzador.lanzadorr();

            // Restaurar entradas/salidas
            System.setIn(originalIn);
            System.setOut(originalOut);

            // Mostrar el resultado en una nueva ventana
            String resultado = outputCapturado.toString();

            TextArea areaResultado = new TextArea(resultado);
            areaResultado.setWrapText(true);
            areaResultado.setEditable(false);

            VBox layout = new VBox(areaResultado);
            Scene escena = new Scene(layout, 600, 400);

            Stage ventana = new Stage();
            ventana.setTitle("Resultado de ejecución");
            ventana.setScene(escena);
            ventana.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
