package me.harsh.basickitpvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event){
        final Player victim = event.getEntity().getPlayer();
        final Player killer = event.getEntity().getKiller();
        if (killer == null || victim == null) return;

        BasicKitPvP.addKill(killer);
        BasicKitPvP.addDeath(victim);
        BasicKitPvP.addMoney(killer);
        BasicKitPvP.tell(killer, "&a&lCongo! &ayou just gained 1 coin.");
        BasicKitPvP.tell(victim, "&c&lBoo! &cyou just died from " + killer.getDisplayName() + "&c.");
    }

}
