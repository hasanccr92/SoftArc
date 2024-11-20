// Abstract base class for all formula nodes
import java.util.List;
import java.util.ArrayList;
abstract class FormulaNode {
    public abstract double evaluate(Spreadsheet spreadsheet);
}

// Operand node for numbers and cell references
class OperandNode extends FormulaNode {
    private final String value;

    public OperandNode(String value) {
        this.value = value;
    }

    @Override
    public double evaluate(Spreadsheet spreadsheet) {
        try {
            // If it's a number, parse and return
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            // Otherwise, treat it as a cell reference
            return Double.parseDouble(spreadsheet.getCellValue(value));
        }
    }
}

// Operator node for +, -, *, /
class OperatorNode extends FormulaNode {
    private final String operator;
    private final FormulaNode left;
    private final FormulaNode right;

    public OperatorNode(String operator, FormulaNode left, FormulaNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate(Spreadsheet spreadsheet) {
        double leftValue = left.evaluate(spreadsheet);
        double rightValue = right.evaluate(spreadsheet);

        return switch (operator) {
            case "+" -> leftValue + rightValue;
            case "-" -> leftValue - rightValue;
            case "*" -> leftValue * rightValue;
            case "/" -> leftValue / rightValue;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}

// Node for spreadsheet functions like SUMA, MIN, MAX, PROMEDIO
class FunctionNode extends FormulaNode {
    private final String functionName;
    private final List<FormulaNode> arguments;

    public FunctionNode(String functionName, List<FormulaNode> arguments) {
        this.functionName = functionName.toUpperCase();
        this.arguments = arguments;
    }

    @Override
    public double evaluate(Spreadsheet spreadsheet) {
        System.out.println("Evaluating function: " + functionName + " with arguments " + arguments); // Debug
        List<Double> values = new ArrayList<>();
        for (FormulaNode arg : arguments) {
            double value = arg.evaluate(spreadsheet);
            System.out.println("Argument evaluated to: " + value); // Debug
            values.add(value);
        }

        return switch (functionName) {
            case "SUMA" -> values.stream().mapToDouble(Double::doubleValue).sum();
            case "MIN" -> values.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
            case "MAX" -> values.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
            case "PROMEDIO" -> values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            default -> throw new IllegalArgumentException("Unknown function: " + functionName);
        };
    }
}

class RangeNode extends FormulaNode {
    private final String startCoordinate;
    private final String endCoordinate;

    public RangeNode(String startCoordinate, String endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
    }

    @Override
    public double evaluate(Spreadsheet spreadsheet) {
        List<String> rangeCells = getRangeCells(startCoordinate, endCoordinate);
        double sum = 0.0;

        for (String coordinate : rangeCells) {
            try {
                sum += Double.parseDouble(spreadsheet.getCellValue(coordinate));
            } catch (NumberFormatException e) {
                sum += 0.0; // Treat invalid cells as 0
            }
        }

        return sum;
    }

    // Change this method's access to protected for testing
    protected List<String> getRangeCells(String start, String end) {
        List<String> cells = new ArrayList<>();

        String startCol = start.replaceAll("\\d", "");
        String endCol = end.replaceAll("\\d", "");
        int startRow = Integer.parseInt(start.replaceAll("\\D", ""));
        int endRow = Integer.parseInt(end.replaceAll("\\D", ""));

        for (char col = startCol.charAt(0); col <= endCol.charAt(0); col++) {
            for (int row = startRow; row <= endRow; row++) {
                cells.add("" + col + row);
            }
        }

        return cells;
    }
}
