package homeWork9;

public class ArrayValueCalculator {

    public int doCalc(String[][] array) {

        int result = 0;
        int rowNumber = 0;
        int columnNumber = 0;

        for (String[] row : array) {
            rowNumber++;
            if (row.length != 4) {
                throw new ArraySizeException("In row " + rowNumber + " the number of elements is not 4");
            }
            for (String column : row) {
                columnNumber++;
                try {
                    result = result + Integer.parseInt(column);
                } catch (Exception e) {
                    throw new ArrayDataException("Value does not contain a parsable int (row: " + rowNumber + ", column: " + columnNumber + ")");
                }
            }
        }

        return result;
    }
}
