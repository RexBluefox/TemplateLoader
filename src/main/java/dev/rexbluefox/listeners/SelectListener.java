package dev.rexbluefox.listeners;

import dev.rexbluefox.commands.CreateTemplate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import static dev.rexbluefox.commands.CreateTemplate.*;

public class SelectListener implements Listener {
    private int counter = 0;
    private Block startBlock;
    private Block endBlock;
    @EventHandler
    public void onBlockClick(PlayerInteractEvent event){
        ItemStack item = event.getItem();
        if (isSelecting() && item.getType() == Material.BLAZE_ROD && event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (counter < 2){
                    counter++;
                }
                Location blockLocation = event.getClickedBlock().getLocation();
                event.getPlayer().sendMessage("You clicked a block at " + blockLocation.getBlockX() + " " + blockLocation.getBlockY() + " "+ blockLocation.getBlockZ());
                if (counter == 1){
                    startBlock = event.getClickedBlock();
                }
                if (counter == 2){
                    counter = 0;
                    endBlock = event.getClickedBlock();
                    setSelecting(false);
                    AreaStuff(startBlock,endBlock);
                }

        }
    }

}
