package com.crazeclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;

public class HudRenderer {
    private static CPSCounter cpsCounter = new CPSCounter();

    public static void render(MatrixStack matrices, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();

        int baseX = 10;
        int baseY = 10;

        int colorActive = 0xFFFFFF;
        int colorInactive = 0x555555;

        KeyBinding forward = client.options.keyForward;
        KeyBinding left = client.options.keyLeft;
        KeyBinding back = client.options.keyBack;
        KeyBinding right = client.options.keyRight;

        client.textRenderer.drawWithShadow(matrices, "W", baseX + 10, baseY, forward.isPressed() ? colorActive : colorInactive);
        client.textRenderer.drawWithShadow(matrices, "A", baseX, baseY + 10, left.isPressed() ? colorActive : colorInactive);
        client.textRenderer.drawWithShadow(matrices, "S", baseX + 10, baseY + 10, back.isPressed() ? colorActive : colorInactive);
        client.textRenderer.drawWithShadow(matrices, "D", baseX + 20, baseY + 10, right.isPressed() ? colorActive : colorInactive);

        client.textRenderer.drawWithShadow(matrices, "LMB", baseX + 10, baseY + 30, colorInactive);
        client.textRenderer.drawWithShadow(matrices, "RMB", baseX + 50, baseY + 30, colorInactive);

        int cps = cpsCounter.getCPS();
        client.textRenderer.drawWithShadow(matrices, "CPS: " + cps, baseX, baseY + 50, 0xFF5555);

        String sprint = client.player != null && client.player.isSprinting() ? "Sprint: ON" : "Sprint: OFF";
        client.textRenderer.drawWithShadow(matrices, sprint, baseX, baseY + 70, 0x00FF00);
    }
}
