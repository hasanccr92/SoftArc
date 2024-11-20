// Class to test the Cell functionality
/**public class Main {

    public static void main(String[] args) {
        // Create test cells
        Cell cell1 = new Cell("123");
        Cell cell2 = new Cell("Hello");
        Cell cell3 = new Cell("");

        // Test numeric conversion
        testNumericConversion(cell1);

        // Test string conversion
        testStringConversion(cell2);

        // Test empty cell behavior
        testEmptyCell(cell3);
    }

    private static void testNumericConversion(Cell cell) {
        try {
            System.out.println("Cell as number: " + cell.getAsNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testStringConversion(Cell cell) {
        System.out.println("Cell as string: " + cell.getAsString());
    }

    private static void testEmptyCell(Cell cell) {
        System.out.println("Empty cell as number: " + cell.getAsNumber());
        System.out.println("Empty cell as string: " + cell.getAsString());
    }


}

 **/
public class Main {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();

        // Add some values to the cells
        spreadsheet.setCellContent("A1", "10");
        spreadsheet.setCellContent("A2", "20");
        spreadsheet.setCellContent("A3", "30");
        spreadsheet.setCellContent("B1", "40");
        spreadsheet.setCellContent("B2", "50");

        // Test SUMA with a range
        spreadsheet.setCellContent("C1", "=SUMA(A1:A3)");  // Expect 60.0 (10 + 20 + 30)
        System.out.println("C1 value: " + spreadsheet.getCellValue("C1"));

        // Test MIN with a range
        spreadsheet.setCellContent("C2", "=MIN(A1:B2)");  // Expect 10.0 (min of 10, 20, 30, 40, 50)
        System.out.println("C2 value: " + spreadsheet.getCellValue("C2"));

        // Test MAX with a range
        spreadsheet.setCellContent("C3", "=MAX(A1:B2)");  // Expect 50.0 (max of 10, 20, 30, 40, 50)
        System.out.println("C3 value: " + spreadsheet.getCellValue("C3"));

        // Test PROMEDIO with a range
        spreadsheet.setCellContent("C4", "=PROMEDIO(A1:A3)");  // Expect 20.0 (avg of 10, 20, 30)
        System.out.println("C4 value: " + spreadsheet.getCellValue("C4"));

        // Test complex expression with operator precedence
        spreadsheet.setCellContent("C5", "=A1 + B1 * A2");  // Expect 10 + 40 * 20 = 810
        System.out.println("C5 value: " + spreadsheet.getCellValue("C5"));
    }
}
