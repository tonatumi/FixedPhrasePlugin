package com.gmail.tonatumi.fixedphraseplugin;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public final class FixedPhrasePlugin extends JavaPlugin implements Listener {

    public void openGUI(Player player){
        ItemStack coal = new ItemStack(Material.COAL);
        ItemMeta coalm = coal.getItemMeta();
        coalm.setDisplayName("§8おはつです");
        List<String> coallore = Arrays.asList("§8クリックでおはつといいます。");
        coalm.setLore(coallore);
        coal.setItemMeta(coalm);

        ItemStack ironIngot = new ItemStack(Material.IRON_INGOT);
        ItemMeta ironIngotm = ironIngot.getItemMeta();
        ironIngotm.setDisplayName("§8こんにちは");
        List<String> ironIngotlore = Arrays.asList("§8クリックでこんにちはといいます。");
        ironIngotm.setLore(ironIngotlore);
        ironIngot.setItemMeta(ironIngotm);

        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldIngotm = goldIngot.getItemMeta();
        goldIngotm.setDisplayName("§8よろしくお願いします");
        List<String> goldIngotlore = Arrays.asList("§8クリックでよろしくお願いしますといいます。");
        goldIngotm.setLore(goldIngotlore);
        goldIngot.setItemMeta(goldIngotm);

        ItemStack inkSack4 = new ItemStack(Material.INK_SACK,1,(short)4);
        ItemMeta inkSack4m = inkSack4.getItemMeta();
        inkSack4m.setDisplayName("§8おつです");
        List<String> inkSack4lore = Arrays.asList("§8クリックでおつですといいます。");
        inkSack4m.setLore(inkSack4lore);
        inkSack4.setItemMeta(inkSack4m);

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamondm = diamond.getItemMeta();
        diamondm.setDisplayName("§8ありがとう");
        List<String> diamondlore = Arrays.asList("§8クリックでありがとうといいます。");
        diamondm.setLore(diamondlore);
        diamond.setItemMeta(diamondm);

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emeraldm = emerald.getItemMeta();
        emeraldm.setDisplayName("§8ごめんなさい");
        List<String> emeraldlore = Arrays.asList("§8クリックでごめんなさいといいます。");
        emeraldm.setLore(emeraldlore);
        emerald.setItemMeta(emeraldm);

        ItemStack redstone = new ItemStack(Material.REDSTONE);
        ItemMeta redstonem = redstone.getItemMeta();
        redstonem.setDisplayName("§8はい");
        List<String> redstonelore = Arrays.asList("§8クリックではいといいます。");
        redstonem.setLore(redstonelore);
        redstone.setItemMeta(redstonem);

        ItemStack glowstoneDust = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta glowstoneDustm = glowstoneDust.getItemMeta();
        glowstoneDustm.setDisplayName("§8いいえ");
        List<String> glowstoneDustlore = Arrays.asList("§8クリックでいいえといいます。");
        glowstoneDustm.setLore(glowstoneDustlore);
        glowstoneDust.setItemMeta(glowstoneDustm);

        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemMeta quartzm =quartz.getItemMeta();
        quartzm.setDisplayName("§8おはまん！");
        List<String> quartzlore = Arrays.asList("§8クリックでおはまん！といいます。");
        quartzm.setLore(quartzlore);
        quartz.setItemMeta(quartzm);




        Inventory inv;
        inv = Bukkit.createInventory(null, 9, "定型文");
        inv.setItem(0,coal);
        inv.setItem(1,ironIngot);
        inv.setItem(2,goldIngot);
        inv.setItem(3,inkSack4);
        inv.setItem(4,diamond);
        inv.setItem(5,emerald);
        inv.setItem(6,redstone);
        inv.setItem(7,glowstoneDust);
        inv.setItem(8,quartz);
        player.openInventory(inv);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player)) return false;
        Player p = (Player)sender;
        openGUI(p);
        return true;
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event){
        Player p =(Player)event.getWhoClicked();
        if (event.getView().getTopInventory().getTitle().equals("定型文")) {
            switch (event.getCurrentItem().getType()) {
                case COAL:
                    p.chat("おはつです");
                    p.closeInventory();
                    break;
                case IRON_INGOT:
                    p.chat("こんにちは");
                    p.closeInventory();
                    break;
                case GOLD_INGOT:
                    p.chat("よろしくお願いします");
                    p.closeInventory();
                    break;
                case INK_SACK:
                    p.chat("おつです");
                    p.closeInventory();
                    break;
                case DIAMOND:
                    p.chat("ありがとうございます");
                    p.closeInventory();
                    break;
                case EMERALD:
                    p.chat("ごめんなさい");
                    p.closeInventory();
                    break;
                case REDSTONE:
                    p.chat("はい");
                    p.closeInventory();
                    break;
                case GLOWSTONE_DUST:
                    p.chat("いいえ");
                    p.closeInventory();
                    break;
                case QUARTZ:
                    p.chat("おはまん！");
                    p.closeInventory();
                    break;
            }
        }
    }

    public void onEnable() {
        getCommand("fpp").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin startup logic

    }

    public void onDisable() {
        // Plugin shutdown logic
    }
}
