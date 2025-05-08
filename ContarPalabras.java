import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContarPalabras {

    public static void main(String[] args) {
        // Configuración de archivos
        String archivoEntrada = "entrada.txt";
        String archivoSalida = "salida.txt";
        
        // Contador de palabras
        int contadorPalabras = contarPalabras(archivoEntrada);
        
        // Escribir resultado
        escribirResultado(archivoSalida, archivoEntrada, contadorPalabras);
    }

    /**
     * Cuenta las palabras en un archivo de texto
     * @param nombreArchivo Ruta del archivo a leer
     * @return Número de palabras contadas
     */
    private static int contarPalabras(String nombreArchivo) {
        int contador = 0;
        
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            System.out.println("Procesando archivo " + nombreArchivo + "...");
            
            // Configurar delimitadores (espacios, saltos de línea, tabs)
            scanner.useDelimiter("\\s+");
            
            while (scanner.hasNext()) {
                scanner.next(); // Avanzar a la siguiente palabra
                contador++;
            }
            
            System.out.println("Palabras contadas: " + contador);
            
        } catch (IOException e) {
            manejarErrorLectura(e, nombreArchivo);
            System.exit(1); // Salir con código de error
        }
        
        return contador;
    }

    /**
     * Escribe el resultado en el archivo de salida
     * @param nombreArchivo Ruta del archivo de salida
     * @param archivoOrigen Nombre del archivo analizado
     * @param totalPalabras Cantidad de palabras a escribir
     */
    private static void escribirResultado(String nombreArchivo, String archivoOrigen, int totalPalabras) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            String resultado = String.format(
                "El archivo '%s' contiene %d palabras.", 
                archivoOrigen, 
                totalPalabras
            );
            
            writer.write(resultado);
            System.out.println("Resultado guardado en: " + nombreArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo de salida:");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Maneja los errores de lectura del archivo
     * @param ex Excepción producida
     * @param nombreArchivo Nombre del archivo que causó el error
     */
    private static void manejarErrorLectura(IOException ex, String nombreArchivo) {
        System.err.println("\n--- ERROR ---");
        
        if (ex instanceof java.io.FileNotFoundException) {
            System.err.println("No se encontró el archivo: " + nombreArchivo);
            System.err.println("Por favor, asegúrese de que el archivo existe en:");
            System.err.println(new File(nombreArchivo).getAbsolutePath());
        } else {
            System.err.println("Ocurrió un error al leer el archivo:");
            System.err.println(ex.getMessage());
        }
        
        System.err.println("\nSolución:");
        System.err.println("1. Cree un archivo llamado 'entrada.txt' en la misma carpeta");
        System.err.println("2. Asegúrese de que el programa tenga permisos de lectura");
    }
}