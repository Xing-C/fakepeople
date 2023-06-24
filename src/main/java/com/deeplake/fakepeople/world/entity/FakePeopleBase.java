package com.deeplake.fakepeople.world.entity;

import com.deeplake.fakepeople.Main;
import com.deeplake.fakepeople.setup.ModEntities;
import com.deeplake.fakepeople.util.EntityUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class FakePeopleBase extends PathfinderMob {
    public static final String[] RANDOM_NAMES =
            {
                    //MTG
                    "Chandra",
                    "Nalaar",
                    "Jace",
                    "Beleren",
                    "Ajani",
                    "Elsepth",
                    "Narset",
                    "Nahiri",
                    "Sorin_Markov",
                    "Goldmane",
                    "Asphodel",
                    "Azami",
                    "NicolBolas",
                    "Ugin",
                    "Emrakul",
                    "Ulamog",
                    "Kozilek",
                    "GrieselBand",
                    "Emeria",
                    "Zendikar",
                    "Ravnica",
                    "Azor",
                    "Rakdos",
                    "Barbogymos",
                    "Teyo",
                    "Trostani",
                    "Avacyn",
                    "Sigada",

                    //other
                    "LaoTie",
                    "FriedDuck",
                    "BaseMeow",
                    "SpaceBar",
                    "GTOLonger",
                    "NorthernPole",

                    //Danganronpa
                    "Nanami",
                    "YourHeadmaster",
                    "Makoto",

                    //Yazuka 0
                    "Lao_Gui",
                    "Kiryu_Kazama",
                    "Awano",
                    "Gojo_Majima",
                    "Kazama_Shintaro",
                    "Makimura_Makoto",
                    "Sera",
                    "Kuze",

                    //Genshin
                    "Zhong_li",
                    "Hu_Tao",
                    "Albedo",
                    "Eula",
                    "Wendy",
                    "Raiden",

                    //Heaven Burns
                    "Luka_Chan",
                    "Kareen_Chan",

                    //alchemy stars
                    "Nemesis",
                    "Micheal",
                    "Istvan",
                    "Schwarz",
                    "Vice"
            };


    public FakePeopleBase(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
        for (EquipmentSlot slot:
                EquipmentSlot.values()) {
            setDropChance(slot,0);
        }

        if (!hasCustomName())
        {
            rename(this);
        }
    }

    public FakePeopleBase(Level level, double x, double y, double z) {
        this(ModEntities.FAKE_PEOPLE_ENTITY.get(), level);
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
                    setItemSlot(((ArmorItem) item).getEquipmentSlot(), stack.copy());
                }
                else if (item instanceof ShieldItem)
                {
                    setItemSlot(EquipmentSlot.OFFHAND, stack.copy());
                }
                else
                {
                    setItemSlot(EquipmentSlot.MAINHAND, stack.copy());
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.interactAt(player, pos, hand);
    }

    private static void rename(Mob eventEntity) {
        RandomSource random1 = eventEntity.getRandom();
        String name = RANDOM_NAMES[random1.nextInt(RANDOM_NAMES.length)].toUpperCase();

        if (random1.nextBoolean())
        {
            name = name+random1.nextInt(999);
        }
        else if (random1.nextBoolean())
        {
            //append two random capital letters to the name
            name = name + '_'+(char)(random1.nextInt(26) + 'A') + (char)(random1.nextInt(26) + 'A');
        } else if (random1.nextBoolean())
        {
            name = name.replace('A','4');
        }

        eventEntity.setCustomName(Component.literal(name));
        eventEntity.setCustomNameVisible(true);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return EntityUtil.getAttrBuilder(6, 3, 0.8f);
    }
}
