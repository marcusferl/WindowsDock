package application;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Menue{

	
	ContextMenu menue = new ContextMenu();
	int index;
	ImageView rcon;

	public void contextMenu(Scene scene, Stage primaryStage, Parent root,ImageView icon, ArrayList<String> iconPath, ArrayList<String> startPath, FlowPane flowPane) {
		
		icon = this.rcon;	
		
		MenuItem addIcon = new MenuItem("Add Icon");
		MenuItem close = new MenuItem("Close");
		MenuItem editIcon = new MenuItem("Edit Icon");
		
		
		

		Menu stylesMenu = new Menu("Style");
		Menu colors = new Menu("Colors");
		Menu position = new Menu("Positions");
		Menu window = new Menu("Windows");
		

		// Menu Colors
		RadioMenuItem red = new RadioMenuItem("Red");
		RadioMenuItem blue = new RadioMenuItem("Blue");
		RadioMenuItem standard = new RadioMenuItem("Standart");
		RadioMenuItem yellow = new RadioMenuItem("Yellow");
		RadioMenuItem snow = new RadioMenuItem("Snow");

		ToggleGroup colorsGroup = new ToggleGroup();
		red.setToggleGroup(colorsGroup);
		blue.setToggleGroup(colorsGroup);
		standard.setToggleGroup(colorsGroup);
		yellow.setToggleGroup(colorsGroup);
		snow.setToggleGroup(colorsGroup);
		
		// Menu Positions
		RadioMenuItem rightCornerTop = new RadioMenuItem("Right Corner Top");
		RadioMenuItem leftCornerTop = new RadioMenuItem("Left Corner Top");
		RadioMenuItem rightCornerBottom = new RadioMenuItem("Right Corner Bottom");
		RadioMenuItem leftCornerBottom = new RadioMenuItem("Left Corner Bottom");

		ToggleGroup positionsGroup = new ToggleGroup();
		rightCornerTop.setToggleGroup(positionsGroup);
		rightCornerBottom.setToggleGroup(positionsGroup);
		leftCornerTop.setToggleGroup(positionsGroup);
		leftCornerBottom.setToggleGroup(positionsGroup);

		// Menu Struktur
		menue.getItems().addAll(close, addIcon, editIcon, stylesMenu);
		stylesMenu.getItems().addAll(colors, window, position);
		colors.getItems().addAll(red, blue, snow, yellow,standard);
		position.getItems().addAll(rightCornerBottom, rightCornerTop, leftCornerBottom, leftCornerTop);
		

	
	// Show Context Menue
		
		
		
	
		root.addEventHandler(MouseEvent.MOUSE_CLICKED	, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
			if (event.getButton() == MouseButton.SECONDARY) {
				menue.show(root, event.getScreenX(),event.getScreenY());
			}else {
				menue.hide();
			}
				
			}
		});
		
		
		
//		scene.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
//
//			@Override
//			public void handle(ContextMenuEvent event) {
//				menue.show(root, event.getScreenX(),event.getScreenY());
//				}
//		});
		
		
		
		

		// Main Menu Methods
		
		addIcon.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Set Icon");
				
				File file = fileChooser.showOpenDialog(null);
				
				iconPath.add(file.getAbsolutePath());

				
				if(file != null ) {
					File file2 = fileChooser.showOpenDialog(null);
					startPath.add(file2.getAbsolutePath());
				}
				
				rcon = new ImageView(new Image("file:///" + iconPath.get(iconPath.size() -1) , 54,54,false,false ));
				rcon.setScaleX(0.8);
				rcon.setScaleY(0.8);
				flowPane.getChildren().add(rcon);
				try {
					 FileWriter file1 = new FileWriter("C:\\Users\\blues\\Desktop\\SourceCodes\\iconspaths.txt");
					 for (int i = 0; i < iconPath.size(); i++) {
					     file1.write(iconPath.get(i) + "\n");
					    }
					  file1.close(); 
					

				FileWriter file2 = new FileWriter("C:\\Users\\blues\\Desktop\\SourceCodes\\startPath.txt");
				for (int i = 0; i < startPath.size(); i++) {
				    file2.write(startPath.get(i) + "\n");
				   }
				 file2.close(); 

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
			}
		});
		
		// ContextMenue

		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		
		
		//Colors Menue
		
		red.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("stylesCss/red.css");
				
			}
		});
		blue.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("stylesCss/blue.css");
				
			}
		});
		yellow.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("stylesCss/yellow.css");
				
			}
		});
		standard.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("stylesCss/default.css");
				
			}
		});
		snow.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("stylesCss/snow.css");
				
			}
		});
		
		// Position Menue
		
		rightCornerBottom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setX(1200);
				primaryStage.setY(500);
			}
		});
		rightCornerTop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setX(1200);
				primaryStage.setY(40);
				
			}
		});
		leftCornerBottom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setX(0);
				primaryStage.setY(500);
				
			}
		});
		leftCornerTop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setX(0);
				primaryStage.setY(40);
				
			}
		});
	
	
		
			rcon.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					
					if (event.getButton().equals(MouseButton.PRIMARY)) {
						if (index == 0 ) {
						String path = startPath.get(index);
						startProgramm(path);
						System.out.println(startPath.get(index));
					}
					if (index == 1 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}
					if (index == 2 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}
					if (index == 3 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}
					if (index == 4 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}
					if (index == 5 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}
					if (index == 6 ) {
						String path = startPath.get(index);
						startProgramm(path);
					}

					}
					}
				});
			

		
			rcon.setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
				rcon.setScaleX(1.0);
				rcon.setScaleY(1.0);

				}
			});
		
			rcon.setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					rcon.setScaleX(0.8);
					rcon.setScaleY(0.8);
				}
			});
		}
		// Save Icons and StartPaths

		
			

		// Gets PathsOnStartup
		public void readDock(ArrayList<String> iconPath, ArrayList<String> startPath) throws IOException {
			String line;
			
			BufferedReader iconPathArray = new BufferedReader(new FileReader("C:\\Users\\blues\\Desktop\\SourceCodes\\iconspaths.txt"));
			
			while((line = iconPathArray.readLine()) != null) {
			    iconPath.add(line);
			}
			
		BufferedReader pathReader = new BufferedReader(new FileReader("C:\\Users\\blues\\Desktop\\SourceCodes\\startPath.txt"));
			
			while((line = pathReader.readLine()) != null) {
			   startPath.add(line);
			}
			iconPathArray.close();	
			pathReader.close();	
		}

		public void initialize(ArrayList<String> iconPath, ArrayList<String> startPath, ImageView icon,FlowPane flowPane){
			try {
				readDock(iconPath,startPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < iconPath.size(); i++) {
			icon = new ImageView(new Image("file:///" + iconPath.get(i) , 54,54,false,false ));
			flowPane.getChildren().add(icon);
			icon.setScaleX(0.8);
			icon.setScaleY(0.8);
			
		}
			
		}

			


		public void startProgramm(String path) {
			String cmd = path;
			try {
				System.out.println("Programm öffnet");
				Process process = Runtime.getRuntime().exec(cmd);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.getMessage();
				}
				System.out.println("Programm Ende");
				// process.destroy();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

