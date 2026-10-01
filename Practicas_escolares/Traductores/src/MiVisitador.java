//Importamos las bibliotecas necesarias
import java.io.*;
import java.util.*;
import java.math.*;

public class MiVisitador extends RuBaseVisitor<Object>{

    //colocamos la tabla de simbolos
    //Tabla de simbolos
    private Map<String, Object> variables = new HashMap<>();
    //map en java es una estructura de datos que permite almacenar pares de datos.

    //Hacemos que se visite la regla principal y se evalue
    public Object visitPrograma(RuParser.ProgramaContext ctx) {
        //El visitador evslua el bloque y retorna su valor
        return visit(ctx.bloque()); //regresa el contecto evaluado
    }

    //Se visita el nodo con el contexto Bloque y se evalua
    public Object visitBloque(RuParser.BloqueContext ctx){
        Object resultado = 0.0; // varible de apoyo resultado
        for(RuParser.SentenciaContext sentencia : ctx.sentencia()){ //se evalua cada una de las sentencias dentro del bloque
            resultado = visit(sentencia); //Se evalua la instruccion acutual
        }
        return resultado; //Devuelve la evuluacion de l ainstruccion
    }

    //Se visita el nodo con el contexto de Sentencia  y se evalua
    public Object visitSentencia(RuParser.SentenciaContext ctx) {
        if(ctx.asignacion() != null){ // compara si el nodo de asignacion es diferente de null
            return visit(ctx.asignacion()); // si es asi regresa el contenido del nodo
        }else if(ctx.sentencia_if() != null){   //Compara si el nodo de sentencia if es diferente de null
            return visit(ctx.sentencia_if());   // regresa el contenido de nodo evaluado
        }else if(ctx.sentencia_while() != null){    //compara si el nodo sentencia while es diferente de null
            return visit(ctx.sentencia_while());    //regresa el contenido del nodo evaluado
        }else if(ctx.log() != null){    // Commpara si el nodno  log es diferente de null
            return visit(ctx.log());    //regresa el contenido del nodo evaluado
        }else if(ctx.imprimir() != null){   //Compara el nodo imprimir si es diferente de null
            return visit(ctx.imprimir());   // regresa el contenido del nodo evaluado
        }
        return null; // retorna null si no hay coincidencia
    }


        //Visitamos el node de Asignacion
    public Object visitAsignacion(RuParser.AsignacionContext ctx) {
        String nombre = ctx.ID().getText(); //Obtenemos el texto del token ID y lo guardamos en la variable nombre
        Object valor = visit(ctx.expr()); //Evaluamos la expresion  y obtwnemos el resultado de la evalacion


        variables.put(nombre, valor);
        // variables es el nombre del mapa
        // .put sirve para insertar un nuevo valor o acutalizarlo

        return valor; // regresa el valor
    }


    //se visita el nodo if y se evalua
    public Object visitSentencia_if(RuParser.Sentencia_ifContext ctx) {

        //Evaluamos las condicionales
        for (RuParser.Bloque_condicionalContext bloque : ctx.bloque_condicional()) { //devuelve una lista de todas las condiciones del if
            Object cond = visit(bloque.expr()); // Evaluamos el tokem expr y obtnemos su resultado guardandolo en la variable cond
            if (cond != null && !cond.equals(0.0)) { // se evalua la condicion de la expresion si es distinta de 0
                return visit(bloque.bloque_de_sentencia()); // se ejecuta el bloque de sentencia si la condicion es verdadera
            }
        }

        //Verificamos si existe un else al final
        if (ctx.bloque_de_sentencia() != null) {    //Realizamos la comparacion de la sentencia
            return visit(ctx.bloque_de_sentencia()); //Se regresa la sentencia evaluada del else
        }

        return null;
    }

    //Se visita el nodo Bloque condicional
    public Object visitBloque_condicional(RuParser.Bloque_condicionalContext ctx) {
        Object condicion = visit(ctx.expr()); //evaluamos la expresion de los '('')'
        if(condicion != null && !condicion.equals(0.0)){ // si la expresion evaluada es verdadera se ejecuta
            return visit(ctx.bloque_de_sentencia()); // se ejecuta la tencencias consecuente de la expresion
        }
        return null;

    }

