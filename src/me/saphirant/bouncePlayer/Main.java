package me.saphirant.bouncePlayer;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{
	
	public boolean bounce = false;
	

	
	@Override
	public void onDisable() {
		
		
	}
	
	@Override
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(this, this);
		
	}
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String cl,String[]args){
		Player p = (Player) sender;
		if(cl.equalsIgnoreCase("bounce")){
			if(bounce == false){
				bounce = true;
				p.sendMessage(ChatColor.GREEN + "Vous activez le rebondissement");
				float x = (float) -1 + (float) (Math.random() * ((1 - -1) + 1));
			    float y = (float) -5 + (float)(Math.random() * ((5 - -5) + 1));
			    float z = (float) -0.3 + (float)(Math.random() * ((0.3 - -0.3) + 1));
				p.setVelocity(new Vector(x,y,z));
				return true;
			}else {
				bounce = false;
				p.sendMessage(ChatColor.RED + "Vous desactiver le rebondissement");
				return true;
			}
			
		}
		
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerMove(PlayerMoveEvent e){
		e.setCancelled(false);
		if(bounce == true){
			if(e.getPlayer().isOnGround()){

			
			float x = (float) -1 + (float) (Math.random() * ((1 - -1) + 1));
		    float y = (float) -5 + (float)(Math.random() * ((5 - -5) + 1));
		    float z = (float) -0.3 + (float)(Math.random() * ((0.3 - -0.3) + 1));
			e.getPlayer().setVelocity(new Vector(x,y,z));
			e.getPlayer().playEffect(e.getPlayer().getLocation(), Effect.BLAZE_SHOOT, 100);
			e.getPlayer().playEffect(e.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 100);

			}
		}
		
		
	}
	
	


}
