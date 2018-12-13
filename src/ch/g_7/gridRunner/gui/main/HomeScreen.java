package ch.g_7.gridRunner.gui.main;

import javax.swing.JPanel;


public class HomeScreen extends Screen<JPanel>{

	
	private JPanel panel = new JPanel();
	private MenuePanel menuePanel;
	private View<?> view;
	
	public HomeScreen() {
		panel.setSize(GUISize.WINDOW_CONTENT_WIDTH,GUISize.WINDOW_CONTENT_HEIGHT);
		panel.setLayout(null);
		panel.setLocation(0, 0);
	}
	
	public void setView(View<?> view) {
		if (this.view != null) {
			panel.remove(this.view.getPanel());
		}
		this.view = view;
		panel.add(view.getPanel(),0);
		panel.updateUI();
	}
	
	public void setMenuePanel(MenuePanel menuePanel) {
		this.menuePanel = menuePanel;
		panel.add(menuePanel.getPanel(),0);
	}

	@Override
	public JPanel getPanel() {
		return panel;
	}
	
	



}
