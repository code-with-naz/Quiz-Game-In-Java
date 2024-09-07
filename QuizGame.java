import java.util.Scanner;

class QuizGame {

    // Question class to hold question, options, and the correct answer
    static class Question {
        String question;
        String[] options;
        char correctAnswer;

        Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        // Method to display the question and options
        void display() {
            System.out.println(question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[i]);
            }
        }

        // Method to check if the user's answer is correct
        boolean isCorrect(char answer) {
            return Character.toUpperCase(answer) == correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Array of questions
        Question[] questions = {
            new Question("What is the capital of India?", new String[]{"Mumbai", "Delhi", "Kolkata", "Gujarat"}, 'B'),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 'B'),
            new Question("What is the largest mammal?", new String[]{"Elephant", "Blue Whale", "Giraffe", "Shark"}, 'B'),
            new Question("Who wrote 'Hamlet'?", new String[]{"Mark Twain", "Charles Dickens", "William Shakespeare", "Jane Austen"}, 'C')
        };
        int score = 0;
        // Loop through each question
        for (Question question : questions) {
            question.display();
            System.out.print("Your answer (A, B, C, D): ");
            char answer = scanner.next().charAt(0);

            // Check the answer and update score
            if (question.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was " + question.correctAnswer + ".");
            }
            System.out.println();
        }
        // Display the final score
        System.out.println("You scored " + score + " out of " + questions.length + "!");
        scanner.close();
    }
}