    //Se visita el bloque de sentencia
    public Object visitBloque_de_sentencia(RuParser.Bloque_de_sentenciaContext ctx) {
        if(ctx.bloque() != null) { // se obtiene el valor del  bloque y compara que sea diferente de null
            return visit(ctx.bloque()); //Evalua el bloque y lo devuelve
        }else{
            return visit(ctx.sentencia()); // si no es un bloque evalua y regresa la sentencia
        }
    }

    //se visira el nodo sentancia while
    public Object visitSentencia_while(RuParser.Sentencia_whileContext ctx) {
        while (true) {
            // Evaluar la condición del while (expr)
            Object valorwhile = visit(ctx.expr());

            if (valorwhile == null || valorwhile.equals(0.0)) {
                break;
            }

            // Ejecutar el bloque de sentencias dentro del while
            visit(ctx.bloque_de_sentencia());
        }
        return null;
    }


    //Se visita el nodo log
    public Object visitLog(RuParser.LogContext ctx) {
        Object val = visit(ctx.expr()); //evaluamos y obtenemos el valor del token
        if(val instanceof Double) { //verifica que el valor comparado sea de tipo Doubel
            return Math.log((Double) val); // se evalua el nodo y regresa la fundion log
        }
        return 0.0;
    }

    //Se visita el nodo Imprimir
    public Object visitImprimir(RuParser.ImprimirContext ctx) {
        Object imprime = visit(ctx.expr()); //se evalua el valor del nodo y se guarda en la variable imprime
        System.out.println(imprime);   // se imprime el valor guardado
        return imprime;    // regresa el valor

    }

    //Se visita el nodo MenonosunarioEXpr
    public Object visitMenosUnarioExpr(RuParser.MenosUnarioExprContext ctx) {
        Object valornegativo = visit(ctx.expr()); // se evalua el nodo para optener el valor y guardalo en la variable valor negativo
        if(valornegativo instanceof Double) { // verifica que el valor comparado sea de tipo Double
            return - (Double) valornegativo; // regresa el valor multiplicado por -1
        }
        return 0.0;
    }

    //Se visita el nodo notexpr
    public Object visitNotExpr(RuParser.NotExprContext ctx) {
        Object valornegativo = visit(ctx.expr()); // se evalua el nodo y se guarda en la variable valornegativo
        boolean valor = !(valornegativo != null && !valornegativo.equals(0.0));
        //valornegativo != null: verifica que la variable no sea null
        //!valornegativo.equals(0.0): si valornegativo es diferente de 0.0.
        //true si valornegativo es null o vale exactamente 0.0
        //false si valornegativo es un número distinto de 0.0.

        if(valor){ // si el valor es true
            return 1.0; // regresa 1
        }else{
            return 0.0; // si es falso regresa 0
        }
    }

    public Object visitMultiplicacionExpr(RuParser.MultiplicacionExprContext ctx) //Se visita el nodo multiplicacionExpr
    {String OP =  ctx.op.getText(); //Optenemos el valor del operador (* / %)
        Object izquierda =  visit(ctx.expr(0)); // Evaluamos el primer operando (izquierdo)
        Object derecho =  visit(ctx.expr(1));   // Evaluamos el segundo operando (derecho)

        if (!(izquierda instanceof Double) || !(derecho instanceof Double)) { //comparamos si alguna de las 2 no es un valor de tipo double ejecuta la acciom
            return 0.0; // si alguno no es Double, retornamos 0.0 como error
        }

        switch (OP) {
            case "*": // caso multiplicación
                return (Double) izquierda * (Double) derecho;
            case "/": // caso división
                return (Double) izquierda / (Double) derecho;
            case "%": // caso módulo
                // Convertimos a enteros usando Math.floor para evitar errores por decimales
                int izqEntero = (int) Math.floor((Double) izquierda);
                int derEntero = (int) Math.floor((Double) derecho);
                return (double)(izqEntero % derEntero); // realizamos el módulo entre enteros y lo devolvemos como Double
            default:
                return 0.0; // operador no reconocido
        }
    }


    //visita el nodo atomExpr
    public Object visitAtomExpr(RuParser.AtomExprContext ctx) {
        return visit(ctx.atomo()); // evalua el nodo atomo y regresa su valor
    }

