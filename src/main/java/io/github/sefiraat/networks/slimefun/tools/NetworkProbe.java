package io.github.sefiraat.networks.slimefun.tools;

import io.github.sefiraat.networks.network.NetworkRoot;
import io.github.sefiraat.networks.slimefun.network.NetworkController;
import io.github.sefiraat.networks.utils.StackUtils;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;

public class NetworkProbe extends SlimefunItem {

    public NetworkProbe(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemHandler(
            new ItemUseHandler() {
                @Override
                public void onRightClick(PlayerRightClickEvent e) {
                    Optional<Block> optional = e.getClickedBlock();
                    if (optional.isPresent()) {
                        Block block = optional.get();
                        Player player = e.getPlayer();
                        SlimefunItem slimefunItem = SlimefunItem.getByItem(player.getInventory().getItemInMainHand());
                        if (slimefunItem instanceof NetworkProbe) {
                            displayToPlayer(block, player);
                            StackUtils.putOnCooldown(e.getItem(), 10);
                            e.cancel();
                        }
                    }
                }
            }
        );
    }

    private void displayToPlayer(@Nonnull Block block, @Nonnull Player player) {
        NetworkRoot root = NetworkController.NETWORKS.get(block.getLocation());
        if (root != null) {
            final int bridges = root.getBridges().size();
            final int importers = root.getImports().size();
            final int exporters = root.getExports().size();
            final int monitors = root.getMonitors().size();
            final int shells = root.getShells().size();
            final int cells = root.getCells().size();
            final int wipers = root.getWipers().size();
            final int grabbers = root.getGrabbers().size();
            final int pushers = root.getPushers().size();
            final int purgers = root.getPushers().size();

            final Map<ItemStack, Integer> allNetworkItems = root.getAllNetworkItems();
            final int distinctItems = allNetworkItems.size();
            long totalItems = allNetworkItems.values().stream().mapToLong(integer -> integer).sum();

            player.sendMessage("------------------------------");
            player.sendMessage("         网络 - 组件统计        ");
            player.sendMessage("------------------------------");
            player.sendMessage(MessageFormat.format("{1}网桥: {2}{0}", bridges, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络入口: {2}{0}", importers, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络出口: {2}{0}", exporters, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络监测器: {2}{0}", monitors, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络外壳: {2}{0}", shells, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络单元: {2}{0}", cells, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}网络内存清除器: {2}{0}", wipers, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}Grabbers: {2}{0}", grabbers, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}Pushers: {2}{0}", pushers, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}Purgers: {2}{0}", purgers, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}Distinct Items: {2}{0}", distinctItems, Theme.CLICK_INFO, Theme.PASSIVE));
            player.sendMessage(MessageFormat.format("{1}累计物品: {2}{0}", totalItems, Theme.CLICK_INFO, Theme.PASSIVE));
        }
    }

}
