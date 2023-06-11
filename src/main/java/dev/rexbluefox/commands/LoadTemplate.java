package dev.rexbluefox.commands;

import dev.rexbluefox.types.Template;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static dev.rexbluefox.Main.templates;

public class LoadTemplate implements CommandExecutor {
    public static HashMap<Template,Integer> counters = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Sorry. You cant load a Template. Only Players can load Templates");
            return true;
        }
        if (strings.length > 1){
            commandSender.sendMessage(ChatColor.DARK_GRAY + "This command only accepts on Argument. [name]");
            return true;
        }
        if (strings.length == 0){
            commandSender.sendMessage(ChatColor.RED + "This command requires on Argument. [name]");
            return true;
        }
        AtomicBoolean found = new AtomicBoolean(false);
        String templateName = strings[0];
        Player player = (Player) commandSender;
        player.sendMessage("Loading 1");
        Bukkit.getWorlds().forEach(world1 -> {
            if (world1.getName().equals(templateName)) {
                for (Template template : templates) {
                    if(!found.get() && (Objects.equals(template.getName(), templateName))){
                        Bukkit.broadcastMessage("Found already existing world for "+templateName);
                        if (counters == null){
                            player.sendMessage("Counters ist null");
                        }
                        if (counters.get(template) == null){
                            player.sendMessage("Counters ist null bei diesem Template");
                        }
                        extraLoad(template,world1,player, counters.get(template));
                        counters.replace(template, counters.get(template)+1);
                        found.set(true);
                    }
                }
            }
        });
        if (found.get()){
            return false;
        }
        WorldCreator wc = new WorldCreator(templateName);
        wc.type(WorldType.FLAT);
        wc.generatorSettings("2;0;1;");
        World newWorld = wc.createWorld();


        for (Template template : templates) {
            if(!found.get() && (Objects.equals(template.getName(), templateName))){
                load(template,newWorld,player);
                found.set(true);
            }
        }
        if (!found.get()){
            player.sendMessage(ChatColor.RED + "There exists no Template with this name");
            return true;
        }
        return false;
    }
    private void load(Template template, World world, Player player){
        player.sendMessage("Loading 2");
        for (Block block : template.getTemplate()) {
            world.getBlockAt(block.getLocation().getBlockX(),
                    block.getLocation().getBlockY(),
                    block.getLocation().getBlockZ())
                    .setType(block.getType());
            world.getBlockAt(block.getLocation().getBlockX(),
                            block.getLocation().getBlockY(),
                            block.getLocation().getBlockZ());
        }
        player.teleport(new Location(world,0,0,0));
    }
    private void extraLoad(Template template, World world, Player player,int count){
        for (Block block : template.getTemplate()) {
            world.getBlockAt(block.getLocation().getBlockX()+(500*count), block.getLocation().getBlockY(), block.getLocation().getBlockZ()).setType(block.getType());
            world.getBlockAt(block.getLocation().getBlockX()+(500*count), block.getLocation().getBlockY(), block.getLocation().getBlockZ()).getState().setData(block.getState().getData());
        }
        player.teleport(new Location(world,template.getTemplate().get(0).getX()+(500*count),0,0));
    }
}
