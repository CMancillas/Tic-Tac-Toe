public class Juego 
{
    private char[][] tablero;
    private boolean jugadorActual;

    
    public Juego()
    {
        this( true );
    } // Fin del constructor
    
    public Juego( boolean jugador)
    {
        tablero = new char[ 3 ][ 3 ];
        for (int fila = 0; fila < tablero.length; fila++)
            for ( int columna = 0; columna < tablero[1].length; columna++ )
                tablero[fila][columna] = '-';
            
        jugadorActual = jugador;
    } // Fin del constructor

    public void mostrarMenu()
    {
        System.out.println("+------------------------------+");
        System.out.println("| Bienvenido al juego del Gato |");
        System.out.println("+------------------------------+");
        System.out.println();

        System.out.println("Instrucciones:");
        System.out.println("- El objetivo es alinear tres símbolos iguales (X u O) en fila, columna o diagonal.");
        System.out.println("- El tablero tiene posiciones numeradas del 1 al 9. ");
        System.out.println("- En cada turno, el jugador elige una casilla para colocar su símbolo.");
        System.out.println();
    }

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
    } // Fin del metodo mostrarTableroInicial

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

    public void mostrarTableros()
    {
        mostrarTableroInicial();
        mostrarTablero();
    } // fin del metodo mostrarTableros

    public void rellenarTablero(int[] posicion, char jugador)
    {
        if (tablero[posicion[0]][posicion[1]] == ('-') )  
            tablero[posicion[0]][posicion[1]] = jugador;
    } // Fin del metodo rellenarTablero

    public boolean esVictoria()
    {
        /*Secuencias para llegar a la victoria:
        Horizontales:
        1,2,3    
        4,5,6
        7,8,9
        Verticales:
        1,4,7
        2,5,8
        3,6,9
        Cruzadas:
        1 5,9
        3,5,7
        */
        
        // Combinaciones horizontales de cada jugador
        if ( tablero[0][0] == 'x' && tablero[0][1] == 'x' && tablero[0][2] == 'x' )
            return true;
        else if ( tablero[1][0] == 'x' && tablero[1][1] == 'x' && tablero[1][1] == 'x' )
            return true;
        else if ( tablero[2][0] == 'x' && tablero[2][1] == 'x' && tablero[2][2] == 'x' )
            return true;
        else if ( tablero[0][0] == 'o' && tablero[0][1] == 'o' && tablero[0][2] == 'o' )
            return true;
        else if ( tablero[1][0] == 'o' && tablero[1][1] == 'o' && tablero[1][1] == 'o' )
            return true;
        else if ( tablero[2][0] == 'o' && tablero[2][1] == 'o' && tablero[2][2] == 'o' )
            return true;

        
        // Combinaciones verticales de cada jugador
        else if ( tablero[0][0] == 'x' && tablero[1][0] == 'x' && tablero[2][0] == 'x' )
            return true;
        else if ( tablero[0][1] == 'x' && tablero[1][1] == 'x' && tablero[2][1] == 'x' )
            return true;
        else if ( tablero[0][2] == 'x' && tablero[1][2] == 'x' && tablero[2][2] == 'x' )
            return true;
        else if ( tablero[0][0] == 'o' && tablero[1][0] == 'o' && tablero[2][0] == 'o' )
            return true;
        else if ( tablero[0][1] == 'o' && tablero[1][1] == 'o' && tablero[2][1] == 'o' )
            return true;
        else if ( tablero[0][2] == 'o' && tablero[1][2] == 'o' && tablero[2][2] == 'o' )
            return true;
        
        // Combinaciones cruzadas de cada jugador
        else if ( tablero[0][0] == 'x' && tablero[1][1] == 'x' && tablero[2][2] == 'x' )
            return true;
        else if ( tablero[0][2] == 'x' && tablero[1][1] == 'x' && tablero[2][0] == 'x' )
            return true;
        else if ( tablero[0][0] == 'o' && tablero[1][1] == 'o' && tablero[2][2] == 'o' )
            return true;
        else if ( tablero[0][2] == 'o' && tablero[1][1] == 'o' && tablero[2][0] == 'o' )
            return true;
        else
            return false;    
    }
}
