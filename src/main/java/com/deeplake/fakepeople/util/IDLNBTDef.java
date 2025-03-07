package com.deeplake.fakepeople.util;

import com.deeplake.fakepeople.Main;

public class IDLNBTDef {
    //GENERAL:
    public static final String IDEALLAND = "idealland_nbt";

    //Damp
    public static final String CHANGE_RECORD = "change_rec";
    public static final String BLOCK_STATE = "blstate";
    public static final String BLOCK_POS = "blpos";

    public static final String DESC_FAKE = Main.MOD_ID + ".desc.fake";

    public static final String LAMP_MARK = "lamp_lit";

    //Map
    public static final String ORI_POS = "ori_pos";
    public static final String MAP_MARK_PLAYER_APHRODITE = Main.MOD_ID + ".map.player.aphrodite";
    public static final String MAP_MARK_PLAYER_POPOLON = Main.MOD_ID + ".map.player.popolon";
    public static final String MAP_MARK_BLANK = Main.MOD_ID + ".map.blank";
    public static final String MAP_MARK_PASS = Main.MOD_ID + ".map.pass";
    public static final String MAP_MARK_BOSS = Main.MOD_ID + ".map.boss";

    //Revival
    public static final String NO_REVIVE = "no_revive";

    //zombie
    public static final String IS_BABY = "IsBaby";

    //Sockey
    public static final String ANY_SOCKET = "socket_done";
    public static final String JADE_SOCKET = "jade_socket";
    public static final String CYCLE_SOCKET = "cycle_socket";
    public static final String WEIGHT_SOCKET = "weight_socket";
    public static final String FLESH_SOCKET = "flesh_socket";

    //magic gaze enhance
    public static final String GAZE_DAMAGE = "gaze_damage";
    public static final String GAZE_RANGE = "gaze_range";
    public static final String GAZE_TIME = "gaze_time";
    public static final String GAZE_BUFF = "gaze_buff";
    public static final String GAZE_CD = "gaze_cd";

    public static final String EVILNESS = "evilness";

    public static final String LV_EXP = "lv_xp";

    //Grand Protection
    public static final String PROTECT_STATUS = "grand_protect";


    //NBT
    public static final String IS_EARTH = "is_earth";
    public static final String IS_SKY = "is_sky";

    public static final String IMPRINT = "imprint";
    public static final String IMPRINT_NBT = "imprint_nbt";
    public static final String IMPRINT_DISP = "imprint_name_key";
    public static final String IMPRINT_CUSTOM_DISP = "imprint_name_is_custom";
    public static final String DYING = "dying";
    public static final String IMPRINT_DESC = "idealland.imprint.desc";

    //UNO
    public static final String CARD_SUIT = "card_suit";

    //goblet
    public static final String P2W_EXP = "p2w_experience";
    public static final String P2W_PAYING_EXP = "p2w_experience_paying";
    public static final String P2W_CACHE_EXP = "p2w_experience_cache";

    //skill
    public static final String LEVEL_TAG = "level";
    public static final String RANGE_BOOST = "range_boost";
    public static final String DURA_BOOST = "dura_boost";
    public static final String IS_IDENTIFIED = "identified";
    public static final String STATE = "state";
    public static final String STATE_2 = "state2";

    public static final String IS_NAME_HIDDEN = "name_hidden";
    public static final String IS_MANUAL_READY = "manual_ready";
    public static final String OWNER = "owner";
    public static final String IS_HEIRLOOM = "heirloom_of";
    public static final String HATE = "hate";

    //skill arknights
    public static final String IS_CASTING = "is_casting";
    public static final String CUR_CHARGE = "cur_charge";//x100
    public static final String CUR_TIME_LEFT = "time_left";//x100,please note that two may be the same


    public static final String EDICT_REPEATABLE = "is_repeatable";

    //upgrading
    public static final String DIFFICULTY = "difficulty";

    //TOOLTIP
    public static final String TOOLTIP_SKY = ".sky_desc";
    public static final String TOOLTIP_EARTH = ".earth_desc";
    public static final String TOOLTIP_NORMAL = ".normal_desc";
    public static final String TOOLTIP_SHARED = ".shared_desc";
    public static final String TOOLTIP_HIDDEN = ".hidden";
    public static final String TOOLTIP_DAMAGE = ".damage_desc";

    public static final String NAME_OFF= "idealland.shared.off";
    public static final String NAME_ON= "idealland.shared.on";

