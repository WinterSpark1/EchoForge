package net.fabricmc.example.item;

import net.fabricmc.example.EchoMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import java.util.function.Supplier;

public class ModItems {
    // Example registered item
    public static final Item MYTHRIL_INGOT = registerModItem("mythril_ingot", () -> new Item(new Item.Settings().group(null)));

    /**
     * Registers an item to the game registry.
     * 
     * @param name The item name (path part of Identifier)
     * @param itemSupplier A supplier that creates the item instance
     * @return The registered item instance
     */
    public static Item registerModItem(String name, Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get();
        Identifier id = new Identifier(EchoMod.MOD_ID, name);
        Registry.register(Registry.ITEM, id, item);
        return item;
    }

    /**
     * Call this method from your mod initialization to do any additional setup if needed.
     */
    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + EchoMod.MOD_ID);
        // The static fields are already registered via static initializer,
        // so usually nothing else needed here unless you have dynamic registrations
    }
}