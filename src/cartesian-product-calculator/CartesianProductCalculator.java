/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartesian.product.calculator;

import java.util.ArrayList;

/**
 *
 * @author erim
 */
public class CartesianProductCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] dizi1 = {1, 3, 5};
        int[] dizi2 = {2, 4, 6};
        int[] dizi3 = {11,12};
        int[] dizi4 = {15,55,30};

        ArrayList<int[]> dizilerinDizisi = new ArrayList<int[]>();
        dizilerinDizisi.add(dizi1);
        dizilerinDizisi.add(dizi2);
        dizilerinDizisi.add(dizi3);
        dizilerinDizisi.add(dizi4);

        int matrisYukaridanAsagi = 1;
        for (int i = 0; i < dizilerinDizisi.size(); i++) {
            matrisYukaridanAsagi *= dizilerinDizisi.get(i).length;
        }
        int[][] sonucDizisi = new int[matrisYukaridanAsagi][dizilerinDizisi.size()];
        int icIndex = 0,
            disIndex = dizilerinDizisi.size() - 1,
            yazmaSayisi = 1,
            geciciYazmaSayisi = yazmaSayisi;
        int sonucSatirIndex = 0,
            sonucSutunIndex = dizilerinDizisi.size() - 1;

        while (true) {
            if (sonucSutunIndex != -1) {
                if (sonucSatirIndex != sonucDizisi.length) {
                    sonucDizisi[sonucSatirIndex][sonucSutunIndex] = dizilerinDizisi.get(disIndex)[icIndex];
                    sonucSatirIndex++;
                    geciciYazmaSayisi--;
                    if (geciciYazmaSayisi == 0) {
                        geciciYazmaSayisi = yazmaSayisi;
                        if (icIndex == (dizilerinDizisi.get(disIndex).length - 1))
                            icIndex = 0;
                        else 
                            icIndex++;
                    }
                } else {
                    sonucSatirIndex = 0;
                    sonucSutunIndex--;
                    yazmaSayisi *= dizilerinDizisi.get(disIndex).length;
                    geciciYazmaSayisi = yazmaSayisi;
                    disIndex--;
                }
            } else {
                break;
            }
        }

        for (int i = 0; i < sonucDizisi.length; i++) {
            for (int j = 0; j < sonucDizisi[i].length; j++) {
                System.out.print("[" + sonucDizisi[i][j] + "]");
            }
            System.out.println("");
        }
    }
    
}
