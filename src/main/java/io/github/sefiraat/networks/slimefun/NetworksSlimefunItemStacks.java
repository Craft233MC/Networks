package io.github.sefiraat.networks.slimefun;

import io.github.sefiraat.networks.slimefun.network.NetworkMemoryWiper;
import io.github.sefiraat.networks.slimefun.tools.NetworkCard;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.text.MessageFormat;

/**
 * Creating SlimefunItemstacks here due to some items being created in Enums so this will
 * act as a one-stop-shop for the stacks themselves.
 */
@UtilityClass
public class NetworksSlimefunItemStacks {

    // Materials
    public static final SlimefunItemStack OPTIC_GLASS;
    public static final SlimefunItemStack OPTIC_CABLE;
    public static final SlimefunItemStack OPTIC_STAR;
    public static final SlimefunItemStack RADIOACTIVE_OPTIC_STAR;

    // Network Items
    public static final SlimefunItemStack NETWORK_CONTROLLER;
    public static final SlimefunItemStack NETWORK_BRIDGE;
    public static final SlimefunItemStack NETWORK_MONITOR;
    public static final SlimefunItemStack NETWORK_IMPORT;
    public static final SlimefunItemStack NETWORK_EXPORT;
    public static final SlimefunItemStack NETWORK_GRABBER;
    public static final SlimefunItemStack NETWORK_PUSHER;
    public static final SlimefunItemStack NETWORK_PURGER;
    public static final SlimefunItemStack NETWORK_GRID;
    public static final SlimefunItemStack NETWORK_CRAFTING_GRID;
    public static final SlimefunItemStack NETWORK_CELL;
    public static final SlimefunItemStack NETWORK_MEMORY_SHELL;
    public static final SlimefunItemStack NETWORK_MEMORY_WIPER_1;
    public static final SlimefunItemStack NETWORK_MEMORY_WIPER_2;
    public static final SlimefunItemStack NETWORK_MEMORY_WIPER_3;
    public static final SlimefunItemStack NETWORK_MEMORY_WIPER_4;

    // Tools
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_1;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_2;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_3;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_4;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_5;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_6;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_7;
    public static final SlimefunItemStack NETWORK_MEMORY_CARD_8;
    public static final SlimefunItemStack NETWORK_PROBE;

    static {

        OPTIC_GLASS = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_GLASS",
            new ItemStack(Material.GLASS),
            Theme.CRAFTING,
            "光学玻璃",
            "能够传输少量信息的玻璃"
        );

