package ru.frostdelta.bootsboosted;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class JetPack implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();
        if(pl.getInventory().getBoots() == null){
            return;
        }
        ItemStack item = pl.getInventory().getBoots();
        if(!item.isSimilar(Utils.create(2))) {
            return;
        }
        if(item.isSimilar(Utils.create(2))) {
            if (pl.getGameMode() != GameMode.CREATIVE && pl.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR && !pl.isFlying()) {
                pl.setAllowFlight(true);
            }
        }
        Location f = e.getFrom().clone();
        Location t = e.getTo().clone();
        Vector dir = t.subtract(f).toVector().normalize();
        if(!(Double.isNaN(dir.getX()) && Double.isNaN(dir.getY()) && Double.isNaN(dir.getZ()))) {
            if(dir.getY() < 0) {
                if(Math.abs(dir.getBlockY()) > Math.abs(dir.getX()) && Math.abs(dir.getY()) > Math.abs(dir.getZ())) {
                    pl.setVelocity(dir.multiply(0.3d));
                    pl.playEffect(pl.getEyeLocation(), Effect.MOBSPAWNER_FLAMES, 0);
                }
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

        if(item.isSimilar(Utils.create(2))) {
            e.setCancelled(true);
            p.setAllowFlight(false);
            p.setFlying(false);

            Vector v = p.getLocation().getDirection();
            v.setY(0).normalize().multiply(4).setY(300.5);
            p.setVelocity(v);
        }
    }

}
