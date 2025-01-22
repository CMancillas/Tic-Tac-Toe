/*
 *      - Clase que representa a un jugador controlado por la computadora.
 *      - Extiende la clase abstracta Jugador y genera movimientos.
 */
import java.util.Random;

public class JugadorComputadora extends Jugador 
{

    // Constructor que inicializa a un jugador de computadora
    public JugadorComputadora( char simbolo )
    {
        super( simbolo ); // Llama al constructor de la clase padre para asignar el simbolo
    } // Fin del constructor 

    // Obtiene el movimiento del jugador de computadora
    @Override
    public int[] obtenerMovimiento()
    {   
        // Generador de numeros aleatorios
        Random numerosAleatorios = new Random();

        int movimiento;
        movimiento = 1 + numerosAleatorios.nextInt( RANGO_MAX ); // numero aleatorio entre 1 y 9

        // Verifica que el movimiento generado este dentro del rango
        if ( movimiento < RANGO_MIN || movimiento > RANGO_MAX )
            throw new IllegalArgumentException( "Movimiento fuera de rango: " + movimiento );
            
        return obtenerCasilla( movimiento );
    } // Fin del metodo obtenerMovimiento

    // Convierte un numero de movimiento ( 1 - 9 ) al numero de casilla correspondiente
    @Override
    protected int[] obtenerCasilla( int movimiento )
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
                throw new IllegalArgumentException( "Movimiento fuera de rango: " + movimiento );                    
        }
    } // Fin del metodo obtenerCasilla
    
    @Override
    public String toString()
    {
        return String.format( "Jugador: CPU %s ", super.toString() );
    } // Fin del metodo toString
} // Fin de la clase JugadorComputadora
