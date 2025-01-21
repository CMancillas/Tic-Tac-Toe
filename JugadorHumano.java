/*
 *      - Clase que representa un Jugador humano en el juego.
 *      - Extiende de la clase abstracta Jugador.
 */
import java.util.Scanner;

public class JugadorHumano extends Jugador 
{
    // Nombre del jugador humano
    private String nombre;
    
    public JugadorHumano( String nombre, char simbolo )
    {
        super( simbolo );
        this.nombre = nombre;
    }

    public void establecerNombre( String nombre )
    {
        this.nombre = nombre;
    } // fin del metodo establecerNombre

    public String obtenerNombre()
    {
        return nombre;
    } // fin del metodo obtenerNombre
    
    @Override
    public int[] obtenerMovimiento()
    {
        Scanner entrada = new Scanner( System.in );
        int movimiento;
        do
        {
            System.out.printf( "En que casilla gustarias poner tu simbolo? (%d-%d)", RANGO_MIN, RANGO_MAX );        
            movimiento = entrada.nextInt();
            entrada.close(); // cerramos entrada para evitar fugas de memoria 
        } while( movimiento < RANGO_MIN || movimiento > RANGO_MAX );
        
        return obtenerCasilla( movimiento );
    }
    
    @Override
    public int[] obtenerCasilla( int movimiento )
    {
        switch ( movimiento )
        {
            case 1:
                return new int[]{ 0, 0 };
            case 2:
                return new int[]{ 0, 1 };
            case 3:
                return new int[]{ 0, 2 };
            case 4:
                return new int[]{ 1, 0 };
            case 5:
                return new int[]{ 1, 1 };
            case 6:
                return new int[]{ 1, 2 };
            case 7:
                return new int[]{ 2, 0 };
            case 8:
                return new int[]{ 2, 1 };
            case 9:
                return new int[]{ 2, 2 };   
            default:
                throw new IllegalArgumentException( "Movimiento fuera de rango: " + movimiento ); // no deberia occurir, ya que validamos antes en obtenerMovimiento                    
        }
    }

    @Override
    public String toString()
    {
        return String.format( "Jugador: %s + %s",
             obtenerNombre(), super.toString() );
    }
}
