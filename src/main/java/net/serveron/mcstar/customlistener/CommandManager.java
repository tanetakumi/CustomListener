package net.serveron.mcstar.customlistener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager implements CommandExecutor, TabCompleter {
    public CustomListener plugin;

    public CommandManager(CustomListener plugin){
        this.plugin = plugin;
        plugin.getCommand("cl").setExecutor(this);
    }

    private void Notify(String text) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission("op")) {
                p.sendMessage(ChatColor.AQUA + text);
            }
        }
    }

    private int stringToInt(String str){
        int x = 0;
        try{
            x = Integer.parseInt(str);
        } catch(Exception ignored){
        }
        return x;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot use commands with the console.");
            return true;
        }
        Player player = (Player) sender;

        if (args.length > 1) {

        }
        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String command, String[] args) {
        List<String> autoComplete = new ArrayList<>();
        if(sender.hasPermission("cg")) {

            if (args.length == 1) {//一段目
                autoComplete.addAll(Arrays.asList("tag", "teambattle", "blockrun", "escaping"));
            } else if (args.length > 1) {//二段目
            }
        }

        //文字比較と削除-----------------------------------------------------
        //Collections.sort(autoComplete);
        autoComplete.removeIf(str -> !str.startsWith(args[args.length - 1]));
        //------------------------------------------------------
        return autoComplete;
    }
}
