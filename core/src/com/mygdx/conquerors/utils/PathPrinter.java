package com.mygdx.conquerors.utils;

import com.mygdx.conquerors.maps.Map;
import com.mygdx.conquerors.maps.grid.Cell;

import java.util.Collection;

/**
 * Created by Lucas on 12/7/2014.
 */
public class PathPrinter {

    public static void printPath(Map map, Collection<Cell> path, Cell start) {
        int width = map.width();
        int height = map.height();
        int[][] pMap = new int[width][height];

        int counter = 1;

        int size = path.size();
        int numDigits = numDigits(size);

        pMap[start.x()][start.y()] = -1;

        for(Cell cell : path) {
            pMap[cell.x()][cell.y()] = counter++;
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                print("[", 1);
                if(pMap[j][i] == 0)
                    print(" ", numDigits);
                else if(pMap[j][i] == -1) {
                    print(" ", numDigits - 1);
                    print("S", 1);
                }
                else {
                    int digits = numDigits(pMap[j][i]);
                    Integer num = pMap[j][i];
                    print(" ", numDigits - digits);
                    print(num.toString(), 1);
                }
                print("]", 1);
            }
            System.out.println();
        }
    }

    public static int numDigits(int num) {
        return (int)Math.log10(num) + 1;
    }

    public static void print(String str, int times) {
        for(int i = 0; i < times; i++)
            System.out.print(str);
    }

    public static void println(String str, int times) {
        for(int i = 0; i < times; i++)
            System.out.println(str);
    }
}
