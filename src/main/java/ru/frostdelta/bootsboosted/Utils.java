package ru.frostdelta.bootsboosted;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static ItemStack create(int type){
        Material material = type==1 ? Material.GOLD_BOOTS : Material.CHAINMAIL_BOOTS;
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        String displayName = type==1 ? "JumpBoots" : "JetPack";
        meta.setDisplayName(displayName);
        List<String> lore = new ArrayList<String>();
        lore.add(type==1 ? "JumpBoots" : "JetPack");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

}
