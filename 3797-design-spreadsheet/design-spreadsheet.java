class Spreadsheet {

    int[][] sheet;
    public Spreadsheet(int rows) {
        this.sheet=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; 
        sheet[row][col] = value;
    }

    
    public void resetCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; 
        sheet[row][col] = 0;  
    }
    
    public int getValue(String formula) {
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int val1 = getOperandValue(parts[0]);
        int val2 = getOperandValue(parts[1]);

        return val1 + val2;
    }

    private int getOperandValue(String operand) {
        operand = operand.trim();
        if (Character.isLetter(operand.charAt(0))) {
            char colChar = operand.charAt(0);
            int col = colChar - 'A';
            int row = Integer.parseInt(operand.substring(1)) - 1;
            return sheet[row][col];
        } else {
            return Integer.parseInt(operand);
        }
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */