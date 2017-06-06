package com.palindrome;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HighestPalindrome extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// Layout of UI Componets
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Largest Palindrome");

		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPadding(new Insets(25, 25, 25, 25));
		// Scene title layout
		Text scenetitle = new Text("Largest Palindrome Search");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
		layout.add(scenetitle, 0, 0, 2, 1);
		// Defining first input field
		Label input1 = new Label("Lower Bound:");
		layout.add(input1, 0, 1);
		TextField I1 = new TextField();
		layout.add(I1, 1, 1);
		// Defining second input field
		Label input2 = new Label("Upper Bound:");
		layout.add(input2, 0, 2);
		TextField I2 = new TextField();
		layout.add(I2, 1, 2);
		// Defining search button field
		Button BTTN = new Button("Search");
		HBox hbBTTN = new HBox(10);
		hbBTTN.setAlignment(Pos.BOTTOM_RIGHT);
		hbBTTN.getChildren().add(BTTN);
		layout.add(BTTN, 1, 3);
		// layout of result area
		final Label label = new Label();
		GridPane.setConstraints(label, 0, 4);
		GridPane.setColumnSpan(label, 2);
		layout.getChildren().add(label);
		// Handling the button when clicked
		BTTN.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				try {
					int value1 = Integer.parseInt(I1.getText());
					int value2 = Integer.parseInt(I2.getText());
					int highest_num = palindromeSearch(value1, value2);// Calling
																		// PalindromeSearch
																		// Method
					if (highest_num >= 0) {
						label.setTextFill(Color.GREEN);// Highlighting the
														// Answer!
						label.setText("Largest palindrome is : " + highest_num);
					} else {
						label.setTextFill(Color.RED);// Highlighting the Error!
						label.setText("Error: Palindrome number cannot be found for the given range");
					}

					// Exception Handling
				} catch (NumberFormatException e1) {
					System.out.println("Error: Either of the value is not a number");
					label.setTextFill(Color.RED);// Highlighting the Error!
					label.setText("Error: Either of the value is not a number");

				}
			}

		});

		// Layout of window
		Scene scene = new Scene(layout, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	// PalindromSearch Method

	public int palindromeSearch(int v1, int v2) {

		int i, sum = 0, temp;// Declaring variables
		boolean pCheck = false;

		// Logic to print Largest Palindrome between given user inputs
		{
			for (i = v2; i >= v1; i--) {
				sum = 0;
				temp = i;
				while (temp != 0) {
					int rem = temp % 10;
					temp = temp / 10;
					sum = (sum * 10) + rem;
				}
				if (i == sum) {
					System.out.println(i);
					pCheck = true;
					break;
				}
			}
		}
		if (pCheck == true)
			return i;
		else
			return -1;
	}
}
