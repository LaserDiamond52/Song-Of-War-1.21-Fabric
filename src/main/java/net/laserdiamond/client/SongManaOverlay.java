package net.laserdiamond.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.laserdiamond.SongsOfWar;
import net.laserdiamond.attribute.SOWAttributes;
import net.laserdiamond.util.IEntityDataSaver;
import net.laserdiamond.util.SongManaData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class SongManaOverlay implements HudRenderCallback {

    private static final Identifier FILLED_SONG_MANA = Identifier.of(SongsOfWar.MOD_ID, "textures/song_mana/song_bar_filled.png");
    private static final Identifier EMPTY_SONG_MANA = Identifier.of(SongsOfWar.MOD_ID, "textures/song_mana/song_bar_empty.png");

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        int x = 0;
        int y = 0;
        final MinecraftClient client = Objects.requireNonNull(MinecraftClient.getInstance());

        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        x = width / 2;
        y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_SONG_MANA);

        // Subtract texture width (81) from X to center above health and armor bar
        // Add 10 to X to center above hunger bar

        drawContext.drawTexture(EMPTY_SONG_MANA, x + 10, y - 59, 0,0, 81, 8, 81, 8);

        RenderSystem.setShaderTexture(0, FILLED_SONG_MANA);

        drawContext.drawTexture(FILLED_SONG_MANA, x + 10, y - 59, 0, 0, Math.min((int) getSongManaProgress(client), 81), 8, Math.min((int) getSongManaProgress(client), 81), 8);

        // TODO: Make different colored song mana bars depending on what song the player is holding in either their offhand or mainhand
        // IDEA: Use experience bar for template?
        // Also display how much song mana the player has
    }

    private double getSongManaProgress(MinecraftClient client)
    {
        double progress = SongManaData.getSongMana(((IEntityDataSaver) client.player));
        double max = client.player.getAttributeValue(SOWAttributes.SONG_MANA);

        return max != 0 && progress != 0 ? progress * 81 / max : 0;
    }
}
