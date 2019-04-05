package ru.frostdelta.bootsboosted;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static ItemStack create(int type){
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        String displayName = type==1 ? "JumpBoots" : "JetPack";
        meta.setDisplayName(displayName);
        List<String> lore = new ArrayList<String>();
        lore.add(type==1 ? "JumpBoots" : "JetPack");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
