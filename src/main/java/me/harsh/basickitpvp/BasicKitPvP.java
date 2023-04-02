package me.harsh.basickitpvp;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class BasicKitPvP extends JavaPlugin {

    private static File file;
    private static FileConfiguration fileConfiguration;

    @Override
    public void onEnable() {
        file = new File(getDataFolder(), "player_data.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        saveConfigurations();
        getLogger().info(ChatColor.GREEN + "Enabling Basic Kit Pvp By WhoEvilGenius!");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("kitpvp").setExecutor(new MoneyCommand());
    }

    private static void saveConfigurations(){
        try{
            fileConfiguration.save(file);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void setKills(Player player, int kills){
        getDataConfig().set(player.getUniqueId().toString() + ".kills", kills);
        saveConfigurations();
    }
    public static void addKill(Player player){
        setKills(player, getKills(player) + 1);
    }
    private static int getKills(Player player){
        if (getDataConfig().isSet(player.getUniqueId().toString() + ".kills"))
            return getDataConfig().getInt(player.getUniqueId().toString() + ".kills");

        setKills(player, 0);
        return 0;
    }

    private static void setDeaths(Player player, int deaths){
        getDataConfig().set(player.getUniqueId().toString() + ".deaths", deaths);
        saveConfigurations();
    }
    public static void addDeath(Player player){
        setDeaths(player, getDeaths(player) + 1);
    }
    private static int getDeaths(Player player){
        if (getDataConfig().isSet(player.getUniqueId().toString() + ".deaths"))
            return getDataConfig().getInt(player.getUniqueId().toString() + ".deaths");

        setDeaths(player, 0);
        return 0;
    }

    public static void setMoney(Player player, int money){
        getDataConfig().set(player.getUniqueId().toString() + ".money", money);
        saveConfigurations();
    }
    public static void addMoney(Player player){
        setMoney(player, getMoney(player) + 1);
    }
    public static int getMoney(Player player){
        if (getDataConfig().isSet(player.getUniqueId().toString() + ".money"))
            return getDataConfig().getInt(player.getUniqueId().toString() + ".money");

        setMoney(player, 0);
        return 0;
    }

    public static void tell(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static FileConfiguration getDataConfig() {
        return fileConfiguration;
    }
}
