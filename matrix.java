public class Matrix{
    
    private double[][] matrix;
    private double[][] rMatrix;
    private int row;
    private int column;
    
    public Matrix(){

    }
    
    public Matrix(double[][] m){
        this.matrix = m;
        this.row = m.length;
        this.column = m[0].length;
    }
    
    public Matrix multiplyBy(int scalar){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++){
                this.matrix[i][j] = this.matrix[i][j]*scalar;
            }
        }
        return new Matrix(this.matrix);
    }
    
    public Matrix plus(Matrix right) {
        boolean same = false;
        if((this.row == right.row) && (this.column == right.column)){
            this.rMatrix = new double[this.row][this.column];
            for(int i=0; i<this.row; i++){
                for(int j=0; j<right.column; j++){
                    this.rMatrix[i][j] = this.matrix[i][j] + right.matrix[i][j];
                }
            }
        }
        else{
            System.out.println("Matrices do no have the same dimensions.");
            System.exit(0);
        }
        return new Matrix(this.rMatrix);
    }
    
    public Matrix times(Matrix right){
        this.rMatrix = new double[this.row][right.column];
        if(this.column == right.row){
            
            for(int i=0; i<this.row; i++){
                for(int j=0; j<right.column; j++){
                    for(int k=0; k<this.column; k++){
                        this.rMatrix[i][j] += this.matrix[i][k] * right.matrix[k][j];
                    }
                }
            }
        }
        else {
            System.out.println("Matrix 1 COL != Matrix 2 ROW");
            System.exit(0);
        }
        
        return new Matrix(this.rMatrix);
    }
    
    public void show() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) 
                System.out.printf("%9.4f ", this.matrix[i][j]);
            System.out.println("\n");
        }
    }
    
}
