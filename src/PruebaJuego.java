import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaJuego 
{
    public static void main( String[] args )
    {
        boolean seAcabo = false, turno = true;
        Scanner entrada = new Scanner( System.in );
        int modo;
        String nombre, decision;
        char simbolo;
        Jugador jugador1 = null, jugador2 = null, ganador = null;
        
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
                try 
                {
                    System.out.print("Ingrese modo de juego (1 o 2): ");
                    modo = entrada.nextInt();    
                } 
                catch (InputMismatchException e)
                { 
                    System.out.println("Valor inválido.");
                    modo = 0;
                }
                entrada.nextLine();
            } while ( modo != 1 && modo != 2 );
            
            System.out.println();
            System.out.print("Elige el nombre del jugador 1: ");
            nombre = entrada.nextLine();
            
            
            do 
            {
                System.out.print("Elige el símbolo del jugador 1 ('x' o 'o'): ");
                simbolo = entrada.nextLine().charAt(0);
                simbolo = Character.toLowerCase(simbolo);    
            
            } while ( simbolo != 'x' && simbolo != 'o');
            
            jugador1 = new JugadorHumano(nombre, simbolo);
            System.out.println();
            
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
            
            nuevoJuego.mostrarMenu();
            nuevoJuego.mostrarTableros();


            while (!nuevoJuego.esVictoria()) 
            {

                if (turno)
                {
                    nuevoJuego.procesarTurno(jugador1, nuevoJuego);
                }
                else
                {
                    nuevoJuego.procesarTurno(jugador2, nuevoJuego);
                }
                
                turno = !turno;
                System.out.print("\033c"); // Limpiamos la terminal
                nuevoJuego.mostrarMenu();
                nuevoJuego.mostrarTableros();
                if (nuevoJuego.esVictoria())
                {
                    ganador = !turno ? jugador1 : jugador2;            
                    System.out.printf("Victoria para %s!!!\n", ganador.obtenerNombre());
                    break;
                }
                else if ( nuevoJuego.esEmpate() )
                {
                    System.out.println("Empate");
                    break;
                }
                    
            }
            
            do
            {
                System.out.println("Quieres volver a jugar? (sí / no): ");
                decision = entrada.nextLine().toLowerCase();
            }while (!decision.equals("si") && !decision.equals("sí") && !decision.equals("no"));
            
            if (decision.equals("si")  || decision.equals("sí") )
            {
                seAcabo = false;
                turno = !turno;
            }
            else
            {
                seAcabo = true;
                System.out.println("Gracias por jugar!.");
            }
        }
    }
    
}
