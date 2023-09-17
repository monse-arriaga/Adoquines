
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

    int longitud, vert, hor;
    longitud = tablero.length;
    vert = hor = tablero.length/2;

    adoquinamientoR(tablero, random_int, random_int2, longitud, vert, hor) ;

    for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            System.out.print(arreglo[i][j] + " ");
        }
        System.out.println();
    }

    System.out.println();


    
    return tablero;
}

public static String[][] adoquinamientoR(String[][] tablero, int random1, int random2, int longitud, int vert, int hor) {  
    int mitad = longitud/2;

    if(longitud==2){
        return tablero;
    }

    if(random1 <= vert-1 && random2 >= hor && tablero[vert-1][hor] != "\033[36ma\\u001B[0m"){ //revisa el cuadrante arriba derecho
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor+(mitad/2));
    }else{
        tablero[vert-1][hor]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor+(mitad/2));
     }

     if(random1 <= vert-1 && random2<hor && tablero[vert-1][hor-1] != "\033[36ma\\u001B[0m"){ //revisa el cuadrante arriba izquierdo
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor-(mitad/2));
     }else{
        tablero[vert-1][hor-1]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor-(mitad/2));
     }

     if(random1>=vert && random2 >= hor && tablero[vert][hor] != "\033[36ma\\u001B[0m"){ //revisa el cuadrante abajo derecho
        adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor+(mitad/2));
     }else{
         tablero[vert][hor]="\033[36ma\u001B[0m";
         adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor+(mitad/2));
     }

     if(random1>=vert && random2<hor && tablero[vert][hor-1] != "\033[36ma\\u001B[0m"){ //revisa el cuadrante abajo izquierdo
        adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor-(mitad/2));
     }else{
        tablero[vert][hor-1]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor-(mitad/2));
     }

    return tablero;

}    



    public static void main(String[] args) {
        adoquinamiento(crearTablero(3));
        //System.out.println("\033[31m aaaa \033[37m");
    }
}



