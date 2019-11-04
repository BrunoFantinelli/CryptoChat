/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptochat;

/**
 *
 * @author cc10848869958
 */
public class Criptografar {

    public String cripto(String entrada, int valor1, int valor2, int valor3, int valor4) {
        int matriz[][] = new int[2][2];
        String texto = entrada;
        String saida = "";

        matriz[0][0] = valor1;
        matriz[0][1] = valor2;
        matriz[1][0] = valor3;
        matriz[1][1] = valor4;

        if (texto.length() % 2 != 0) {
            texto += texto.charAt(texto.length() - 1);
        }

        int matrizValores[][] = new int[2][texto.length() / 2];
        int k = 0;
        for (int i = 0; i < texto.length(); i += 2) {
            matrizValores[0][k] = texto.charAt(i) - 96;
            matrizValores[1][k] = texto.charAt(i + 1) - 96;
            //System.out.println(matrizValores[0][k]);
            //System.out.println(matrizValores[1][k]);
            k++;
        }

        int[][] result = new int[matriz.length][matrizValores[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matrizValores[0].length; j++) {
                int somatoria = 0;
                for (k = 0; k < matriz[0].length; k++) {
                    int produto = matriz[i][k] * matrizValores[k][j];
                    somatoria += produto;
                }
                result[i][j] = somatoria;
            }
        }

        for (int j = 0; j < result[0].length; j++) {
            for (int i = 0; i < result.length; i++) {
                //System.out.println(result[i][j]);
                if (result[i][j] > 25) {
                    result[i][j] = result[i][j] % 26;
                }

                char b = (char) (result[i][j] + 96);
                saida += b;
            }
        }
        //System.out.println(saida);
        return saida;
    }
    
    public String descrip(String entrada, int valor1, int valor2, int valor3, int valor4){
        int matriz[][] = new int[2][2];
        String texto = entrada;
        String saida = "";

        matriz[0][0] = valor1;
        matriz[0][1] = valor2;
        matriz[1][0] = valor3;
        matriz[1][1] = valor4;
        
        int det = (valor1*valor4)-(valor2*valor3);
        if(det < 26){
            det = TabelaRecip.getNewRecip(det);
        }
        //System.out.println(det);
        
        int matrizInversa[][] = new int[2][2];
        matrizInversa[0][0] = valor4;
        matrizInversa[1][1] = valor1;
        matrizInversa[0][1] = valor2*-1;
        matrizInversa[1][0] = valor3*-1;
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                matrizInversa[i][j] = (matrizInversa[i][j]*det);
                matrizInversa[i][j] = Math.floorMod(matrizInversa[i][j], 26);
                //System.out.println(matrizInversa[i][j]);
            }
        }
        

        
        int matrizValores[][] = new int[2][texto.length() / 2];
        int k = 0;
        for (int i = 0; i < texto.length(); i += 2) {
            matrizValores[0][k] = texto.charAt(i) - 96;
            matrizValores[1][k] = texto.charAt(i + 1) - 96;
            //System.out.println(matrizValores[0][k]);
            //System.out.println(matrizValores[1][k]);
            k++;
        }

        int[][] result = new int[matrizInversa.length][matrizValores[0].length];

        for (int i = 0; i < matrizInversa.length; i++) {
            for (int j = 0; j < matrizValores[0].length; j++) {
                int somatoria = 0;
                for (k = 0; k < matrizInversa[0].length; k++) {
                    int produto = matrizInversa[i][k] * matrizValores[k][j];
                    somatoria += produto;
                }
                result[i][j] = somatoria;
            }
        }

        for (int j = 0; j < result[0].length; j++) {
            for (int i = 0; i < result.length; i++) {
                //System.out.println(result[i][j]);
                if (result[i][j] > 25) {
                    result[i][j] = result[i][j] % 26;
                }

                char b = (char) (result[i][j] + 96);
                saida += b;
            }
        }
        //System.out.println(saida);
        return saida;
    }
    
}
