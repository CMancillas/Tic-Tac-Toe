public class Juego 
{
    private String[][] tablero;
    private boolean jugadorActual;


    public Juego()
    {
        this( true );
    } // Fin del constructor
    
    public Juego( boolean jugador)
    {
        tablero = new String[ 3 ][ 5 ];
        
        for ( int fila = 0; fila < 3; fila++ )
        {
            for ( int columna = 0; columna < 5; columna ++)
            {
                if ( columna % 2 != 0 )
                    tablero[ fila ][ columna ] = "|";
                else
                    tablero[ fila ][ columna ] = " ";
            }
        }

        jugadorActual = jugador;
    } // Fin del constructor

    public void mostrarTablero()
    {
        for ( int fila = 0; fila < 3; fila++)
        {
            System.out.println();
            for ( int columna = 0; columna < 11; columna++ )
            {
                System.out.print("-");

                if ( columna / 4 == 0 )
                    System.out.print( "|" );
            }
            System.out.println();
        }
    } // fin del metodo mostrarTablero
}
