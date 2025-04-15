/* 
*    - Clase abstracta que representa un Jugador en el Juego
*    - Proporciona una base comun para jugadores humanos y de computadora.
*/ 
public abstract class Jugador
{
    // Atributo que almacena el simbolo del jugador, como 'X' o 'O' 
    private char simbolo;

    // Constantes que definen el limite del tablero 
    protected static final int RANGO_MIN = 1;
    protected static final int RANGO_MAX = 9;

    // constructor de Jugador
    public Jugador( char simbolo )
    {
        this.simbolo = simbolo; // se le asigna el simbolo a Jugador
    } // Fin del constructor

    public void establecerSimbolo( char simbolo )
    {
        this.simbolo = simbolo;
    } // Fin del metodo establecerSimbolo

    public char obtenerSimbolo()
    {
        return simbolo;
    } // Fin del metodo obtenerSimbolo;
   
    @Override
    public String toString()
    {
        return String.format( "Simbolo: %c ", obtenerSimbolo() );
    } // Fin del metodo toString   

    // Metodos abstractos que implementara cada subclase
    public abstract int[] obtenerMovimiento();
    public abstract String obtenerNombre();
    protected abstract int[] obtenerCasilla( int movimiento );
} // Fin de la clase Jugador