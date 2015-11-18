/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author salvador ariel
 */
public class ProyectoFinal {
    
    
    
    public static void reconocedorDeFunción(String metodos) {
        ÁrbolBinarioB miArbol = new ÁrbolBinarioB();
        int in;
        int ul;
        String [] cadenaDeMetodos = metodos.split("&");
        boolean esIgual = false;
        String parametros;
        String auxiliar;
        String[] parametrosFinales;
        
        String[] palabrasClave = {
            "insertar", "elimina", 
            "buscaHIjoDer", 
            "buscaHijoIzq", 
            "imprimePre", 
            "imprimePos", 
            "imprimeIno"
        };

     for (String funciones : cadenaDeMetodos){
        if (funciones.contains("(") && funciones.contains(")")) {
            in = funciones.indexOf('(');
            String operación = funciones.substring(0, in);
            for (String n : palabrasClave) {
                if (operación.equalsIgnoreCase(n)) {
                    esIgual = true;
                    break;
                }
            }
        }
        if (esIgual == true) {
            in = funciones.indexOf('(');
            ul = funciones.indexOf(')');
            auxiliar = funciones.substring(in + 1, ul);
            
            if (!auxiliar.contains(",")) {
                parametros = auxiliar;
                if (funciones.contains("insertar")) {
                    miArbol.insertar(Integer.parseInt(parametros));
                } else if (funciones.contains("elimina")) {
                    miArbol.elimina(Integer.parseInt(parametros));
                } else if (funciones.contains("buscaHijoDer")) {
                    miArbol.buscaHijoDer(Integer.parseInt(parametros));
                } else if (funciones.contains("buscaHijoIzq")) {
                    miArbol.buscaHijoIzq(Integer.parseInt(parametros));
                }
            } else {
                parametros = auxiliar;
                
                parametrosFinales = parametros.split(",");

                    for (String parametrosFinale : parametrosFinales) {
                        if (funciones.contains("insertar")) {
                            miArbol.insertar(Integer.parseInt(parametrosFinale));
                        } else if (funciones.contains("elimina")) {
                            miArbol.elimina(Integer.parseInt(parametrosFinale));
                        }
                    }
            }
            if (funciones.equals("imprimePre()")) {
                miArbol.imprimePre();
            }
            if (funciones.equals("imprimePos()")) {
                miArbol.imprimePos();
            }
            if (funciones.equals("imprimeIno()")) {
                miArbol.imprimeIno();
            }
        }
     }
    }

    public static void main(String[] args) {
        int indicePrincipal = 0;
        try {
        reconocedorDeFunción(args[indicePrincipal]);
        }catch(Exception error){
        System.out.println("el formato de la cadena de funciones es incorrecto");
        }
    }
