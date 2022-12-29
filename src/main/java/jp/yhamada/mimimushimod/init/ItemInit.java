package jp.yhamada.mimimushimod.init;

import jp.yhamada.mimimushimod.MimiMushiMod;
import net.minecraft.world.item.Item;
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
}