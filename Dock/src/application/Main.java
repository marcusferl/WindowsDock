package application;


import java.io.IOException;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Menu;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Main extends Application {

	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();// Größe vom Bildschirm abspeichern

	final String tooltip[] = { "Internet", "Email", "Eclipse","SourceCode", "Android Studio", "Home", "Arbeitsplatz", "Notizen",
			"Einstellungen" };

	final String[] icons = { "internet.png", "thunderbird.png", "eclipse.png","j.png", "android.png", "user.png",
			"arbeitsplatz.png", "note.png", "system.png" };
	
	Menu rightclick = new Menu();

	@Override
	public void start(Stage primaryStage) {
		try {

			//
			Group root = new Group();

			// Dock
			ImageView dock = new ImageView("dock.png");
			dock.setTranslateX(30);
			dock.setTranslateY(115);
			dock.setScaleX(0.9);
			dock.setScaleY(0.8);
			root.getChildren().add(dock);

			// Dock exit
			dock.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if (event.getButton().equals(MouseButton.PRIMARY)) {
						if (event.getClickCount() == 2) {
							Platform.exit();
						}
					}

				}
			});
			
			
			
			
			// Add icons
			for (int i = 0; i < icons.length; i++) {
				final ImageView icon = new ImageView(new Image(icons[i]));
				root.getChildren().add(icon);
				icon.setTranslateX(90 + 75 * i);
				icon.setTranslateY(90);
				icon.setScaleX(0.8);
				icon.setScaleY(0.8);
				icon.setEffect(new Reflection(0.5,0.45,0.45,0.5));
				ZoomIn(icon);
				ZoomOut(icon);
				Tooltip.install(icon, new Tooltip(tooltip[i]));
				clickIcon(i, icon);
			}
			
			
			
	        
	        
	        // Scene
			Scene scene = new Scene(root, 800, 200);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setFill(Color.TRANSPARENT);
			primaryStage.setX(screenSize.getWidth() -1350);
			primaryStage.setY(screenSize.getHeight() - 120);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			Image taskIcon = new Image("taskicon.png");
			primaryStage.getIcons().add(taskIcon);
			primaryStage.show();
			
			RightClickMenu menue = new RightClickMenu();
			menue.contextMenu(dock,scene);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

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

	public void clickIcon(int index, ImageView icon) {
		icon.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
				if (index == 0 ) {
					String path = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
					startProgramm(path);
				} else if (index == 1) {
					String path = "C:\\Program Files\\Mozilla Thunderbird\\thunderbird.exe";
					startProgramm(path);
				} else if (index == 2) {
					String path = "C:\\Users\\blues\\eclipse\\java-2020-03\\eclipse\\eclipse.exe";
					startProgramm(path);
				} else if (index == 3) {
					String path = "java -jar C:\\Users\\blues\\FxApps\\SourceCode.jar";
					startProgramm(path);
				} else if (index == 4) {
					String path = "C:\\Program Files\\Android\\Android Studio\\bin";
				} else if (index == 5) {
					String command = "cmd.exe /c start " + "C:\\Users\\blues";
					try {
						Process child = Runtime.getRuntime().exec(command);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (index == 6) {
					String command = "cmd.exe /c start " + "C:\\";
					try {
						Process child = Runtime.getRuntime().exec(command);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (index == 7) {
					String command = "cmd.exe /c start " + "C:\\Onenote.url";
					try {
						Process child = Runtime.getRuntime().exec(command);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// startProgramm(path);
				} else if (index == 8) {
					String path = "C:\\WINDOWS\\system32\\control.exe";
					startProgramm(path);
				}

			}
			}
		});
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
//Ui
	public static void main(String[] args) {
		launch(args);
	}
}
