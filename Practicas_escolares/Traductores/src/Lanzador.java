import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Lanzador {


    public static void lanzadorr() throws Exception {
        // Crear un flujo de entrada a partir de la entrada estándar (teclado)
        ANTLRInputStream input = new ANTLRInputStream(System.in);

        // Crear una instancia del lexer generado por ANTLR
        RuLexer lexer = new RuLexer(input);

        // Crear un flujo de tokens a partir del lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Crear una instancia del parser generado por ANTLR
        RuParser parser = new RuParser(tokens);

        // Llamar a la regla inicial del parser (programa) para generar el árbol de análisis
        ParseTree arbol = parser.programa();

        // Crear una instancia del Visitor personalizado
        MiVisitador visitor = new MiVisitador();

        // Visitar el árbol y obtener el resultado de la evaluación
        Object resultado = visitor.visit(arbol);

        // Imprimir el resultado en consola
        //System.out.println("Resultado: " + resultado);
    }
}
