// Дана прямоугольная карта размера MxN (N, M меньше 20)
// На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
// Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
// * * На карте могут быть стены
// * ** M и N могут быть до 1000
// Задачу разбить на методы

import java.util.Scanner;

public class HomeTask_03 {
    public static void main(String[] args) { 
        int[] result = GetSizeOfMap();
        GetResult(result);
        PrintResult(result, GetResult(result));       
    }

    public static int[] GetSizeOfMap(){
        Scanner iScanner = new Scanner(System.in);
        int[] array = new int[2];    
        System.out.printf("Ведите размер карты M x N: ");
        array[0] = iScanner.nextInt();
        array[1] = iScanner.nextInt();
        iScanner.close();
        return array;   
    }

    public static int GetResult(int[] array){
        int m = array[0];
        int n = array[1];
        int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                 a[i][j] = 1;
                }   
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    a[i][j] = a[i-1][j] + a[i][j-1];    
                } 
            }   
        int count = a[m - 1][n - 1];
        return count;
    }

    public static void PrintResult(int[] array, int count){
    System.out.print("Количество маршрутов из точки М = 0 N = 0 в нижнюю правую клетку = " + count);
    }
}