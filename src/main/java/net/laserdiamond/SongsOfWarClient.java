package net.laserdiamond;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.laserdiamond.client.SongManaOverlay;
import net.laserdiamond.event.KeyInputHandler;
import net.laserdiamond.networking.SOWMessages;

public class SongsOfWarClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HudRenderCallback.EVENT.register(new SongManaOverlay());
        SOWMessages.registerS2CPackets();
        KeyInputHandler.register();
    }
}