    public static final String TRUENAME_TO_REVEAL = ".true_name_reveal";
    public static final String MANUAL_PAGE_COUNT = ".manual_page_count";
    public static final String MANUAL_PAGE_KEY = ".manual_page_";
    public static final String MANUAL_AUTHOR = ".manual_author";
    public static final String MANUAL_TITLE = ".manual_title";

    //player
    public static final String STARTER_BOOK_GIVEN = "starter_book_given";

    //goblet
    public static final String ASSIGNED_BLOCK_NAME = "assigned_block";

    //IDL
    public static final String DESC_COMMON = ".desc";
    public static final String KILL_COUNT = "kill_count";
    public static final String KILL_COUNT_MOR = "kill_count_mor";
    public static final String MOR_INTEREST = "mor_interest";

    public static final String CHARGE_VALUE = "charge_value";

    public static final String BIOMETAL_WARNED = "biometal_warned";

    public static final String MODE = "mode";

    public static final String STARTER_KIT_VERSION_TAG = "last_starter_kit";
    public static final int CUR_STARTER_KIT_VERSION = 5;

    //edict
    public static final String EDICT_START = ".on_start";
    public static final String EDICT_END= ".on_end";
    public static final String EDICT_FAIL = ".on_fail";

    public static final String EDICT_COMMON_START = "edict.shared.start";
    public static final String EDICT_COMMON_END = "edict.shared.end";
    public static final String EDICT_COMMON_FAIL = "edict.shared.fail";


    public static final String EDICT_COMMON_REPEAT = "edict.shared.repeatable";

    //Builder
    public static final String CUR_TASK_INDEX = "cur_task_index";
    public static final String BUILD_SPEED = "build_speed";
    public static final String BUILD_ARG_1 = "build_arg_1";
    public static final String BUILD_ARG_2 = "build_arg_2";

    //gua socket
    public static final String GUA_NO_FREE_SOCKET_DESC = "idealland.gua_enhance_no_free.desc";
    public static final String GUA_FREE_SOCKET_DESC = "idealland.gua_enhance_free.desc";
    public static final String GUA_TOTAL_SOCKET_DESC = "idealland.gua_enhance_total.desc";
    public static final String GUA_N_A_DESC = "idealland.gua_not_applicable.desc";

    public static final String GUA_FREE_SOCKET = "gua_free_socket";
    public static final String GUA_ENHANCE = "gua_enhance";
    public static final String GUA_ENHANCE_8 = "gua_e_8";
    public static final String GUA_ENHANCE_64 = "gua_e_64";

    //anchor
    public static final String ANCHOR_READY = "anchor_ready";
    public static final String ANCHOR_X = "anchor_x";
    public static final String ANCHOR_Y = "anchor_y";
    public static final String ANCHOR_Z = "anchor_z";

    public static final String ANCHOR_READY_2 = "anchor_ready_2";
    public static final String ANCHOR_X_2 = "anchor_x_2";
    public static final String ANCHOR_Y_2 = "anchor_y_2";
    public static final String ANCHOR_Z_2 = "anchor_z_2";

    public static final String BUILDING_CHARGE = "building_charge";

    //research
    public static final String PACK_CODE = "pack_code";
    public static final String LEARNING_ID = "learning_id";
    public static final String LEARNING_PROGRESS = "learning_progress";
    public static final String LEARNING_DONE = "learning_done";

    //temperature
    public static final String BASE_TEMPERATURE = "base_temperature";
    public static final String BASE_IS_SET = "base_is_set";

    //level
    public static final String LAST_LEVEL = "last_lv";

    public static final String LEVEL = "lv_idl";

    public static final String INIT_DONE = "init_done";
    public static final String CUBIX_DIFF = "cubix_diff";

    public static final String FORCE_VANILLA = "force_vanilla";

    //parasite
    public static final String PARASITE_1 = "parasite_1";

    //nonsense
    public static final String KILL_COUNT_ITEM = "kill_count";//marked on items, not players
    public static final String KILL_COUNT_DESC = "idealland.kill_count.desc";

    public static final String MARKING_POS_A = "marking_pos_a";
    public static final String MARKING_POS_B = "marking_pos_b";

    public static final String MARK_ATK = "mark.attackDamage";
    public static final String MARK_HP = "mark.maxHealth";
    public static final String MARK_DEF = "mark.armor";
    public static final String MARK_ARMOR_T = "mark.armorToughness";
    public static final String MARK_RANGE = "mark.followRange";
    public static final String MARK_KB_R = "mark.knockbackResistance";
    public static final String MARK_SPEED = "mark.movementSpeed";
    public static final String MARK_ATK_SPEED = "mark.attackSpeed";

