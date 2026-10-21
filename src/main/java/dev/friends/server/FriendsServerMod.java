package dev.friends.server;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FriendsServerMod implements ModInitializer {
    public static final String MOD_ID = "friends_server";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ReturnScrollItem RETURN_SCROLL = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "return_scroll"),
            new ReturnScrollItem(new ReturnScrollItem.Settings().maxCount(1))
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(RETURN_SCROLL));
        LOGGER.info("Friends server mod initialized");
    }
}