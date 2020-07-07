/*
 * GradeCalculator.java
 * Author:  Katherine Bonds
 * Submission Date:  6/26/2020
 *
 * Purpose: To calculate a students current grade in a course while also
 * finding the average score they will need to achieve a certain letter grade.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
//import Java Scanner
import java.util.Scanner; 

public class GradeCalculator {

	public static void main(String[] args) {
		// Call Scanner 
		Scanner keyboard = new Scanner(System.in);

		//define variables
		int weights = 0;
		int scores = 0;
		int userScore = 0;
		double finalOverallScore = 0;
		double totalKnownGradeWeight = 0;
		String currentLetterGrade;
		
		//Print Grading Scale
		System.out.println("Grading Scale:");
		System.out.println("A \t 90 - 100");
		System.out.println("B \t 80 - 89");
		System.out.println("C \t 70 - 79");
		System.out.println("D \t 60 - 69");
		System.out.println("F \t below 60");
		System.out.print("What letter grade do you want to achieve for the course?");
		String desiredGrade = keyboard.next(); // Ask and store user's desired course grade
		keyboard.nextLine();
		
		//checks to make sure user input acceptable letter grade
		if ((desiredGrade.equalsIgnoreCase("A")) || (desiredGrade.equalsIgnoreCase("B")) || 
				(desiredGrade.equalsIgnoreCase("C")) || (desiredGrade.equalsIgnoreCase("D")) || 
				(desiredGrade.equalsIgnoreCase("F"))) {
		
			System.out.println("Enter percentage weights below.");
			System.out.print("Exam 1:  \t"); //Ask and store user Exam 1
			int exam1 = keyboard.nextInt();
			
			System.out.print("Exam 2:  \t"); //Ask and store user Exam 2
			int exam2 = keyboard.nextInt();
	
			System.out.print("Final Exam:  \t"); //Ask and store user Final Exam
			int finalExam = keyboard.nextInt();
	
			System.out.print("Labs:  \t \t"); //Ask and store user Labs
			int labs = keyboard.nextInt();
	
			System.out.print("Projects:  \t"); //Ask and store user Projects
			int projects = keyboard.nextInt();
	
			System.out.print("Participation:  "); //Ask and store user Participation
			int participation = keyboard.nextInt();
	
			System.out.print("Quizzes:  \t"); //Ask and store user Quizzes
			int quizzes = keyboard.nextInt();
			keyboard.nextLine();
			
			//adds user percentage weights to determine if amounts = 100
			int percentageWeights= (exam1 + exam2 + finalExam + labs + projects + participation + quizzes);
			if (percentageWeights != 100) {
				System.out.println("Weights don't add up to 100, program exiting...");
				System.exit(0);
			}
			
			//request user exam 1, 2, and final score -> full execute only if previous exam score is known
			System.out.print("Do you know your exam 1 score?");
			String know_exam1 = keyboard.nextLine();
			if (know_exam1.equalsIgnoreCase("Y") || know_exam1.equalsIgnoreCase("Yes")){ //if know_exam1 == yes, program asks user what score was
				System.out.print("Score received on exam 1:");
				userScore = keyboard.nextInt(); //stores user input to userScore
				keyboard.nextLine();
				scores += (userScore * exam1); //multiplies userScore by exam1 percentage weight and adds to scores total
				weights += exam1; //adds exam1 percentage weight to weights total
				
				System.out.print("Do you know your exam 2 score?"); //Activated after program receives exam 1 score - does not activate if no exam 1 score
				String know_exam2 = keyboard.nextLine();
				if (know_exam2.equalsIgnoreCase("Y")|| know_exam2.equalsIgnoreCase("Yes")) { //if know_exam2 == yes, program asks user what score was
					System.out.print("Score received on exam 2:");
					userScore = keyboard.nextInt();
					keyboard.nextLine();
					scores += (userScore * exam2);
					weights += exam2; //adds exam2 percentage weight to weights total
					
					System.out.print("Do you know your final exam score?"); //Activated after program receives exam 2 score - does not active if no exam 2 score
					String know_final = keyboard.nextLine();
					if (know_final.equalsIgnoreCase("Yes")|| know_final.equalsIgnoreCase("Y")) { //if know_final == yes, program asks user what score was
						System.out.print("Score received on final exam:");
						userScore = keyboard.nextInt();
						keyboard.nextLine();
						scores += (userScore * finalExam);
						weights += finalExam; //adds finalExam percentage weight to weights total
					}
				}
			}
			//request user lab average
			System.out.print("Do you know your lab average?");
			String know_lab = keyboard.nextLine();
			if (know_lab.equalsIgnoreCase("Yes")|| know_lab.equalsIgnoreCase("Y")) { //if know_lab == yes, program asks user what score was
				System.out.print("Average lab grade:");
				userScore= keyboard.nextInt();
				keyboard.nextLine();
				scores += (userScore * labs);
				weights += labs; //adds labs percentage weight to weights total
			}
			//request user project average
			System.out.print("Do you know your project average?");
			String know_project = keyboard.nextLine();
			if (know_project.equalsIgnoreCase("Yes")|| know_project.equalsIgnoreCase("Y")) { //if know_project == yes, program asks user what score was
				System.out.print("Average project grade:");
				userScore = keyboard.nextInt();
				keyboard.nextLine();
				scores += (userScore * projects);
				weights += projects; //adds projects percentage weight to weights total
			}
			//request user participation average
			System.out.print("Do you know your participation average?");
			String know_participation = keyboard.nextLine();
			if (know_participation.equalsIgnoreCase("Yes")|| know_participation.equalsIgnoreCase("Y")) { //if know_participation == yes, program asks user what score was
				System.out.print("Average participation grade:");
				userScore = keyboard.nextInt();
				keyboard.nextLine();
				scores += (userScore * participation);
				weights += participation; //adds participation percentage weight to weights total
			}
			//request user quiz average
			System.out.print("Do you know your quiz average?");
			String know_quiz = keyboard.nextLine();
			if (know_quiz.equalsIgnoreCase("Yes")|| know_quiz.equalsIgnoreCase("Y")) { //if know_quiz == yes, program asks user what score was
				System.out.print("Average quiz grade:");
				userScore = keyboard.nextInt();
				keyboard.nextLine();
				scores += (quizzes * userScore);
				weights += quizzes; //adds quizzes percentage weight to weights total
			}
			//calculates currentScore = (scores / weights) -> scores is all inputed user scores multiplied by that percentage weight
			// weights = all percentage weights added together
			Double currentScore = (double)scores/(double)weights; //converts scores & weights to double and divides
			System.out.printf("Current grade score:%.2f%n", currentScore); //prints user's current grade score from user inputs
			
			//Determine what letter grade currentScore qualifies for
			if (currentScore >= 90 && currentScore <= 100) { //currentScore 90-100 = A
				System.out.println("Your current letter grade: A");
				currentLetterGrade = "A";
			}
			else if (currentScore >= 80 && currentScore < 90) { //currentScore 80-89 = B
				System.out.println("Your current letter grade: B");
				currentLetterGrade = "B";
			}
			else if (currentScore >= 70 && currentScore < 80) { //currentScore 70-79 = C
				System.out.println("Your current letter grade: C");
				currentLetterGrade = "C";
			}
			else if (currentScore >= 60 && currentScore < 70) { //currentScore 60-69 = D
				System.out.println("Your current letter grade: D");
				currentLetterGrade = "D";
			}
			else {
				System.out.println("Your current letter grade: F"); // <60 = F
				currentLetterGrade = "F";
			}
			
			//calculate minimum score in range of letter grade user wants to achieve in course
			if (desiredGrade.equalsIgnoreCase("A")) {
				finalOverallScore = 90;
			}
			else if (desiredGrade.equalsIgnoreCase("B")) {
				finalOverallScore = 80;
			}
			else if (desiredGrade.equalsIgnoreCase("C")) {
				finalOverallScore = 70;
			}
			else if (desiredGrade.equalsIgnoreCase("D")) {
				finalOverallScore = 60;
			}
			//checks if weights = 100, if so totalKnownGradeWeights = 0 so that we are dividing by 100 in avgToFinalLetterGrade formula
			if (weights == 100) {
				totalKnownGradeWeight = 0;
			}
			else {
				totalKnownGradeWeight = weights;
			}
			
			//formula to calculate the grade average to obtain a final overall score
			double avgToFinalLetterGrade = ((100 * finalOverallScore) - (totalKnownGradeWeight * currentScore))/(100 - totalKnownGradeWeight);
			
			if (currentLetterGrade.equalsIgnoreCase(desiredGrade)) {
				System.out.println("Congratulations! you received the " + desiredGrade + " that you wanted!");
			}
			//if currentLetterGrade != desiredGrade -> else statements are checked
			else {
				if (avgToFinalLetterGrade > 100 || weights == 100) {
					System.out.println("Unfortunately, a grade of " + desiredGrade + " is not possible.");
				}
				else if (avgToFinalLetterGrade < 0) { 
					System.out.println("You will receive at least a grade of " + desiredGrade);
				}
				else {
					System.out.println("In order to receive a grade of " + desiredGrade);
					System.out.println("you need to score an average greater than");
					System.out.printf("or equal to %.2f", avgToFinalLetterGrade);
					System.out.print(" in the rest of the grade items.");
				}
			}
		}
		else { //if user input is not A, B, C, D, F -> program will print statement below and stop
			System.out.println("The input is invalid");
			System.exit(0);
		}
	}
}
