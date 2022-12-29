package jp.yhamada.project2.init;

import jp.yhamada.project2.Project2;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Project2.MOD_ID);
    public static final RegistryObject<Item> SMILE = ITEMS.register(
           "smile",
            () -> new Item(new Item.Properties().tab(Project2.ModCreativeTab.instance))
    );
    public static final RegistryObject<Item> MIMI_MUSHI = ITEMS.register(
            "mimi_mushi",
            () -> new Item(new Item.Properties().tab(Project2.ModCreativeTab.instance))
    );
}