package application;
	

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	ArrayList<String> iconPath = new ArrayList<String>();
	ArrayList<String> startPath = new ArrayList<String>();
	ImageView icon;
	

	@FXML
	FlowPane flowPane;
	
	IconHandling iconHandle = new IconHandling();
	Menue menue= new Menue();

	@Override
	public void start(Stage primaryStage) {
		
		
		 
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Ui.fxml"));
			
			Scene scene = new Scene(root,400,400);
			
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setX(1200);
			primaryStage.setY(40);
		
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add("stylesCss/default.css");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			

			
			// Menue
			
	
		menue.contextMenu(scene, primaryStage,root,icon,iconPath,startPath,flowPane);
		
		
		
		
		// Move Window
		
			root.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();
					
				}
			});
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					primaryStage.setX(event.getScreenX() - xOffset);
					primaryStage.setY(event.getScreenY() - yOffset);
					
				}
			});
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
	launch(args);
	}
	
	}
 