        OPTIC_CABLE = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_CABLE",
            new ItemStack(Material.STRING),
            Theme.CRAFTING,
            "光缆",
            "能够传输大量信息的光缆"
        );

        OPTIC_STAR = Theme.themedSlimefunItemStack(
            "NTW_OPTIC_STAR",
            new ItemStack(Material.NETHER_STAR),
            Theme.CRAFTING,
            "光学之星",
            "能够传输大量信息的星"
        );

        RADIOACTIVE_OPTIC_STAR = Theme.themedSlimefunItemStack(
            "NTW_RADIOACTIVE_OPTIC_STAR",
            getPreEnchantedItemStack(Material.NETHER_STAR, true, new Pair<>(Enchantment.ARROW_DAMAGE, 1)),
            Theme.CRAFTING,
            "放射性光学之星",
            "能够传输几乎无限信息的星"
        );

        NETWORK_CONTROLLER = Theme.themedSlimefunItemStack(
            "NTW_CONTROLLER",
            new ItemStack(Material.BLACK_STAINED_GLASS),
            Theme.MACHINE,
            "网络控制器",
            "网络控制器是网络的核心部分",
            "每个网络最多有1个控制器"
        );

        NETWORK_BRIDGE = Theme.themedSlimefunItemStack(
            "NTW_BRIDGE",
            new ItemStack(Material.WHITE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络"
        );

        NETWORK_MONITOR = Theme.themedSlimefunItemStack(
            "NTW_MONITOR",
            new ItemStack(Material.GREEN_STAINED_GLASS),
            Theme.MACHINE,
            "网络监视器",
            "网络监视器可以与附近的方块交互",
            "实现放入/取出物品",
            "",
            "目前支持:",
            "无尽科技存储"
        );

        NETWORK_IMPORT = Theme.themedSlimefunItemStack(
            "NTW_IMPORT",
            new ItemStack(Material.RED_STAINED_GLASS),
            Theme.MACHINE,
            "网络入口",
            "网络入口会将其中的物品送入网络中",
            "每个SF tick可传输最多9组物品",
            "可接收来自货运网络的物品"
        );

        NETWORK_EXPORT = Theme.themedSlimefunItemStack(
            "NTW_EXPORT",
            new ItemStack(Material.BLUE_STAINED_GLASS),
            Theme.MACHINE,
            "网络出口",
            "网络出口可以设置成",
            "持续将1组指定的物品送出网络",
            "可以使用货运网络从中提取物品"
        );

        NETWORK_GRABBER = Theme.themedSlimefunItemStack(
            "NTW_GRABBER",
            new ItemStack(Material.MAGENTA_STAINED_GLASS),
            Theme.MACHINE,
            "网络抓取器",
            "网络抓取器会尝试从",
            "指定的机器中抓取第一个物品"
        );

        NETWORK_PUSHER = Theme.themedSlimefunItemStack(
            "NTW_PUSHER",
            new ItemStack(Material.BROWN_STAINED_GLASS),
            Theme.MACHINE,
            "网络推送器",
            "网络推送器会尝试将",
            "指定的物品送入机器中"
        );

        NETWORK_PURGER = Theme.themedSlimefunItemStack(
            "NTW_TRASH",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "网络清除器",
            "网络清除器会从网络中移除指定物品",
            "该物品会立即消失，谨慎使用!"
        );

        NETWORK_GRID = Theme.themedSlimefunItemStack(
            "NTW_GRID",
            new ItemStack(Material.NOTE_BLOCK),
            Theme.MACHINE,
            "网格",
            "网格允许你查看网络中所有的物品",
            "你也可以直接放入或取出物品"
        );

        NETWORK_CRAFTING_GRID = Theme.themedSlimefunItemStack(
            "NTW_CRAFTING_GRID",
            new ItemStack(Material.REDSTONE_LAMP),
            Theme.MACHINE,
            "网格(带合成)",
            "这种网格与普通网格类似",
            "但会显示更少的物品",
            "不过你可以直接使用网络中的物品",
            "进行合成"
        );

        NETWORK_CELL = Theme.themedSlimefunItemStack(
            "NTW_CELL",
            new ItemStack(Material.HONEYCOMB_BLOCK),
            Theme.MACHINE,
            "网络单元",
            "网络单元拥有54格空间(相当于一个大箱子)",
            "可以通过网络访问其中的物品",
            "也可以直接打开"
        );

        NETWORK_MEMORY_SHELL = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_SHELL",
            new ItemStack(Material.DEEPSLATE_TILES),
            Theme.MACHINE,
            "网络外壳",
            "网络外壳是一个可以让",
            "网络访问其中内存卡内容的方块"
        );

        NETWORK_MEMORY_WIPER_1 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_WIPER_1",
            new ItemStack(Material.BASALT),
            Theme.MACHINE,
            "网络内存清除器 α",
            "网络内存清除器会不断地",
            "从内存卡中缓慢提取物品",
            "到网络中",
            "",
            MessageFormat.format("{0}速度: {1}{2} 组/t", Theme.CLICK_INFO, Theme.PASSIVE, NetworkMemoryWiper.STACKS_TO_PUSH[0])
        );

        NETWORK_MEMORY_WIPER_2 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_WIPER_2",
            new ItemStack(Material.POLISHED_BASALT),
            Theme.MACHINE,
            "网络内存清除器 β",
            "网络内存清除器会不断地",
            "从内存卡中缓慢提取物品",
            "到网络中",
            "",
            MessageFormat.format("{0}速度: {1}{2} 组/t", Theme.CLICK_INFO, Theme.PASSIVE, NetworkMemoryWiper.STACKS_TO_PUSH[1])
        );

        NETWORK_MEMORY_WIPER_3 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_WIPER_3",
            new ItemStack(Material.SMOOTH_BASALT),
            Theme.MACHINE,
            "网络内存清除器 γ",
            "网络内存清除器会不断地",
            "从内存卡中缓慢提取物品",
            "到网络中",
            "",
            MessageFormat.format("{0}速度: {1}{2} 组/t", Theme.CLICK_INFO, Theme.PASSIVE, NetworkMemoryWiper.STACKS_TO_PUSH[2])
        );

        NETWORK_MEMORY_WIPER_4 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_WIPER_4",
            new ItemStack(Material.POLISHED_BLACKSTONE),
            Theme.MACHINE,
            "网络内存清除器 δ",
            "网络内存清除器会不断地",
            "从内存卡中缓慢提取物品",
            "到网络中",
            "",
            MessageFormat.format("{0}速度: {1}{2} 组/t", Theme.CLICK_INFO, Theme.PASSIVE, NetworkMemoryWiper.STACKS_TO_PUSH[3])
        );

        NETWORK_MEMORY_CARD_1 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_1",
            new ItemStack(Material.LIGHT_GRAY_DYE),
            Theme.TOOL,
            "网络内存卡 (4K)",
            "可存储 " + NetworkCard.SIZES[0] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_2 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_2",
            new ItemStack(Material.GRAY_DYE),
            Theme.TOOL,
            "网络内存卡 (32K)",
            "可存储 " + NetworkCard.SIZES[1] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_3 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_3",
            new ItemStack(Material.LIME_DYE),
            Theme.TOOL,
            "网络内存卡 (262K)",
            "可存储 " + NetworkCard.SIZES[2] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_4 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_4",
            new ItemStack(Material.GREEN_DYE),
            Theme.TOOL,
            "网络内存卡 (2M)",
            "可存储 " + NetworkCard.SIZES[3] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_5 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_5",
            new ItemStack(Material.LIGHT_BLUE_DYE),
            Theme.TOOL,
            "网络内存卡 (16M)",
            "可存储 " + NetworkCard.SIZES[4] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_6 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_6",
            new ItemStack(Material.BLUE_DYE),
            Theme.TOOL,
            "网络内存卡 (134M)",
            "可存储 " + NetworkCard.SIZES[5] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_7 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_7",
            new ItemStack(Material.PINK_DYE),
            Theme.TOOL,
            "网络内存卡 (1B)",
            "可存储 " + NetworkCard.SIZES[6] + " 物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_MEMORY_CARD_8 = Theme.themedSlimefunItemStack(
            "NTW_MEMORY_CARD_8",
            new ItemStack(Material.RED_DYE),
            Theme.TOOL,
            "网络内存卡 (∞)",
            "可无限制存储物品",
            "",
            "副手中拿着需要设置的物品时",
            "右键点击以设置该卡片使用的物品",
            "只有卡片为空时才能进行设置",
            "",
            Theme.WARNING + "存储满时会丢弃后续输入的物品",
            Theme.WARNING + "升级会清空其中的物品",
            "",
            Theme.WARNING + "空"
        );

        NETWORK_PROBE = Theme.themedSlimefunItemStack(
            "NTW_PROBE",
            new ItemStack(Material.CLOCK),
            Theme.TOOL,
            "网络探测器",
            "右键点击网络控制器",
            "可以查看网络中的节点数量"
        );
    }

    @Nonnull
    @SafeVarargs
    public static ItemStack getPreEnchantedItemStack(Material material, boolean hide, @Nonnull Pair<Enchantment, Integer>... enchantments) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (Pair<Enchantment, Integer> pair : enchantments) {
            itemMeta.addEnchant(pair.getFirstValue(), pair.getSecondValue(), true);
        }
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
