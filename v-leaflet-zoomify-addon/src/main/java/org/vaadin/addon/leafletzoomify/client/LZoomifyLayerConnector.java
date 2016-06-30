package org.vaadin.addon.leafletzoomify.client;

import org.peimari.gleaflet.client.TileLayer;
import org.peimari.gleaflet.client.TileLayerOptions;
import org.peimari.gleaflet.zoomify.client.ZoomifyLayer;
import org.peimari.gleaflet.zoomify.client.ZoomifyLayerOptions;
import org.vaadin.addon.leaflet.client.LeafletTileLayerConnector;
import org.vaadin.addon.leafletzoomify.LZoomifiyLayer;

import com.vaadin.shared.ui.Connect;

@Connect(LZoomifiyLayer.class)
public class LZoomifyLayerConnector extends LeafletTileLayerConnector {
	
	@Override
	protected ZoomifyLayerOptions createOptions() {
		ZoomifyLayerOptions o = super.createOptions().cast();
		LeafletZoomifiyLayerState s = getState();
		if (s.imageWidth != null) {
			o.setWidth(s.imageWidth);
		}
		if (s.imageHeight != null) {
			o.setHeight(s.imageHeight);
		}
		return o;
	}

	@Override
	protected TileLayer createTileLayer(TileLayerOptions o) {
		return ZoomifyLayer.create(getState().url, o);
	}

	@Override
	public LeafletZoomifiyLayerState getState() {
		return (LeafletZoomifiyLayerState) super.getState();
	}
}
