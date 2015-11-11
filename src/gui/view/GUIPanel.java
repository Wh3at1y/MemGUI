package gui.view;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.*;

import gui.controller.GUIController;

public class GUIPanel extends JPanel
{
	private JButton visButton;
	private JButton appearButton;
	private SpringLayout baseLayout;
	private GUIPopUps popUp;

	private ArrayList<String> randomNum;

	public GUIPanel(GUIController baseController)
	{
		randomNum = new ArrayList<String>();
		
		randomNum.add("8496546");
		randomNum.add("70621846");
		randomNum.add("890451");
		randomNum.add("89505");

		baseLayout = new SpringLayout();
		popUp = new GUIPopUps();
		visButton = new JButton("Show Button");
		appearButton = new JButton("LOOK! DONT CLICK");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{

		this.setLayout(baseLayout);
		this.add(visButton);
		this.add(appearButton);

		this.setBackground(Color.WHITE);

		appearButton.setVisible(false);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, visButton, 37, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, visButton, 0, SpringLayout.WEST, this);
	}

	private void setupListeners()
	{
		visButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				if (appearButton.isVisible() == false)
				{
					appearButton.setVisible(true);
				}

				else if (appearButton.isVisible() == true)
				{
					appearButton.setVisible(false);
				}
			}
		});

		appearButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				setBackground(Color.RED);
				
				int randomSelection = (int) (Math.random() * randomNum.size());
				String selectedNumber = randomNum.get(randomSelection);

				popUp.showPopUp("ERROR : Code " + selectedNumber);

				setBackground(Color.WHITE);
			}
		});
	}
}
