# Rule Engine Application

This is a comprehensive Rule Engine application developed in Java, designed to evaluate user eligibility based on various attributes like age, department, income, and experience.

# Features

-Dynamic Rule Creation: Create complex rules using a simple string format.
-Evaluation Engine: Evaluate rules against user data efficiently.
-Rule Combination: Combine multiple rules into a single evaluation logic.
-Attribute Validation: Ensure only valid attributes are evaluated.

# Design Choices

1. Architecture: The application is structured in a 3-tier architecture consisting of a presentation layer, an API layer, and a backend data processing layer.
   - Presentation Layer: A simple UI for users to input their data and rules.
   - API Layer: RESTful APIs to interact with the rule engine.
   - Backend: A Java-based engine utilizing an Abstract Syntax Tree (AST) for rule evaluation.

2. Data Storage: The application uses a NoSQL database for flexible schema design, which allows dynamic attribute storage. We recommend using MongoDB for this application.

3. Rule Representation: The rules are represented as an AST, allowing for efficient evaluation and manipulation of logical expressions.