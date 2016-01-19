package gui.view;

import javax.swing.JFrame;

import gui.controller.GUIController;

public class GUIFrame extends JFrame
{
	private GUIPanel basePanel;
	private GUIController baseController;
	
	public GUIFrame(GUIController baseController)
	{
		this.baseController = baseController;
		basePanel = new GUIPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setTitle("Not Virus");
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public GUIController getBaseController()
	{
		return baseController;
	}
}
