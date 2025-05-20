package com.crazeclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class CrazeClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("CrazeClient Loaded!");

        // Register HUD
        HudRenderCallback.EVENT.register(HudRenderer::render);
    }
}