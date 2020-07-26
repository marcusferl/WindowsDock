package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class IconHandling {
	





public void getImage(ArrayList<String> iconPath, ArrayList<String> startPath) {
	
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Set Icon");
	
	File file = fileChooser.showOpenDialog(null);
	
	iconPath.add(file.getAbsolutePath());

	
	if(file != null ) {
		File file2 = fileChooser.showOpenDialog(null);
		startPath.add(file2.getAbsolutePath());

	}
}

	
public void addIcon(ImageView icon, ArrayList<String> iconPath, ArrayList<String> startPath, FlowPane flowPane) {
	    getImage(iconPath,startPath);
		icon = new ImageView(new Image("file:///" + iconPath.get(iconPath.size() -1) , 54,54,false,false ));
		icon.setScaleX(0.8);
		icon.setScaleY(0.8);
		
		ZoomIn(icon);
		ZoomOut(icon);
		flowPane.getChildren().add(icon);
		clickIcon(iconPath.size() -1,icon,iconPath,startPath);
		try {
			saveDock(iconPath,startPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
//		ContextMenu iconMenue = new ContextMenu();
//		MenuItem RemoveIcon = new MenuItem("Remove");
//		iconMenue.getItems().addAll(RemoveIcon);
//		
//	icon.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//		@Override
//		public void handle(MouseEvent event) {
//			if(event.getButton() == MouseButton.SECONDARY) {
//				mainMenue.menue.hide();
//				iconMenue.show(flowPane, event.getScreenX(),event.getScreenY());
//				
//			}
//			
//		}
//	});
	
	
}
public void clickIcon(int index, ImageView icon,ArrayList<String> iconPath, ArrayList<String> startPath) {
	icon.setOnMouseClicked(new EventHandler<MouseEvent>() {

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
	}

// Menu
public void iconMenu(Scene scene, Stage primaryStage, Parent root) {
	
	
}

// Zoom

public void ZoomIn(ImageView icon) {
	icon.setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			icon.setScaleX(1.0);
			icon.setScaleY(1.0);

		}
	});
}

public void ZoomOut(ImageView icon) {
	icon.setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			icon.setScaleX(0.8);
			icon.setScaleY(0.8);
		}
	});
}
// Save Icons and StartPaths

public void saveDock(ArrayList<String> iconPath, ArrayList<String> startPath) throws IOException {
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


}

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
	ZoomIn(icon);
	ZoomOut(icon);
	clickIcon(i,icon,iconPath,startPath);
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
