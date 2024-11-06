public class MatrixOperations {
    public static void main(String[] args) {
        try {
            // Задаємо розміри матриць
            int rows = 3;
            int cols = 4;

            // Ініціалізуємо матриці
            long[][] matrixA = {{1, 2, 3, 4},
                               {5, 6, 7, 8},
                               {9, 10, 11, 12}};
            long[][] matrixB = {{10, 9, 8, 7},
                               {6, 5, 4, 3},
                               {2, 1, 0, -1}};

            // Створюємо матрицю для результату
            long[][] matrixC = new long[rows][cols];

            // Обчислюємо суму матриць
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            // Виводимо матрицю C на екран
            System.out.println("Матриця C:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.println();
            }

            // Обчислюємо суму найбільших елементів кожного рядка матриці C
            long sumOfMaxElements = 0;
            for (int i = 0; i < rows; i++) {
                long maxElement = matrixC[i][0];
                for (int j = 1; j < cols; j++) {
                    if (matrixC[i][j] > maxElement) {
                        maxElement = matrixC[i][j];
                    }
                }
                sumOfMaxElements += maxElement;
            }

            // Виводимо результат
            System.out.println("Сума найбільших елементів кожного рядка матриці C: " + sumOfMaxElements);

        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        }
    }
}