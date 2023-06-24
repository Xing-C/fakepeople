package org.teacon.loongboat.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.teacon.loongboat.Idealland;

public class FakePeopleBase extends PathfinderMob {
    public FakePeopleBase(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
        for (EquipmentSlot slot:
                EquipmentSlot.values()) {
            setDropChance(slot,0);
        }
    }

    public FakePeopleBase(Level level, double x, double y, double z) {
        this(Idealland.FAKE_PEOPLE_ENTITY.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 pos, InteractionHand hand) {
        if (player.isCreative())
        {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.isEmpty())
            {
                for (EquipmentSlot slot:
                        EquipmentSlot.values()) {
                    setItemSlot(slot, ItemStack.EMPTY);
                }
            }
            else {
                Item item = stack.getItem();
                if (item instanceof ArmorItem)
                {
                    setItemSlot(((ArmorItem) item).getEquipmentSlot(), stack.copyWithCount(1));
                }
                else if (item instanceof ShieldItem)
                {
                    setItemSlot(EquipmentSlot.OFFHAND, stack.copyWithCount(1));
                }
            }
        }
        return super.interactAt(player, pos, hand);
    }
}
