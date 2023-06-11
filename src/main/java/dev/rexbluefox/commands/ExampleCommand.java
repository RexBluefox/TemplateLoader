package dev.rexbluefox.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("You are not a Player. ;(");
            return true;
        }
        Player player = (Player) commandSender;
        player.sendMessage("Hello :)");
        return false;
    }
}
