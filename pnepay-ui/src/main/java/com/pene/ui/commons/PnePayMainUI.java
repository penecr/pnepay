package com.pene.ui.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.pene.navigator.PnePayNavigator;
import com.pene.ui.facturi.FacturiLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = PnePayMainUI.NAME)
@Title("PnePay")
@Theme("valo")
public class PnePayMainUI extends UI {

	public static final String NAME = "/ui";

	private Panel changeTab = new Panel();
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private PnePayLogoLayoutFactory pnePayLogo;
	
	@Autowired
	private PnePayMenuFactory pnepayMenuFactory;
	
	@Autowired
	private SpringViewProvider viewProvider;
	
	@Override
	protected void init(VaadinRequest request) {
		changeTab.setHeight("100%");
		
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel contentPanel=new Panel();
			contentPanel.setWidth("100%");
			contentPanel.setHeight("100%");
		
		Panel logoPanel= new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeight("100%");
		
		HorizontalLayout uiLayout=new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(true);
		
		Component logo = pnePayLogo.createComponent() ;
		Component menu= pnepayMenuFactory.createComponent();
		
		uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTab);
		
		uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
		
		uiLayout.setExpandRatio(menu, 1);
		uiLayout.setExpandRatio(changeTab, 2);
		
		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);

		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);
		
		initNavigator();
		
		setContent(rootLayout);

	}
	
	private void initNavigator() {
	
	PnePayNavigator navigator = new PnePayNavigator(this, changeTab);
	applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
	navigator.addProvider(viewProvider);
	navigator.navigateTo(FacturiLayoutFactory.Name);
	}
}
