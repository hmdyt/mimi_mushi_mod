package jp.yhamada.mimimushimod.init;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.items.MimiMushiBomb;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MimiMushiMod.MOD_ID);
    public static final RegistryObject<Item> SMILE = ITEMS.register(
            "smile",
            () -> new Item(new Item.Properties().tab(MimiMushiMod.ModCreativeTab.instance))
    );
    public static final RegistryObject<Item> MIMI_MUSHI = ITEMS.register(
            "mimi_mushi",
            () -> new Item(new Item.Properties().tab(MimiMushiMod.ModCreativeTab.instance))
    );
    public static final RegistryObject<Item> MIMI_BOMB = ITEMS.register(
            "mimi_bomb",
            () -> new MimiMushiBomb(props())
    );
    public static final RegistryObject<ForgeSpawnEggItem> MIMI_MUSHI_ENTITY_SPAWN_EGG = ITEMS.register(
            "mimi_mushi_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    EntityInit.MIMI_MUSHI,
                    0xFF55AA,
                    0x27DA9F,
                    props().stacksTo(16)
            )
    );

    private static Item.Properties props() {
        return new Item.Properties().tab(MimiMushiMod.ModCreativeTab.instance);
    }
}