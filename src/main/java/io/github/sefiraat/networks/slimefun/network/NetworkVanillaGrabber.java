package io.github.sefiraat.networks.slimefun.network;

import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.NodeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NetworkVanillaGrabber extends NetworkDirectional {

    private static final int[] BACKGROUND_SLOTS = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 16, 17, 18, 20, 22, 23, 24, 26, 27, 28, 30, 31, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private static final int OUTPUT_SLOT = 25;
    private static final int NORTH_SLOT = 11;
    private static final int SOUTH_SLOT = 29;
    private static final int EAST_SLOT = 21;
    private static final int WEST_SLOT = 19;
    private static final int UP_SLOT = 14;
    private static final int DOWN_SLOT = 32;

    public NetworkVanillaGrabber(ItemGroup itemGroup,
                                 SlimefunItemStack item,
                                 RecipeType recipeType,
                                 ItemStack[] recipe
    ) {
        super(itemGroup, item, recipeType, recipe, NodeType.PUSHER);
        this.getSlotsToDrop().add(OUTPUT_SLOT);
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);
        if (blockMenu != null) {
            tryGrabItem(blockMenu);
        }
    }

    private void tryGrabItem(@Nonnull BlockMenu blockMenu) {

        final ItemStack itemInSlot = blockMenu.getItemInSlot(OUTPUT_SLOT);

        if (itemInSlot != null && itemInSlot.getType() != Material.AIR) {
            return;
        }

        final NodeDefinition definition = NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());

        if (definition == null || definition.getNode() == null) {
            return;
        }

        final BlockFace direction = getCurrentDirection(blockMenu);
        final BlockState blockState = blockMenu.getBlock().getRelative(direction).getState();

        if (!(blockState instanceof InventoryHolder holder)) {
            return;
        }

        Inventory inventory = holder.getInventory();

        if (inventory instanceof FurnaceInventory furnaceInventory) {
            ItemStack stack = furnaceInventory.getResult();
            grabItem(blockMenu, stack);
        } else {
            for (ItemStack stack : inventory.getContents()) {
                if (grabItem(blockMenu, stack)) {
                    return;
                }
            }
        }
    }

    private boolean grabItem(BlockMenu blockMenu, ItemStack stack) {
        if (stack != null && stack.getType() != Material.AIR) {
            blockMenu.replaceExistingItem(OUTPUT_SLOT, stack.clone());
            stack.setAmount(0);
            return true;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    protected int[] getBackgroundSlots() {
        return BACKGROUND_SLOTS;
    }

    @Override
    public int getNorthSlot() {
        return NORTH_SLOT;
    }

    @Override
    public int getSouthSlot() {
        return SOUTH_SLOT;
    }

    @Override
    public int getEastSlot() {
        return EAST_SLOT;
    }

    @Override
    public int getWestSlot() {
        return WEST_SLOT;
    }

    @Override
    public int getUpSlot() {
        return UP_SLOT;
    }

    @Override
    public int getDownSlot() {
        return DOWN_SLOT;
    }

    @Override
    public boolean runSync() {
        return true;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{OUTPUT_SLOT};
    }

    @Override
    protected Particle.DustOptions getDustOptions() {
        return new Particle.DustOptions(Color.MAROON, 1);
    }
}
