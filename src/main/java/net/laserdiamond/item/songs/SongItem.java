package net.laserdiamond.item.songs;

import net.laserdiamond.item.components.SOWComponents;
import net.laserdiamond.item.songs.orders.SongOrder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public abstract class SongItem extends Item {

    protected final SongOrder songOrder;

    public SongItem(Settings settings, SongOrder songOrder) {
        super(settings);
        this.songOrder = songOrder;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (user.getStackInHand(hand).get(SOWComponents.SONG_SPELL) == null)
        {
            // TODO: user right-clicks with the item to get a random song of the category
            // EXAMPLE TO SET SPELL: user.getStackInHand(hand).set(SOWComponents.SONG_SPELL, 1);
        }
        return super.use(world, user, hand);
    }

    public abstract void onSongCast();

    public double songManaCost()
    {
        return 0;
    }

    public SongOrder getSongOrder() {
        return songOrder;
    }
}
