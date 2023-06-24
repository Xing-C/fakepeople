package org.teacon.loongboat.world.entity;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.teacon.loongboat.Idealland;

public class LoongBoatEntity extends Boat {
    public static final String ENTITY_NAME = "loong_boat";

    private static final EntityDataAccessor<Byte> DATA_ID_SIZE =
            SynchedEntityData.defineId(LoongBoatEntity.class, EntityDataSerializers.BYTE);

    private static final byte DEFAULT_SIZE = 0;

    private static final String SIZE_DATA_KEY = "Size";

    private int controllerCount = 0;

    public LoongBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public LoongBoatEntity(Level level, double x, double y, double z) {
        this(Idealland.LOONG_BOAT_ENTITY.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Item getDropItem() {return Idealland.LOONG_BOAT_ITEM.get();}

    @SuppressWarnings("NullableProblems")
    @Override
    protected void destroy(DamageSource source) {
        this.spawnAtLocation(new ItemStack(this.getDropItem(), this.getSize() + 1));
    }

    @Override
    protected int getMaxPassengers() {return (this.getSize() + 1) * 2;}

    /**
     * @see Boat#positionRider(Entity, MoveFunction)
     */
    @SuppressWarnings("NullableProblems")
    @Override
    protected void positionRider(Entity rider, Entity.MoveFunction moveFunc) {
        super.positionRider(rider, moveFunc);

        var idx = this.getPassengers().indexOf(rider); // save time by only making one query
        if (idx == -1) return; // equivalent to if (!this.hasPassenger(eider)) return;

        float xOffset = -idx * 0.625F + 0.1F;
        if (rider instanceof Animal) xOffset += 0.2F;
        var posPlanar = new Vec3(xOffset, 0, 0)
                .yRot((-this.getYRot() - 90) * ((float) Math.PI / 180))
                .add(this.position());
        moveFunc.accept(rider, posPlanar.x, rider.getY(), posPlanar.z);

        // make animals always facing sidewards
        if (rider instanceof Animal && this.getPassengers().size() != this.getMaxPassengers()) {
            int facing = rider.getId() % 2 == 0 ? 90 : 270;
            rider.setYBodyRot(((Animal) rider).yBodyRot + facing);
            rider.setYHeadRot(rider.getYHeadRot() + facing);
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_SIZE, DEFAULT_SIZE);
    }

    public byte getSize() {return this.entityData.get(DATA_ID_SIZE);}

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putByte(SIZE_DATA_KEY, this.getSize());
    }

    public boolean isControllerFirstPerson() {
        var mc = Minecraft.getInstance();
        return mc.getCameraEntity() == this.getControllingPassenger()
                && mc.options.getCameraType() == CameraType.FIRST_PERSON;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public AABB getBoundingBoxForCulling() {
        var box = super.getBoundingBoxForCulling();
        var multiplier = this.getSize();
        return box.inflate(box.getXsize() * multiplier, 0, box.getZsize() * multiplier);
    }

    private String nextControllerName() {return "controller" + (this.controllerCount++);}
}
