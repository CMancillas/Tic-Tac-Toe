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
        tablero = new String[ 3 ][ 3 ];
        for (int fila = 0; fila < tablero.length; fila++)
            for ( int columna = 0; columna < tablero[1].length; columna++ )
                tablero[fila][columna] = "-";
            
        jugadorActual = jugador;
    } // Fin del constructor


    public void mostrarTableroInicial()
    {
        int posicion_tablero = 1;

        for ( int fila = 0; fila < 6; fila++)
        {
            for ( int columna = 0; columna < tablero.length; columna++)
            {
                if ( fila % 2 == 0)
                {
                    if ( columna != 0 )
                    System.out.print("|" + " ");
                
                    System.out.print(posicion_tablero + " ");
                    posicion_tablero++;
                }     
            }
            
            if ( fila == 1 || fila == 3 )
            {
                for( int i = 0; i < 10; i++)
                {
                    System.out.print("-");
                }    
            }               
            System.out.print("\n");
        }
    }
    public void mostrarTablero()
    {
        
        

        for ( int fila = 0; fila < 6; fila++)
        {
            for ( int columna = 0; columna < tablero.length; columna++)
            {
                if ( fila % 2 == 0)
                {
                    if ( columna != 0 )
                    System.out.print("|" + " ");
                    
                    
                    System.out.print(tablero[(fila / 2)][columna] + " ");
                    
                }     
            }
            
            if ( fila == 1 || fila == 3 )
            {
                for( int i = 0; i < 10; i++)
                {
                    System.out.print("-");
                }    
            }               
            System.out.print("\n");
        }
    } // fin del metodo mostrarTableroInicial

    public void rellenarTablero(int[] posicion, String jugador)
    {
        if (tablero[posicion[0]][posicion[1]].equals("-") )  
            tablero[posicion[0]][posicion[1]] = jugador;
    }
}
