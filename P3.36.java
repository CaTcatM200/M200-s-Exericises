public class Main {
    public class matrix
    {
        public int[][] matrixadd(int[][]alphamatrix,int[][]betamatrix)
        {
            int i,j;
            int[][]resultmatrix = new int[alphamatrix.length][betamatrix.length];
            for(i=0;i < resultmatrix.length;i++)
            {
                for(j=0;j < resultmatrix.length;j++)
                {
                    resultmatrix[i][j] = alphamatrix[i][j] + betamatrix[i][j];
                }
            }
            return resultmatrix;
        }

        public int[][] matrixmul(int[][]alphamatrix,int[][]betamatrix)
        {
            int i,j,k;
            int[][]resultmatrix = new int[alphamatrix.length][betamatrix[0].length];
            for(i=0;i < alphamatrix.length;i++)
            {
                for(j=0;j < betamatrix[0].length;j++)
                {
                    resultmatrix[i][j] = 0;
                    for(k=0;k < alphamatrix[0].length;k++)
                    {
                        resultmatrix[i][j] = resultmatrix[i][j] + alphamatrix[i][j] * betamatrix[i][j];
                    }
                }
            }
            return resultmatrix;
        }
    }
}
