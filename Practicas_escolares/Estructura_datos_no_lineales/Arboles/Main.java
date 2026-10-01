import java.util.*;
import java.io.*;
 
public class Main
{
	public static void main(String[] args) {
	
	     Scanner scanner = new Scanner(System.in);
        
        ArbolExpr expPrueba = new ArbolExpr();    // Expresión a probar
        
        
        System.out.println( );
        System.out.print("Ingresa una expresión en prefijo : ");
        String exprStr = scanner.nextLine();
        StringTokenizer tokens = new StringTokenizer(exprStr,"0123456789+-*/",true);

//         Esta sección es para aprender a usar el objeto token. Una vez revisada se debe comentar nuevamente
//   
//        double valToken; 
//        while (tokens.hasMoreTokens()){
//            char auxToken = tokens.nextToken().charAt(0); // leer un carácter de los tokens
//            System.out.println(" token: " + auxToken);
//            
////             usar la linea para convertir el token a double
//            valToken = (double)Character.getNumericValue(auxToken);
//            System.out.println(" valToken: " + valToken);
//        }        
     
       
        expPrueba.construye( tokens );  // Construir un árbol de expresión a partir de los tokens
        expPrueba.muestraEstructura( );
        
        
        expPrueba.expresion( );   // Imprime la expresión en forma infija
        System.out.println(" = " + expPrueba.evaluar( ));
	
	
	}
}