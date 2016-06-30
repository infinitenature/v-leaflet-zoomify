package org.vaadin.addon.leafletzoomify.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leafletzoomify.LZoomifiyLayer;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("LZoomifyLayer Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "org.vaadin.addon.leafletzoomify.demo.DemoWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		// Initialize our new UI component
		final LMap leafletMap = new LMap();

		leafletMap.setHeight("100%");
		leafletMap.setCenter(0, 0);
		leafletMap.setMinZoom(0);
		leafletMap.setMaxZoom(5);
		LZoomifiyLayer layer = new LZoomifiyLayer(
				"http://cmulders.github.io/Leaflet.Zoomify/examples/hubble-orion-nebula/{g}/{z}-{x}-{y}.jpg", 6000,
				6000, "&copy; NASA, ESA, M. Robberto and the Hubble Space Telescope Orion Treasury Project Team'");

		leafletMap.addLayer(layer);

		// Show it in the middle of the screen
		final VerticalLayout layout = new VerticalLayout();

		layout.setStyleName("demoContentLayout");
		layout.setSizeFull();
		layout.addComponent(leafletMap);
		layout.setComponentAlignment(leafletMap, Alignment.MIDDLE_CENTER);
		setContent(layout);

	}

}
