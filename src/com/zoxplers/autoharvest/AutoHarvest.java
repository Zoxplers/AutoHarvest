package com.zoxplers.autoharvest;

import org.bukkit.plugin.java.JavaPlugin;

public class AutoHarvest extends JavaPlugin
{
	private static AutoHarvest instance;
	
    @Override
    public void onEnable()
    {
    	AutoHarvest.instance = this;
    	this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }
    
    @Override
    public void onDisable()
    {
    	AutoHarvest.instance = null;
    }
    
	public static AutoHarvest getInstance()
	{
		return AutoHarvest.instance;
	}
}
