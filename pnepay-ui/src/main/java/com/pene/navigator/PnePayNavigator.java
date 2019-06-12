package com.pene.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class PnePayNavigator extends Navigator {

	public PnePayNavigator(UI ui, SingleComponentContainer container) {
		super(ui, container);
	}

	private static PnePayNavigator getNavigator() {

		UI ui = UI.getCurrent();
		Navigator navigator = ui.getNavigator();
		return (PnePayNavigator) navigator;

	}

	public static void navigate(String path) {

		try {
			
			PnePayNavigator.getNavigator().navigateTo(path);
		} 
		
		catch (Exception e) {
			return;
		}

	}
	@Override
	public void navigateTo(String viewName) {
		
		super.navigateTo(Strings.nullToEmpty(viewName));
	
	}
	
	
}
