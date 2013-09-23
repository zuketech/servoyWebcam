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

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IClientPlugin#getImage()
	 */
	/**
     *
     * @return
     */
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

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IClientPlugin#getName()
	 */
    @Override
	public String getName() {
		String name = "Webcam";
	    return name;
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IClientPlugin#getPreferencePanels()
	 */
	public PreferencePanel[] getPreferencePanels() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IClientPlugin#getScriptObject()
	 */
    @Override
	public IScriptObject getScriptObject() {
		if (provider == null) {
			provider = new camPluginProvider();
		}
		return provider;
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IClientPlugin#initialize(com.servoy.j2db.plugins.IClientPluginAccess)
	 */
    @Override
	public void initialize(IClientPluginAccess arg0) throws PluginException {
		// ignore
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IPlugin#getProperties()
	 */
    @Override
	public Properties getProperties() {
		Properties props = new Properties();
		props.put(DISPLAY_NAME, getName());
		return props;
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IPlugin#load()
	 */
    @Override
	public void load() throws PluginException {
		// ignore
	}

	/* (non-Javadoc)
	 * @see com.servoy.j2db.plugins.IPlugin#unload()
	 */
    @Override
	public void unload() throws PluginException {
		provider = null;
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
    @Override
	public void propertyChange(PropertyChangeEvent evt) {
		// ignore
	}

}
