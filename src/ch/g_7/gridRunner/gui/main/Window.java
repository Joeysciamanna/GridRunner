package ch.g_7.gridRunner.gui.main;

import javax.swing.JFrame;

import ch.g_7.gridEngine.field.building.FieldCreationRegister;
import ch.g_7.gridRunner.fields.creation.GridRunnerFieldFactory;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static Window instance;
	private Screen<?> screen;

	private Window() {
		setSize(GUISize.WINDOW_WIDTH,GUISize.WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
	}
	
	public void setScreen(Screen<?> screen) {
		if (this.screen != null) {
			remove(this.screen.getPanel());
		}
		this.screen = screen;
		add(screen.getPanel(),0);
		repaint();
	}
	
	public Screen<?> getScreen(){
		return screen;
	}
	
	public static Window getInstance() {
		if(instance == null) {
			instance = new Window();
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {

		FieldCreationRegister.setDefaultFactory(new GridRunnerFieldFactory());
		HomeScreen homeScreen = new HomeScreen();
		MenueButton mainButton = new MenueButton(homeScreen, MainView.getInstance(), "Home");
		MenueButton configButton = new MenueButton(homeScreen, ConfigView.getInstance(), "Config");
		
		MenuePanel menuePanel = new MenuePanel(mainButton,configButton);
		homeScreen.setMenuePanel(menuePanel);
		homeScreen.setView(MainView.getInstance());
		
		
		Window window = Window.getInstance();
		window.setScreen(homeScreen);

		window.setVisible(true);
	}
}
