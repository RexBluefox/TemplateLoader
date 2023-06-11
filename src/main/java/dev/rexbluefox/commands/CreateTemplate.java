package dev.rexbluefox.commands;

import dev.rexbluefox.types.Template;
import dev.rexbluefox.types.TemplateBlock;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static dev.rexbluefox.Main.templates;
import static dev.rexbluefox.commands.LoadTemplate.counters;


public class CreateTemplate implements CommandExecutor {
    private static boolean selecting = false;
    private static Template template;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Sorry. You cant create a Template. Only Players can create Templates");
            return false;
        }
        if (strings.length > 1){
            commandSender.sendMessage(ChatColor.RED + "This command only accepts on Argument. [name]");
            return false;
        }
        String templateName = strings[0];
        for (Template template : templates){
            if (template.getName().equals(templateName)){
                commandSender.sendMessage(ChatColor.RED + "There already exists a Template with this name");
                return false;
            }
        }
        Player player = (Player) commandSender;
        commandSender.sendMessage(ChatColor.GREEN + "Creating Template: " + ChatColor.GRAY + templateName);
        template = new Template(templateName);
        player.getInventory().addItem(new ItemStack(Material.BLAZE_ROD));
        player.sendMessage(ChatColor.GREEN + "You received a Blazerod. Select an area to create a Template");
        selecting = true;
        return true;
    }

    public static void AreaStuff(Block startBlock, Block endBlock){
        ArrayList<Block> selection = new ArrayList<Block>();
        Bukkit.broadcastMessage("Yeah");
        World world = startBlock.getWorld();
        startBlock.setType(Material.GOLD_BLOCK);
        endBlock.setType(Material.GOLD_BLOCK);
        Location startLocation = startBlock.getLocation();
        int stepX = (endBlock.getX() >= startBlock.getX()) ? 1 : -1;
        int stepY = (endBlock.getY() >= startBlock.getY()) ? 1 : -1;
        int stepZ = (endBlock.getZ() >= startBlock.getZ()) ? 1 : -1;
        Bukkit.broadcastMessage(stepX + " " + stepY + " "+ stepZ);
        for (int x = 0; (stepX > 0) ? x <= endBlock.getX()-startBlock.getX() : x >= endBlock.getX()-startBlock.getX(); x += stepX) {
            for (int y = 0; (stepY > 0) ? y <= endBlock.getY()-startBlock.getY() : y >= endBlock.getY()-startBlock.getY(); y += stepY) {
                for (int z = 0; (stepZ > 0) ? z <= endBlock.getZ()-startBlock.getZ() : z >= endBlock.getZ()-startBlock.getZ(); z += stepZ) {
                    Block worldBlock = world.getBlockAt(startBlock.getX()+x,startBlock.getY()+y,startBlock.getZ()+z);
                    Block newBlock = new TemplateBlock(world, x, y, z, worldBlock.getType(),worldBlock.getState());
                    selection.add(newBlock);
                    //String blockName = world.getBlockAt(x,y,z).getType().name();
                }
            }
        }
        for (Block block : selection) {
            Bukkit.broadcastMessage(block.getLocation().toString());
        }
        template.setTemplate(selection);
        counters.put(template,1);
        Bukkit.broadcastMessage(counters.values().toString());
        templates.add(template);
    }


    public static void setSelecting(boolean selecting){
        CreateTemplate.selecting = selecting;
    }

    public static boolean isSelecting() {
        return selecting;
    }
}
