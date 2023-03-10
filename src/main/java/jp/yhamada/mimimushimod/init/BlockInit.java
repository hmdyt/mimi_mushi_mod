package jp.yhamada.mimimushimod.init;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.blocks.MimiMushiBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MimiMushiMod.MOD_ID);

    public static final RegistryObject<Block> MIMI_MUSHI_BLOCK = BLOCKS.register(
            "mimi_mushi_block",
            () -> new MimiMushiBlock(Block.Properties.copy(Blocks.DIRT))
    );

    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            BLOCKS.getEntries().forEach((blockRegistryObject -> {
                Block block = blockRegistryObject.get();
                Item.Properties properties = new Item.Properties().tab(MimiMushiMod.ModCreativeTab.instance);
                Supplier<Item> blockItemFactory = () -> new BlockItem(block, properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            }));
        }
    }
}
