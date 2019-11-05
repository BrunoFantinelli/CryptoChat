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
public class TabelaRecip {

    public static int getNewRecip(int det) {
        switch (det) {
            case 1:
                return 1;
            case 3:
                return 9;
            case 5:
                return 21;
            case 7:
                return 15;
            case 9:
                return 3;
            case 11:
                return 19;
            case 15:
                return 7;
            case 17:
                return 23;
            case 19:
                return 11;
            case 21:
                return 5;
            case 23:
                return 17;
            case 25:
                return 25;
            default:
                break;
        }
        return -1;
    }
}
