public class pracBacktarck {
    public static void main(String[] args) {
        char board[][]=new char[8][8];
        int m = 10;
        int n =  10;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                board[i][j]= '.';
            }
        }
        solution(board, 0);
        System.out.println(count);
    }

    public static int count ;
    public static void solution(char board[][] , int row)
    {
        if(row==board.length)
        {
            printing(board);
            count++;
            System.out.println("--------------------------------------------------------------");
            return;
        }
        for(int col=0;col<board.length;col++)
        {
            if(isSafe(board, row, col))
            {
                board[row][col]='Q';
                solution(board, row+1);
                board[row][col]='.';
            }
        }
    }
  public static boolean isSafe(char board[][] , int row , int col)
    {
    //top elements
    for(int i=row-1;i>=0;i--)
    {
        if(board[i][col]=='Q')
        {
            return false;
        }
    }
    //right elements
    for(int i=row-1,j=col+1; (i>=0)&&(j<board.length); i--,j++)
    {
        if(board[i][j]=='Q')
        {
            return false;
        }
    }
    //left elements
    for(int i=row-1,j=col-1; (i>=0)&&(j>=0); i--,j--)
    {
        if(board[i][j]=='Q')
        {
            return false;
        }
    }
    return true;
    }
    public static void printing(char board[][]) 
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }   
}
