import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class practica1 {
	
	public void leer_archivo(String archivo){
		String linea;
		File f = new File(archivo);
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNext()) {
				linea = s.nextLine();
				analizar_linea(linea);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  String is_etiqueta(String cadena){
		String error="";
	    if(cadena.length()<8){
				if(cadena.matches("[a-zA-Z][[a-zA-Z]_0-9]*")==false){
					error="\nError: la etiqueta debe de iniciar con letra";
				}
		}else{
			error="\nError: la longitud máxima de una etiqueta es de ocho caracteres.";
		}
		return error;
	}
	
	public  String etiqueta(String cadena){
		String error="";
	    if(is_etiqueta(cadena).length()>0){
	    	error=is_etiqueta(cadena);
	    }
		return cadena+" "+error;
	}
	
	public String codop(String cadena){
		String error="";
		if(cadena.length()>0){
		    if(cadena.length()<=5){
				  if(cadena.matches("[a-zA-Z][a-zA-Z_.]*")==false){
					  error="\nError: los códigos de operación deben de iniciar con letra.";
				  }
			}else{
				error="\nError: Su longitud es de 5 caracteres maximo.";
			}
		}else{
			error="\nError: siempre debe de haber un código de operación";
		}
	    return "CODOP:"+cadena.toUpperCase()+" "+error;
	}
	
	public String operando(String[] arreglo){
		String cadena="";
	    if(arreglo.length==3){
	    	    cadena=arreglo[2];
		    }else{
		    	cadena="null";
		    }
		return "OPERANDO:"+cadena.toUpperCase();
	}
	
	
	
	public void analizar_linea(String linea){
       //Comentarios
		if(linea.startsWith(";") && linea.length()<80){
			System.out.println("COMENTARIO:"+linea);
		}else{
			String[] element = linea.split("\\s+"); 
            //Verificar que no inicien con espacio o tabulador
			if(linea.startsWith(" ")==false && linea.startsWith("	")==false){
				
				//Linea tipo etiqueta, codop, operando y
				//Linea tipo etiqueta, codop
				
				//ETIQUETA
			    System.out.println("\nETIQUETA:"+etiqueta(element[0]));
			    //CODOPS 
			    System.out.println(""+codop(element[1]));
				//OPERANDOS 
				System.out.println(""+operando(element));
			}else{
				//Linea tipo codop, operando y
				//Linea tipo codop
				
				//ETIQUETA 
				System.out.println("\nETIQUETA: null");
			    //CODOPS 
				System.out.println(""+codop(element[1]));
				//OPERANDOS 
				System.out.println(""+operando(element));

			}
		}
	}

}
