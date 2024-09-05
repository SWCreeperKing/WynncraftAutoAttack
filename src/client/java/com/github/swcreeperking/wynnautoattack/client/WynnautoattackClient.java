package com.github.swcreeperking.wynnautoattack.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public class WynnautoattackClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register( client -> {
            if (client.player == null) return;
            if (client.player.getAttackCooldownProgress(0f) < 1) return;
            if (!client.options.attackKey.isPressed()) return;

            var trace = client.crosshairTarget;
            if (client.interactionManager == null) return;

            if (trace instanceof EntityHitResult entity) {
                client.interactionManager.attackEntity(client.player, entity.getEntity());
            } else if (trace instanceof BlockHitResult block) {
                client.interactionManager.attackBlock(block.getBlockPos(), client.player.getHorizontalFacing());
            }
            else return;

            if (client.player == null) return;
            client.player.swingHand(Hand.MAIN_HAND);
        });
    }
}
