/******************************************************************************

Filename: Main.java
Description: A matrix calculator. This calculator will ask the user to input 2 
                matrices or a scalar and one matrix. It will ask first for the
                number of rows, then the number of columns. It will ask for an 
                operation *, +, - It will check to see if the result can be 
                calculated, and will then calculate and display the matrix from
                the operation selected.
Author: Jonathan Martinez
E-mail: jonathanmartineztek@gmailcom

*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    double[][] m1;
	    Matrix a,b,c;
	    int opt=0;
		
		while(opt !=1 && opt !=2 && opt!=3){
		    System.out.print("[1] Matrix, Matrix     [2] Scalar, Matrix     [3] Exit\nOpt: ");
    		opt = input.nextInt();
		}	
    	
    	if(opt == 1){
    	    opt=0;
            a = setup(new Matrix());
        	b = setup(new Matrix());
        	while(opt !=1 && opt !=2 && opt!=3 && opt != 4){
                System.out.print("[1] Multiplication     [2] Addition       [3] Subtraction       [4] Quit\nOpt: ");
            	opt = input.nextInt();
                
            	if(opt == 1){
            	    a.times(b).show();
            		opt = 0;
                }
            	if(opt == 2){
            	    a.plus(b).show();
            		opt = 0;
            	}
            	if(opt == 3){
            	    a.plus(b.multiplyBy(-1)).show();
            		opt = 0;
            	}
            	if(opt == 4){
            	    continue;
            	}
        	}
        }
      else if(opt == 2){
          System.out.print("Enter scalar to be multiplied to the matrix: ");
          int s = input.nextInt();
          c = setup(new Matrix());
          c.multiplyBy(s).show();
      }
      else if(opt == 3){
          return;
      }
        
	}
	
	
	public static Matrix setup(Matrix z){
	    Scanner input = new Scanner(System.in);
	    
	    double[][] m1;
	    System.out.print("Enter dimensions ROW COL format(Ex. 2 1): ");
		int m = input.nextInt(), n = input.nextInt();
		m1 = fill(new double[m][n],m,n);
        return new Matrix(m1);
	}
	
	
	public static double[][] fill(double[][] m1, int m, int n){
	    Scanner input = new Scanner(System.in);
	    for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.printf("Enter element in R%dC%d: ", i+1,j+1);
                int element = input.nextInt();
                m1[i][j] = element;
            }
        }
        return m1;
	}
		
}