    //visitamos el nodo orexpr
    public Object visitOrExpr(RuParser.OrExprContext ctx) {
        //obtenemos los valores de la expresion
        Object izquierda = visit(ctx.expr(0)); // valor izquierdo
        Object derecho = visit(ctx.expr(1));    // valor derecho

        //Convertimos los Objetos de tipo Double en Booleanos
        boolean valorIzqbol = izquierda != null && !izquierda.equals(0.0); // valor boleano izquierdo
        boolean valorDerbol = derecho != null && !derecho.equals(0.0);   // valor bolenao derecho

        //Verificamos que los valores sean diferentes de null derecho != null && izquierda != null
        // si izquierda o derecha son igual a 0.0 es verdad si no es false y al final se niegan

        //operacion para obtener la expresion OR
        boolean resultado = valorIzqbol || valorDerbol;

        // para saber si es verdad o mentira
        if (resultado){// compara si es verdad
            return 1.0; // retorna 1
        }else{ // de lo contrario
            return 0.0; //retorna 0
        }
    }

    //visitamos el nodo powexpr
    public Object visitPowExpr(RuParser.PowExprContext ctx) {
        //obtenemos los valores derecho y izquierdo
        Object izquierda = visit(ctx.expr(0));
        Object derecho = visit(ctx.expr(1));

        if (!(izquierda instanceof Double) || !(derecho instanceof Double)) {//comparamos si alguna de las 2 no es un valor de tipo double ejecuta la acciom
            return 0.0; // si alguna no es un Double regresa error
        }
        //Retronamos la potencia izquierda ^ derecha
        return Math.pow((Double) izquierda, (Double) derecho);
    }

    //visitamos el nodo igualdadexpr
    //Se visita el nodo igualdadExpr
    public Object visitIgualdadExpr(RuParser.IgualdadExprContext ctx) {
        String OP = ctx.op.getText(); // Obtenemos el texto del operador (== o !=)
        Object izquierda = visit(ctx.expr(0)); // Evaluamos el primer operando
        Object derecha = visit(ctx.expr(1));  // Evaluamos el segundo operando

        if (!(izquierda instanceof Double) || !(derecha instanceof Double)) { //comparamos si alguna de las 2 no es un valor de tipo double ejecuta la acciom
            return 0.0; // Si alguno no es Double, se considera error y se retorna 0.0
        }

        double valIzq = ((Double) izquierda).doubleValue(); // Convertimos a double
        double valDer = ((Double) derecha).doubleValue();   // Convertimos a double

        switch (OP) {
            case "==": // Comparación de igualdad
                if (valIzq == valDer) {
                    return 1.0; // Verdadero
                } else {
                    return 0.0; // Falso
                }
            case "!=": // Comparación de desigualdad
                if (valIzq != valDer) {
                    return 1.0; // Verdadero
                } else {
                    return 0.0; // Falso
                }
            default:
                return 0.0; // Si no reconoce el operador
        }
    }


    //visitamos el nodo relacional expr
    public Object visitRelacionalExpr(RuParser.RelacionalExprContext ctx) {
        //Obtenemos el contenido del token OP
        String OP =  ctx.op.getText();

        //optenemos los valores del lado derecho e izquierdo
        Object izquierda =  visit(ctx.expr(0));
        Object derecho =  visit(ctx.expr(1));

        if (!(izquierda instanceof Double) || !(derecho instanceof Double)) {//comparamos si alguna de las 2 no es un valor de tipo double ejecuta la acciom
            return 0.0; // si alguna no es un Double regresa error
        }

        //Verificamos que operador tenenmos
        switch (OP) {
            case "<": // caso menor que
                if(((Double) izquierda) < ((Double) derecho)){ //Comparamos las expresiones hacemos un casting para convertirlos a double
                    return 1.0; //si es verdad
                }else{ // de lo contrario
                    return 0.0; //falso
                }
            case ">": // mayor que
                if(((Double) izquierda) > ((Double) derecho)){//comparamos las expresiones y se hace un casting para convertirlo a double
                    return 1.0; //si es verdad
                }else{// si no
                    return 0.0; // falso
                }
            case "<=": // caso menor o igual que
                if(((Double) izquierda) <= ((Double) derecho)){   // se compara las expresiones y se castea para convertirlo a double
                    return 1.0; // si es verdad
                }else{ // si no
                    return 0.0; // falso
                }
            case ">=": // caso mayor o igual que
                if (((Double) izquierda) >= ((Double) derecho)) { // comparamos las expresiones se castea para convertirlo a double
                    return 1.0; // si es verdad
                }else{//ai no
                    return 0.0; // falso
                }
            default:
                return 0.0; // si no se reconoce ningun token
        }
    }