    public static final String MARK_TOTAL_COUNT = "mark.count";

    public static final String DEFERED_PAIN = "dfr_dmg";

    public static final String FLAVOR_KEY = ".flvr";
    public static final String SPELL_KEY = "selfSp_";
    public static final String OWNER_UUID = "own_uu";
    public static final String OWNER_NAME = "own_nm";
    public static final String OWNER_DESC = "idealland.owner.desc";
    // public static final String INIT_DONE = "inited";

    //prefix
    public static final String MSG_PREFIX = Main.MOD_ID + ".msg.";

    public static final String ARTIFACT_KEY = "idealland.item.artifact.desc";

    //Egypt
    public static final String EGYPT_KEY = "idealand.egypt.curse";
    public static final String UNKNOWN = "idealland.shared.unknown_desc";
    //tooltip
    public static final String TIP_SKILL = "idealland.shared.skill.desc";
    public static final String TIP_SKILL_EYE = "idealland.shared.skill.gaze.desc";
    public static final String OFFHAND_CAST = "idealland.shared.skill.desc.offhand";
    public static final String MAINHAND_CAST = "idealland.shared.skill.desc.mainhand";
    public static final String PASSIVE = "idealland.shared.skill.desc.passive";

    public static final String XP_GAUGE = "idealland.shared.skill.desc.xp_gauge";
    public static final String MAX = "idealland.shared.skill.desc.max";
    public static final String CUSTOM_NAME = "CustomName";

    //Spawner
    public static final String SPAWNER_TYPE = "spawner";
    public static final String SPAWNER_NBT = "spawner_nbt";
    public static final String SPAWN_POINT = "spawn_point";
    public static final String VINDICATOR_STRING = "{RequiredPlayerRange:8,SpawnRange:8,SpawnCount:1,MaxNearbyEntities:5,SpawnData:{CustomName:\"V\",CanPickUpLoot:1b,HandItems:[{id:\"minecraft:diamond_axe\",Count:1b,Damage:0s,tag:{ench:[{id:32,lvl:3}]}},{id:\"minecraft:shield\",Count:1b,Damage:0s,tag:{BlockEntityTag:{Base:7,Patterns:[{Pattern:bri,Color:13},{Pattern:sku,Color:15},{Pattern:bts,Color:1},{Pattern:tts,Color:1}]}}}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b,Damage:0s,tag:{Unbreakable:1,display:{color:13369530}}},{},{},{}],id:\"minecraft:vindication_illager\"},SpawnPotentials:[{Weight:1,Entity:{CustomName:\"V\",CanPickUpLoot:1b,HandItems:[{id:\"minecraft:diamond_axe\",Count:1b,Damage:0s,tag:{ench:[{id:32,lvl:3}]}},{id:\"minecraft:shield\",Count:1b,Damage:0s,tag:{BlockEntityTag:{Base:7,Patterns:[{Pattern:bri,Color:13},{Pattern:sku,Color:15},{Pattern:bts,Color:1},{Pattern:tts,Color:1}]}}}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b,Damage:0s,tag:{Unbreakable:1,display:{color:13369530}}},{},{},{}],id:\"minecraft:vindication_illager\"}}]}";
    public static final String BABY_ZOMBIE_STR = "{RequiredPlayerRange:8,SpawnRange:8,SpawnCount:1,MaxNearbyEntities:5,SpawnData:{IsBaby:1b,id:\"minecraft:zombie\"},SpawnPotentials:[{Weight:1,Entity:{IsBaby:1b,id:\"minecraft:zombie\"}}]}";

    public static final String BLOCK_ENTITY_TAG = "BlockEntityTag";
    public static final String BASE = "Base";
    public static final String MJDS_EGO = "mjds_ego";

    public static final String COOLDOWN_COUNTER = "cd_cnt";

    public static final String EGO_HP = "ego_hp";

    public static final String MJDS_ARROW = "mjds_arrow";

    public static final String DEAL_DESC = "backtones.desc.deal";

    public static final String DESC_EGO_BASE = "backtones.desc.ego.";
    public static final String HP_DESC = "backtones.desc.ego.hp";

    public static final String UNSUBSCRIBE = "worldboss.unsubscribe";
}
