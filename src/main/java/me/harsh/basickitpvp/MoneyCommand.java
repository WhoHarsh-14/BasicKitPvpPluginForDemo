package me.harsh.basickitpvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MoneyCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 3){
            final Player commandSender = (Player) sender;
            final Player target = Bukkit.getPlayerExact(args[1]);
            final int amount = Integer.parseInt(args[2]);
            if (amount == -1 || amount == 0){
                BasicKitPvP.tell(commandSender, "&cPlease input correct amount!");
            }
            if (target == null){
                BasicKitPvP.tell(commandSender, "&c&lSORRY! &cWe couldn't find anyone with such name!");
                return false;
            }
            if (args[0].equalsIgnoreCase("pay")){
                BasicKitPvP.setMoney(commandSender, (BasicKitPvP.getMoney(commandSender) - amount));
                BasicKitPvP.setMoney(target, (BasicKitPvP.getMoney(commandSender) + amount));
                BasicKitPvP.tell(commandSender, "&a&lSUCCESS! &aYou just send " + amount + " coins to " + target.getDisplayName());
                BasicKitPvP.tell(target, "&a&lCONGO! &aYou just received " + amount + " coins from " + commandSender.getDisplayName());
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> tab = new ArrayList<>();
        switch (args.length){
            case 1:
                tab.add("pay");
                break;
            case 2:
                tab.addAll(getAllPlayerNames());
                break;
            case 3:
                tab.add("1");
                tab.add("2");
                tab.add("3");
                tab.add("4");
                tab.add("5");
                tab.add("6");
                tab.add("7");
                tab.add("8");
                tab.add("9");
                tab.add("10");
                tab.add("11");
                tab.add("12");
                tab.add("13");
                tab.add("14");
                tab.add("15");
                tab.add("16");
                break;
        }
        return tab;
    }

    private List<String> getAllPlayerNames(){
        final List<String> playerNames = new ArrayList<>();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            playerNames.add(onlinePlayer.getName());
        }
        return playerNames;
    }
}
