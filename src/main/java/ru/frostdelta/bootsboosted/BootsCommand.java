package ru.frostdelta.bootsboosted;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BootsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = ((Player) sender);
        Inventory inv = player.getInventory();
        if(command.getName().equalsIgnoreCase("botinok1")){
            inv.addItem(Utils.create(1));
            player.sendMessage(ChatColor.GREEN + "Предмет выдан!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("botinok2")){
            inv.addItem(Utils.create(2));
            player.sendMessage(ChatColor.GREEN + "Предмет выдан!");
            return true;
        }
        return true;
    }
}
