import java.util.Scanner;

public class PruebaJuego 
{
    public static void main( String[] args )
    {
        boolean seAcabo = false, turno = true;
        Scanner entrada = new Scanner( System.in );
        int modo;
        String nombre;
        char simbolo;
        Jugador jugador1 = null, jugador2 = null;
        
        while ( !seAcabo )
        {
            Juego nuevoJuego = new Juego();
            nuevoJuego.mostrarMenu();
                 
            System.out.print(
                "1. Modo de juego: \n" +
                "   [1] Un jugador (contra CPU)\n" +
                "   [2] Dos jugadores\n"
            );
            
            System.out.println();
            do
            {
                System.out.print("Ingrese modo de juego (1 o 2): ");
                modo = entrada.nextInt();
                entrada.nextLine();

            } while(modo != 1 && modo != 2);
            

            System.out.print("Elige el nombre del jugador 1: ");
            nombre = entrada.nextLine();
            System.out.println();
            
            do 
            {
                System.out.println("Elige el símbolo del jugador 1 ('x' o 'o'): ");
                simbolo = entrada.nextLine().charAt(0);
                simbolo = Character.toLowerCase(simbolo);    
            
            } while ( simbolo != 'x' && simbolo != 'o');
            
            jugador1 = new JugadorHumano(nombre, simbolo);
            
            if ( modo == 1 )
            {
                nombre = "CPU";
                if ( simbolo == 'x')
                    jugador2 = new JugadorComputadora('o');
                else
                    jugador2 = new JugadorComputadora('x');
            }
            else
            {    
                System.out.print("Elige el nombre del jugador 2: ");
                nombre = entrada.nextLine();
                System.out.println();
                
                if ( simbolo == 'x')
                    jugador2 = new JugadorHumano(nombre, 'o');
                else
                    jugador2 = new JugadorHumano(nombre,'x');
            }

            System.out.print("\033c"); // Limpiamos la terminal
            
            nuevoJuego.mostrarTableros();
            int posicion;

            while (!nuevoJuego.esVictoria()) 
            {
                if ( turno )
                {
                    System.out.printf("Turno para %s\n", ((JugadorHumano) jugador1).obtenerNombre());
                    System.out.print("Escoge tu posición: ");
                    posicion = entrada.nextInt();
                    entrada.nextLine();
                    nuevoJuego.rellenarTablero(jugador1.obtenerCasilla(posicion), jugador1.obtenerSimbolo() );
                } 
                nuevoJuego.mostrarTableros();
                System.out.print("\033c"); // Limpiamos la terminal

                System.out.printf("Turno para %s\n", ((JugadorHumano) jugador2).obtenerNombre());
                System.out.print("Escoge tu posición: ");
                posicion = entrada.nextInt();
                entrada.nextLine();
                nuevoJuego.rellenarTablero(jugador2.obtenerCasilla(posicion), jugador2.obtenerSimbolo() );
                nuevoJuego.mostrarTableros();
                System.out.print("\033c"); // Limpiamos la terminal
            }
            

            System.out.println("Es victoria!");
            seAcabo = true;

        }
    }
    
}
