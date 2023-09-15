
import java.lang.Math;
import java.util.Random;

public class Adoquines{

static String[][] arreglo;
static int horizontal;
static int vertical;
static String vacio;

public static String[][] crearTablero(int k){
    horizontal = (int) Math.pow(2,k);
    vertical = (int) Math.pow(2,k);
    vacio="v";
    arreglo = new String[horizontal][vertical];
    for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            arreglo[i][j]=vacio;
        }
        System.out.println();
    }
     
    for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            System.out.print(arreglo[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
    return arreglo;
    }


public static String[][] adoquinamiento(String[][] tablero){

    Random r = new Random();
    int random_int = r.nextInt(tablero.length);
    int random_int2 = r.nextInt(tablero.length);
    tablero[random_int][random_int2] = "\033[31me\u001B[0m";

       for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            System.out.print(arreglo[i][j] + " ");
        }
        System.out.println();
    }

    System.out.println();

    dividirEnCuatro(tablero, random_int, random_int2);

      for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            System.out.print(arreglo[i][j] + " ");
        }
        System.out.println();
    }
    return tablero;
}

public static String[][] dividirEnCuatro(String[][] tablero, int random1, int random2){
    if(random2 >= tablero.length/2 && random1 <= (tablero.length/2)-1){ //revisa el cuadrante (2,1)
        ;
    }else{
        tablero[(tablero.length/2)-1][tablero.length/2]="\033[36ma\u001B[0m";
    }
    if(random1 >= tablero.length/2 && random2 >= tablero.length/2){ //revisa el cuadrante (2,2)
       ;     
    }
    else{
        tablero[tablero.length/2][tablero.length/2]="\033[36ma\u001B[0m";
    }
    if(random1 <= (tablero.length/2)-1 && random2 <= (tablero.length/2)-1){
        ;
    }else{
        tablero[(tablero.length/2)-1][(tablero.length/2)-1]="\033[36ma\u001B[0m";
    }
    if(random1 >= tablero.length/2 && random2 <= (tablero.length/2)-1){
        ;
    }else{
        tablero[tablero.length/2][(tablero.length/2)-1]="\033[36ma\u001B[0m";
    }
    return tablero;

}
    
   
    public static void main(String[] args) {
        adoquinamiento(crearTablero(2));
        //System.out.println("\033[31m aaaa \033[37m");
    }
}



