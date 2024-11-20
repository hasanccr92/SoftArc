import java.util.*;

public class FormulaParser {

    public FormulaNode parse(String formula) {
        System.out.println("Parsing formula: " + formula); // Debug
        List<String> tokens = tokenize(formula);
        System.out.println("Tokens: " + tokens); // Debug
        List<String> rpn = toRPN(tokens);
        System.out.println("RPN: " + rpn); // Debug
        FormulaNode tree = buildParseTree(rpn);
        System.out.println("Parse tree built."); // Debug
        return tree;
    }

    private List<String> tokenize(String formula) {
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();

        for (char ch : formula.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if (isOperator(ch) || ch == '(' || ch == ')' || ch == ',' || ch == ';' || ch == ':') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
                tokens.add(String.valueOf(ch)); // Add operator or delimiter
            } else {
                token.append(ch);
            }
        }

        if (token.length() > 0) {
            tokens.add(token.toString());
        }

        return tokens;
    }

    private List<String> toRPN(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else if ("(".equals(token)) {
                operators.push(token);
            } else if (")".equals(token)) {
                while (!operators.isEmpty() && !"(".equals(operators.peek())) {
                    output.add(operators.pop());
                }
                operators.pop(); // Remove '('
            } else if (isFunction(token)) {
                operators.push(token);
            } else if (";".equals(token)) {
                // Handle function argument separation; no action needed
            } else {
                output.add(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    private FormulaNode buildParseTree(List<String> rpn) {
        Deque<FormulaNode> stack = new ArrayDeque<>();

        for (String token : rpn) {
            if (isOperator(token)) {
                FormulaNode right = stack.pop();
                FormulaNode left = stack.pop();
                stack.push(new OperatorNode(token, left, right));
            } else if (isFunction(token)) {
                List<FormulaNode> arguments = new ArrayList<>();
                while (!stack.isEmpty() && !(stack.peek() instanceof OperatorNode)) {
                    arguments.add(0, stack.pop());
                }
                stack.push(new FunctionNode(token, arguments));
            } else if (token.contains(":")) {
                String[] range = token.split(":");
                stack.push(new RangeNode(range[0], range[1])); // Create RangeNode
            } else {
                stack.push(new OperandNode(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(char ch) {
        return "+-*/".indexOf(ch) != -1;
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private boolean isFunction(String token) {
        return Set.of("SUMA", "MIN", "MAX", "PROMEDIO").contains(token.toUpperCase());
    }

    private int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
}
