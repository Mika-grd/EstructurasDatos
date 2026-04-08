package PilaEntrega1;


public class main {
    public static void main(String[] args){

        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        recorrer(lista, 0);

        recorrerMatriz(matriz, 0, 0);

        recorrerDiagonal(matriz, 0);
    }


    public static void recorrer(int[] array, int indice){
        if (indice >= array.length){
            return;
        }

        System.out.println(array[indice]);
        recorrer(array, indice + 1);
    }

    public static void recorrerMatriz(int[][] matriz, int fila, int columna){
        if (fila >= matriz.length){
            return;
        }

        if (columna >= matriz[fila].length){
            recorrerMatriz(matriz, fila+1, 0);      
        }

        System.out.println(matriz[fila][columna]);
        recorrerMatriz(matriz, fila, columna+1);
    }

    public static void recorrerDiagonal(int[][] matriz, int indiceDiagonal){
        if (indiceDiagonal >= matriz.length){
            return;
        }

        System.out.println(matriz[indiceDiagonal][indiceDiagonal]);

        recorrerDiagonal(matriz, indiceDiagonal+1);
    }

}