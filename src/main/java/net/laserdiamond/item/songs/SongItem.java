package net.laserdiamond.item.songs;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.item.components.SOWComponents;
import net.laserdiamond.util.SOWMath;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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
            Integer randomSpell = SOWMath.getRandomInt(3, false) + 1;
            // EXAMPLE TO SET SPELL: user.getStackInHand(hand).set(SOWComponents.SONG_SPELL, 1);
            user.getStackInHand(hand).set(SOWComponents.SONG_SPELL, randomSpell); // Set random spell if there is no spell stored
        }
        return super.use(world, user, hand);
    }

    public Integer getStoredSongSpell(PlayerEntity user)
    {
        if (user.getStackInHand(Hand.MAIN_HAND) != null)
        {
            return user.getStackInHand(Hand.MAIN_HAND).get(SOWComponents.SONG_SPELL);
        } else if (user.getStackInHand(Hand.OFF_HAND) != null)
        {
            return user.getStackInHand(Hand.OFF_HAND).get(SOWComponents.SONG_SPELL);
        }
        return 0;
    }

    public abstract void onSongCast(ServerPlayNetworking.Context context);

    public double songManaCost(PlayerEntity playerEntity)
    {
        int songManaCost = 0;
        Integer songInt;
        if (playerEntity == null)
        {
            return songManaCost;
        }
        final ItemStack mainHandStack = playerEntity.getStackInHand(Hand.MAIN_HAND);
        final ItemStack offHandStack = playerEntity.getStackInHand(Hand.OFF_HAND);

        if (mainHandStack != null)
        {
            if (mainHandStack.getItem() instanceof SongItem)
            {
                songInt = mainHandStack.get(SOWComponents.SONG_SPELL);
                if (songInt != null)
                {
                    SongOrderSpell spell = this.songOrder.getSongOrderSpell(songInt);
                    return spell.getManaCost();
                }
            }
        } else if (offHandStack != null)
        {
            if (offHandStack.getItem() instanceof SongItem)
            {
                songInt = offHandStack.get(SOWComponents.SONG_SPELL);
                if (songInt != null)
                {
                    SongOrderSpell spell = this.songOrder.getSongOrderSpell(songInt);
                    return spell.getManaCost();
                }
            }
        }
        return songManaCost;
    }

    public SongOrder getSongOrder() {
        return songOrder;
    }
}
