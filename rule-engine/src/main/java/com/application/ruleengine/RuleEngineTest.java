package com.application.ruleengine;

import java.util.*;

public class Reengineers {
    public static void main(String[] args) {

        testCreateRule();
        

        testEvaluateRule();
        
               testIsValidAttribute();
        
        }

    private static void testCreateRule() {
        String ruleString1 = "age > 30 AND department = 'Sales'";
        String ruleString2 = "salary > 50000 OR experience > 5";
        ASTNode ast1 = RuleEngine.createRule(ruleString1);
        ASTNode ast2 = RuleEngine.createRule(ruleString2);
        
        System.out.println("AST rule 1: " + ast1);
        System.out.println("AST for rule 2: " + ast2);
        
    }

    private static void testEvaluateRule() {
               String ruleString = "age > 30 AND department = 'Sales'";
        ASTNode ast = RuleEngine.createRule(ruleString);
        

        Map<String, Object> data1 = new HashMap<>();
        data1.put("age", 35);
        data1.put("department", "Sales");
        
        Map<String, Object> data2 = new HashMap<>();
        data2.put("age", 25);
        data2.put("department", "Marketing");


        boolean result1 = RuleEngine.evaluateRule(ast, data1);
        boolean result2 = RuleEngine.evaluateRule(ast, data2);

        System.out.println("Evaluation for data1: " + result1); 
        System.out.println("Evaluation data2: " + result2); 
    }

    private static void testIsValidAttribute() {

        System.out.println("Is 'age' a valid attribute? " + RuleEngine.isValidAttribute("age")); // true
        System.out.println("Is 'invalidAttribute' a valid attribute? " + RuleEngine.isValidAttribute("invalidAttribute")); // false
    }
}
