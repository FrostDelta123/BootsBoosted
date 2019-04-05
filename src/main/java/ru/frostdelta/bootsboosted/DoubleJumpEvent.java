package ru.frostdelta.bootsboosted;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

public class DoubleJumpEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.getInventory().getBoots() == null){
            return;
        }
        ItemStack item = p.getInventory().getBoots();
        if(item.isSimilar(Utils.create(1))) {
            if (p.getGameMode() != GameMode.CREATIVE && p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR && !p.isFlying()) {
                p.setAllowFlight(true);
            }
        }
    }

    @EventHandler
    public void onPlayerFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if(p.getInventory().getBoots() == null){
            return;
        }
        ItemStack item = p.getInventory().getBoots();
        if (p.getGameMode() == GameMode.CREATIVE) { return; }
        if(item.isSimilar(Utils.create(1))) {
            e.setCancelled(true);
            p.setAllowFlight(false);
            p.setFlying(false);
            p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
        }
    }
}
