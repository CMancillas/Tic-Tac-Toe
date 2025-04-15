/*
 *      - Clase que representa un Jugador humano en el juego.
 *      - Extiende de la clase abstracta Jugador.
 */
import java.util.Scanner;

public class JugadorHumano extends Jugador 
{
    // Nombre del jugador humano
    private String nombre;
    
    // Cosntructor de JugadorHumano
    public JugadorHumano( String nombre, char simbolo )
    {
        super( simbolo ); // Llama al constructor de la clase padre para asignar el simbolo
        this.nombre = nombre; // Asigna el nombre al jugador
    } // fin del constructor

    public void establecerNombre( String nombre )
    {
        this.nombre = nombre; // Actualiza el atributo nombre
    } // fin del metodo establecerNombre

    public String obtenerNombre()
    {
        return nombre;
    } // fin del metodo obtenerNombre
    
    // Obtiene el movimiento del jugador humano
    @Override
    public int[] obtenerMovimiento()
    {
        Scanner entrada = new Scanner( System.in );
        int movimiento;

        // Bucle para asegurar de que el movimiento ingresado esta en el rango valido
        do
        {
            System.out.printf( "Escoge tu posición (%d-%d): ", RANGO_MIN, RANGO_MAX );        
            movimiento = entrada.nextInt();
            entrada.nextLine();
            //entrada.close(); // Cerramos entrada para evitar fugas de memoria 
        } while( movimiento < RANGO_MIN || movimiento > RANGO_MAX ); // Fin del do - while
        
        return obtenerCasilla( movimiento );
    } // fin del metodo obtenerMovimiento
    
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
                throw new IllegalArgumentException( "Movimiento fuera de rango: " + movimiento ); // no deberia occurir, ya que validamos antes en obtenerMovimiento                    
        } // Fin del switch
    } // Fin del metodo obtenerCasilla

    @Override
    public String toString()
    {
        return String.format( "Jugador: %s + %s\n",
             obtenerNombre(), super.toString() );
    } // Fin del metodo toString
} // Fin de la clase JugadorHumano
