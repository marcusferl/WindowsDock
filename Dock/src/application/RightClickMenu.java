package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;

public class RightClickMenu {

	public void contextMenu(ImageView dock, Scene scene) {
		// Create ContextMenu
		ContextMenu contextMenu = new ContextMenu();
		MenuItem item0 = new MenuItem("Open Menu");
		MenuItem item1 = new MenuItem("Add Icon");
		MenuItem item2 = new MenuItem("Close Dock");

		// Öffnet neues Menu
		Menu parentMenu = new Menu("Style");
		RadioMenuItem pItem = new RadioMenuItem("Transparent");
		RadioMenuItem pItem2 = new RadioMenuItem("Withe");
		RadioMenuItem pItem3 = new RadioMenuItem("Grey");
		RadioMenuItem pItem4 = new RadioMenuItem("New");
		
		ToggleGroup group = new ToggleGroup();
		pItem.setToggleGroup(group);
		pItem2.setToggleGroup(group);
		pItem3.setToggleGroup(group);
		pItem4.setToggleGroup(group);

		parentMenu.getItems().addAll(pItem, pItem2, pItem3, pItem4);

		// Parent Menu Events
		pItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dock.setVisible(false);

			}
		});
		pItem2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dock.setImage(new Image("dockwithe.png"));
				defaultDock(dock);

			}
		});
		pItem3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dock.setImage(new Image("dock.png"));
				defaultDock(dock);

			}
		});
		pItem4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dock.setVisible(false);
				

			}
		});

		// Context Menu Events
		contextMenu.getItems().addAll(item0, parentMenu, item1, item2);

		dock.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

			@Override
			public void handle(ContextMenuEvent event) {

				contextMenu.show(dock, event.getScreenX(), event.getScreenY() - 100);
			}
		});

		item2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();

			}
		});
	}

	public void defaultDock(ImageView dock) {
		dock.setTranslateX(30);
		dock.setTranslateY(115);
		dock.setScaleX(0.9);
		dock.setScaleY(0.8);
	}
}
