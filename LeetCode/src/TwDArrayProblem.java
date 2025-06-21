public class TwDArrayProblem {
    public static void main(String[] args) {
        char[][] matrix = {
                {'D','A','B','E'},
                {'S','R','T','N'},
                {'A','I','V','A'},
                {'F','N','T','H'}};
        boolean isValid = isValidDir(matrix,"Artvinth"); //Direction
        /**
         *
         *                  {'D','A','B','E'},
         *                        ↓
         *                  {'S','R'-->'T','N'},
         *                              ↓
         *                  {'A','I'<--'V','A'},
         *                        ↓
         *                  {'F','N'-->'T'-->'H'}};
         *
         *
         *
         * */
        System.out.println(isValid);
    }

    private static boolean isValidDir(char[][] matrix, String aravinth) {
        int count = 1, i = 0, j = 0,row=0,col=0;

        for (i = 0; i < matrix.length - 1; i++) {
            for (j = 0; j < matrix[i].length - 1; j++) {
                if ( matrix[i][j] == Character.toUpperCase(aravinth.charAt(0)) ) {
                    row = i;
                    col = j;
                   while (count<aravinth.length()) {
                       if (row - 1 >= 0 && matrix[row - 1][col] == Character.toUpperCase(aravinth.charAt(count))) {
                          // System.out.println("1 " + count + " " + aravinth.charAt(count) + " " + matrix[row - 1][col]);
                           row = row - 1;
                           count++;
                       } else if (col - 1 >= 0 && matrix[row][col - 1] == Character.toUpperCase(aravinth.charAt(count))) {
                         //  System.out.println("2 " + count + " " + aravinth.charAt(count) + " " + matrix[row][col - 1]);
                           col = col - 1;
                           count++;
                       } else if (row + 1 < matrix.length && matrix[row + 1][col] == Character.toUpperCase(aravinth.charAt(count))) {
                          // System.out.println("3 " + count + " " + aravinth.charAt(count) + " " + matrix[row + 1][col]);
                           row = row + 1;
                           count++;
                       } else if (col + 1 < matrix.length && matrix[row][col + 1] == Character.toUpperCase(aravinth.charAt(count))) {
                          // System.out.println("4 " + count + " " + aravinth.charAt(count) + " " + matrix[row][col + 1]);
                           col = col + 1;
                           count++;
                       } else
                           return false;
                       if(count==aravinth.length())
                           return true;
                   }
                }
            }
        }
        return false;

    }

}

