public class CodigoBueno {
    public static void main(String[] args) {
        // Array para almacenar 100 números enteros pares
        int[] arrayPares = new int[100];
        
        try {
            System.out.println("Iniciando la inicialización del array...");
            
            // Bucle que puede causar ArrayIndexOutOfBoundsException
            for(int i = 0; i <= arrayPares.length; i++) { // <= para forzar el error
                arrayPares[i] = 2 * i;
                System.out.println("arrayPares[" + i + "] = " + arrayPares[i]);
            }
            
            System.out.println("Inicialización completada con éxito.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("\nERROR: Se ha intentado acceder a una posición fuera de los límites del array.");
            System.err.println("Mensaje de error: " + e.getMessage());
            System.err.println("El tamaño del array es " + arrayPares.length + 
                             " y se ha intentado acceder a la posición " + 
                             e.getMessage().replace("Index ", ""));
            
        } catch (Exception e) {
            System.err.println("\nERROR inesperado: " + e.getClass().getSimpleName());
            System.err.println("Mensaje: " + e.getMessage());
            
        } finally {
            System.out.println("\nEjecución finalizada.");
        }
    }
}