package com.frantisekpost.lib.valid8.uidemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.frantisekpost.lib.valid8.core.Validator;
import com.frantisekpost.lib.valid8.core.impl.ValidatorFactory;
import com.frantisekpost.lib.valid8.core.presenter.BackgroundPresenter;
import com.frantisekpost.lib.valid8.core.presenter.BorderPresenter;
import com.frantisekpost.lib.valid8.core.presenter.TextPresenter;

public class DemoFrame {

	// @MaxLength(5)
	// @Custom(dataClass=TextFieldData.class, logicClass=NotNullLogic.class,
	// trigger=TextFieldTrigger.class)
//	private JTextField text;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JLabel reporterLabel = new JLabel("Not validated, or OK");
		JTextField textField = new JTextField(10);
		JPanel componentPanel = new JPanel();
		componentPanel.add(textField);
		mainPanel.add(componentPanel, BorderLayout.CENTER);

		JPanel reporterPanel = new JPanel();
		reporterPanel.add(reporterLabel);
		mainPanel.add(reporterPanel, BorderLayout.NORTH);

		//presenters will be created automatically
		TextPresenter textpresenter = new TextPresenter(reporterLabel);
		BorderPresenter borderPresenter = BorderPresenter.SHARED_INSTANCE;
		BackgroundPresenter backPresenter = new BackgroundPresenter(reporterPanel);

		//validators will be created automatically, based on annotations
		Validator<String> validator = ValidatorFactory.notEmptyTextField(textField);
		validator.getResult().addListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				textpresenter.present(validator.getResult());
				backPresenter.present(validator.getResult());
				borderPresenter.present(validator.getResult());
			}
		});

		frame.setContentPane(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
	}
}
