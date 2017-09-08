package org.vaadin.addon.leafletzoomify.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.shared.Crs;
import org.vaadin.addon.leafletzoomify.LZoomifiyLayer;

import com.vaadin.annotations.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;

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
		leafletMap.setCrs(Crs.Simple);
		leafletMap.setHeight("100%");

		leafletMap.setView(0d, 0d, 0d);

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
