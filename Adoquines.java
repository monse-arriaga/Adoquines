
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

    if(random1 <= vert-1 && random2 >= hor){ //revisa el cuadrante arriba derecho
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor+(mitad/2));
    }else{
        tablero[vert-1][hor]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, vert-1, hor, mitad, vert-(mitad/2), hor+(mitad/2));
     }

     if(random1 <= vert-1 && random2<hor ){ //revisa el cuadrante arriba izquierdo
        adoquinamientoR(tablero, random1, random2, mitad, vert-(mitad/2), hor-(mitad/2));
     }else{
        tablero[vert-1][hor-1]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, vert-1, hor-1, mitad, vert-(mitad/2), hor-(mitad/2));
     }

     if(random1>=vert && random2 >= hor){ //revisa el cuadrante abajo derecho
        adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor+(mitad/2));
     }else{
         tablero[vert][hor]="\033[36ma\u001B[0m";
         adoquinamientoR(tablero, vert, hor, mitad, vert+(mitad/2), hor+(mitad/2));
     }

     if(random1>=vert && random2<hor){ //revisa el cuadrante abajo izquierdo
        adoquinamientoR(tablero, random1, random2, mitad, vert+(mitad/2), hor-(mitad/2));
     }else{
        tablero[vert][hor-1]="\033[36ma\u001B[0m";
        adoquinamientoR(tablero, vert, hor-1, mitad, vert+(mitad/2), hor-(mitad/2));
     }

    return tablero;

}    


    public static String[][] colorearTabla(String[][] tabla){
        for(int i=0; i < horizontal-1; i++){
        for(int j=0; j<vertical-1; j++){

           if(tabla[i][j].equals("v") && tabla[i][j+1].equals("v") && tabla[i+1][j].equals("v") && (tabla[i+1][j+1] == "\033[36ma\u001B[0m"||tabla[i+1][j+1] =="\033[31me\u001B[0m")){
                tabla[i][j] = "\u001B[32mb\u001B[0m";
                tabla[i][j+1] = "\u001B[32mb\u001B[0m";
                tabla[i+1][j] = "\u001B[32mb\u001B[0m";
           }
            
   
             if(tabla[i][j].equals("v") && tabla[i][j+1].equals("v") && (tabla[i+1][j]== "\033[36ma\u001B[0m"||tabla[i+1][j] =="\033[31me\u001B[0m") && tabla[i+1][j+1].equals("v")){
                tabla[i][j] = "\u001B[35mc\u001B[0m";
                tabla[i][j+1] = "\u001B[35mc\u001B[0m";
                tabla[i+1][j+1] = "\u001B[35mc\u001B[0m";
            }

            if((tabla[i][j]== "\033[36ma\u001B[0m" || tabla[i][j]== "\033[31me\u001B[0m") && tabla[i][j+1].equals("v") && tabla[i+1][j].equals("v") && tabla[i+1][j+1].equals("v")){
            tabla[i+1][j] = "\u001B[33md\u001B[0m";
            tabla[i][j+1] = "\u001B[33md\u001B[0m";
            tabla[i+1][j+1] = "\u001B[33md\u001B[0m";
            }

            if(tabla[i][j].equals("v") && (tabla[i][j+1]== "\033[36ma\u001B[0m" || tabla[i][j+1]== "\033[31me\u001B[0m") && tabla[i+1][j].equals("v") && tabla[i+1][j+1].equals("v")){
            tabla[i+1][j] = "f";
            tabla[i][j] = "f";
            tabla[i+1][j+1] = "f";
            }
            

        }
    }
    System.out.println();
     for(int i=0; i < horizontal; i++){
        for(int j=0; j<vertical; j++){
            System.out.print(arreglo[i][j] + " ");
        }
        System.out.println();
    }

    System.out.println();
    return tabla;
    }


    public static void main(String[] args) {
        colorearTabla(adoquinamiento(crearTablero(3)));
        //System.out.println("\033[31m aaaa \033[37m");
    }
}



