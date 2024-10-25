package com.application.ruleengine;

import java.util.*;

public class RuleEngine {

    private static final Set<String> VALID_ATTRIBUTES = new HashSet<>(Arrays.asList("age", "department", "salary", "experience"));


    public static ASTNode createRule(String ruleString) {
        try {
            String[] tokens = ruleString.split("\\s+");
            Stack<ASTNode> stack = new Stack<>();
            Stack<String> operators = new Stack<>();

            for (String token : tokens) {
                if (token.matches("\\w+\\s*[<>=]+\\s*\\w+")) {
                    stack.push(new ASTNode("operand", null, null, token));
                } else if (token.equals("AND") || token.equals("OR")) {
                    operators.push(token);
                } else {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }

            while (!operators.isEmpty()) {
                String operator = operators.pop();
                ASTNode right = stack.pop();
                ASTNode left = stack.pop();
                stack.push(new ASTNode("operator", left, right, operator));
            }

            return stack.pop();
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
            return null;
        }
    }


    public static boolean evaluateRule(ASTNode ast, Map<String, Object> data) {
        try {
            if (ast.type.equals("operand")) {
                String[] parts = ast.value.split("\\s*([<>=]+)\\s*");
                String left = parts[0].trim();
                String operator = ast.value.replace(left, "").trim();
                String right = parts[1].trim();

                if (!data.containsKey(left)) {
                    throw new IllegalArgumentException("Invalid " + left);
                }

                Object leftValue = data.get(left);
                Object rightValue = right.matches("\\d+") ? Integer.valueOf(right) : right.replace("'", "");

                switch (operator) {
                    case ">":
                        return (Integer) leftValue > (Integer) rightValue;
                    case "<":
                        return (Integer) leftValue < (Integer) rightValue;
                    case "=":
                        return leftValue.equals(rightValue);
                    default:
                        throw new IllegalArgumentException("Invalid: " + operator);
                }
            } else if (ast.type.equals("operator")) {
                boolean leftEval = evaluateRule(ast.left, data);
                boolean rightEval = evaluateRule(ast.right, data);
                return ast.value.equals("AND") ? leftEval && rightEval : leftEval || rightEval;
            }
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
            return false;
        }
        return false;
    }


    public static ASTNode combineRules(List<String> rules) {
        return null; 
    }


    public static boolean isValidAttribute(String attribute) {
        return VALID_ATTRIBUTES.contains(attribute);
    }

}
