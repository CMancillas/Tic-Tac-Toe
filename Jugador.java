public abstract class Jugador
{
    private char simbolo;
    protected static final int RANGO_MIN = 1;
    protected static final int RANGO_MAX = 9;

    // constructor de Jugador
    public Jugador( char simbolo )
    {
        this.simbolo = simbolo; // se le asigna el simbolo a Jugador
    }

    public void establecerSimbolo( char simbolo )
    {
        this.simbolo = simbolo;
    } // fin del metodo establecerSimbolo

    public char obtenerSimbolo()
    {
        return simbolo;
    } // fin del metodo obtenerSimbolo;
   
    @Override
    public String toString()
    {
        return String.format( "Simbolo: %c ", obtenerSimbolo() );
    }

    public abstract int[] obtenerMovimiento();
} // fin de la clase Jugador