/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuketech.servoy.camplugin;

import com.servoy.j2db.plugins.IClientPlugin;
import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.plugins.PluginException;
import com.servoy.j2db.preference.PreferencePanel;
import com.servoy.j2db.scripting.IScriptObject;
import java.beans.PropertyChangeEvent;
import java.net.URL;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author mccourt
 */
public class camPlugin implements IClientPlugin {
	
private camPluginProvider provider;

    @Override
    public Icon getImage() {
		String iconPath = "images/webcam.png";
		URL iconUrl = getClass().getResource(iconPath);
		if (iconUrl != null) {
			return new ImageIcon(iconUrl);
		} else {
			return null;
		}
	}


    @Override
	public String getName() {
		String name = "Webcam";
	    return name;
	}


	public PreferencePanel[] getPreferencePanels() {
		return null;
	}

    @Override
	public IScriptObject getScriptObject() {
		if (provider == null) {
			provider = new camPluginProvider();
		}
		return provider;
	}


    @Override
	public void initialize(IClientPluginAccess arg0) throws PluginException {
		// ignore
	}

    @Override
	public Properties getProperties() {
		Properties props = new Properties();
		props.put(DISPLAY_NAME, getName());
		return props;
	}


    @Override
	public void load() throws PluginException {
		// ignore
	}

    @Override
	public void unload() throws PluginException {
		provider = null;
	}


    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		// ignore
	}

}
