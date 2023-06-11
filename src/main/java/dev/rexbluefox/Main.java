package dev.rexbluefox;

import dev.rexbluefox.commands.CreateTemplate;
import dev.rexbluefox.commands.ExampleCommand;

import dev.rexbluefox.commands.LoadTemplate;
import dev.rexbluefox.listeners.SelectListener;
import dev.rexbluefox.types.Template;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    public static ArrayList<Template> templates;
    public void onEnable() {
        templates = new ArrayList<>();
        //Commands
        getCommand("example").setExecutor(new ExampleCommand());
        getCommand("createtemplate").setExecutor(new CreateTemplate());
        getCommand("loadtemplate").setExecutor(new LoadTemplate());
        //Listeners
        getServer().getPluginManager().registerEvents(new SelectListener(),this);
    }

    @Override
    public void onDisable() {
        //Bukkit.getWorlds().forEach(world -> {world.getn});
    }
}