    //visitamos el nodo aditivaexpr
    public Object visitAditivaExpr(RuParser.AditivaExprContext ctx) {
        //Obtenemos el contenido del token
        String OP =  ctx.op.getText();

        //Ovtenemos los valores de los nodos
        Object izquierda =  visit(ctx.expr(0));
        Object derecho =  visit(ctx.expr(1));

        if (!(izquierda instanceof Double) || !(derecho instanceof Double)) {//comparamos si alguna de las 2 no es un valor de tipo double ejecuta la acciom
            return 0.0; // si alguna no es un Double regresa error

        }

        //Evaluamos
        switch (OP) {
            case "+": // case suma
                return (Double) izquierda + (Double) derecho; //Suma los valores
            case  "-":  //Caso resta
                return (Double) izquierda - (Double) derecho; //resta los valores
            default:
                return 0.0; // si no reconoce los valores
        }

    }

    //Visitamos el nodo Andexpr
    public Object visitAndExpr(RuParser.AndExprContext ctx) {
        //obtenemos los valores de la expresion
        Object izquierda = visit(ctx.expr(0)); // valor izquierdo
        Object derecho = visit(ctx.expr(1));    // valor derecho

        boolean valorIzqbol = izquierda != null && !izquierda.equals(0.0); // valor boleano izquierdo
        boolean valorDerbol = derecho != null && !derecho.equals(0.0);   // valor bolenao derecho
        //Verificamos que los valores sean diferentes de null derecho != null && izquierda != null
        // si izquierda o derecha son igual a 0.0 es verdad si no es false y al final se niegan

        //operacion para obtener la expresion OR
        boolean resultado = valorIzqbol && valorDerbol;

        // para saber si es verdad o mentira
        if (resultado){// compara si es verdad
            return 1.0; // retorna 1
        }else{ // de lo contrario
            return 0.0; //retorna 0
        }
    }

    //visitamos el nodo Parexpr
    public Object visitParExpr(RuParser.ParExprContext ctx) {
        return visit(ctx.expr()); //evalua el nodo y regresa su valor
    }

    //visitamos el nodo numberatm
    public Object visitNumberAtom(RuParser.NumberAtomContext ctx) {

        String tipado = ctx.getText(); //Optenemos el valor del token lo guardamos en la variable tipado
        Double valortipado = Double.valueOf(tipado); // convertimos los valores 42 o 3.14 a valores Doubles 42.0 o 3.14

        return valortipado; // Regresamos el valor convertido en Double
    }

    //Visitamos el nodo Booleanatom
    public Object visitBooleanAtom(RuParser.BooleanAtomContext ctx) {
        String boleanos = ctx.getText(); // obtenemos el texto dentro del token
        if(boleanos.equals("true")){ //Comparamos si boolenaos igual a true
            return 1.0; // regresa 1
        } else { // si no regresa 0
            return 0.0;
        }
    }

    //Visitamos el nodo Idatom
    public Object visitIdAtom(RuParser.IdAtomContext ctx) {
        String nombre = ctx.ID().getText();
        //ctx.ID = Este método accede al token ID que fue reconocido en la gramática.
        //get.Textx = getText() obtiene el texto real del token.

        //pregunta si hay una variable que se ya existente
        if (!variables.containsKey(nombre)) { // variable.containskey Verifica si el mapa ya contiene una variable con el nombre dado.
            return 0.0;
        }

        return variables.get(nombre); // Regresa el nombre de la variable
    }

        //visitamos el nodo String
    public Object visitStringAtom(RuParser.StringAtomContext ctx) {
        String texto = ctx.getText(); //Obtenemos el texto del token
        return texto.substring(1, texto.length()-1); // regresa el string sin comillas
    }

    public Object visitNilAtom(RuParser.NilAtomContext ctx) {
        return null;
    }

}
