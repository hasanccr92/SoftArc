import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
    private Map<String, Cell> cells;
    private FormulaParser parser; // Formula parser instance

    // Constructor
    public Spreadsheet() {
        this.cells = new HashMap<>();
        this.parser = new FormulaParser(); // Initialize parser
    }

    // Add or update a cell's content
    public void setCellContent(String coordinate, String content) {
        if (coordinate == null || coordinate.isEmpty()) {
            throw new IllegalArgumentException("Coordinate cannot be null or empty.");
        }
        cells.put(coordinate.toUpperCase(), new Cell(content));
    }

    // Get the raw content of a cell
    public String getCellContent(String coordinate) {
        Cell cell = cells.get(coordinate.toUpperCase());
        if (cell == null) {
            return ""; // Empty content
        }
        return cell.getContent();
    }

    // Get the evaluated value of a cell
    public String getCellValue(String coordinate) {
        Cell cell = cells.get(coordinate.toUpperCase());
        if (cell == null) {
            return ""; // Empty content
        }

        String content = cell.getContent();
        if (content.startsWith("=")) {
            // It's a formula, evaluate it
            return evaluateFormula(content.substring(1)); // Skip the '='
        } else {
            // Handle as text or number
            try {
                return String.valueOf(cell.getAsNumber());
            } catch (IllegalArgumentException e) {
                return cell.getAsString();
            }
        }
    }

    // Evaluate a formula using the FormulaParser
    private String evaluateFormula(String formula) {
        try {
            FormulaNode parseTree = parser.parse(formula); // Parse formula into a tree
            double result = parseTree.evaluate(this); // Evaluate the parse tree
            return String.valueOf(result); // Convert result to string
        } catch (Exception e) {
            return "ERROR"; // Return error for invalid formulas
        }
    }
}
