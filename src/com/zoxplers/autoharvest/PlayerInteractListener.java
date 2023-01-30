package com.zoxplers.autoharvest;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener
{
	//Variables
	ArrayList<Material> crops;
	
	//Constructor
	public PlayerInteractListener()
	{
		crops = new ArrayList<Material>();
		crops.add(Material.WHEAT);
		crops.add(Material.CARROTS);
		crops.add(Material.POTATOES);
		crops.add(Material.BEETROOTS);
		crops.add(Material.COCOA);
		crops.add(Material.NETHER_WART);
	}
	
	//Functions
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{	
		Block block = event.getClickedBlock();
		if(block != null && crops.contains(block.getType()) && block.getBlockData() instanceof Ageable)
		{
			Ageable ageable = (Ageable)block.getBlockData();
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK && ageable.getAge() == ageable.getMaximumAge())
			{
				if(block.breakNaturally(event.getPlayer().getInventory().getItemInMainHand()))
				{
					ageable.setAge(0);
					event.getClickedBlock().setBlockData(ageable);
				}
			}
		}
	}
}
