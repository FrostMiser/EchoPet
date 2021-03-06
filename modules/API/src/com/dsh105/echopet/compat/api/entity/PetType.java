/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.compat.api.entity;

import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.dsh105.echopet.compat.api.plugin.EchoPet;
import com.dsh105.echopet.compat.api.util.ReflectionUtil;
import com.dsh105.echopet.compat.api.util.wrapper.WrappedEntityType;
import com.google.common.collect.ImmutableList;

public enum PetType {

    // Aggressive mobs
	BLAZE("Blaze", 61, "Blaze Pet", 20D, 6D, "BLAZE", "Blaze", PetData.FIRE),
	CAVESPIDER("CaveSpider", 59, "Cave Spider Pet", 12D, 5D, "CAVE_SPIDER", "CaveSpider"),
	CREEPER("Creeper", 50, "Creeper Pet", 20D, 6D, "CREEPER", "Creeper", PetData.POWER),
	ENDERDRAGON("EnderDragon", 63, "EnderDragon Pet", 200D, 0D, "ENDER_DRAGON", "EnderDragon"),
	ENDERMAN("Enderman", 58, "Enderman Pet", 40D, 6D, "ENDERMAN", "Enderman", PetData.SCREAMING),
	ENDERMITE("Endermite", 67, "Endermite Pet", 2D, 2D, "ENDERMITE", "Endermite"),
	GHAST("Ghast", 56, "Ghast Pet", 10D, 7D, "GHAST", "Ghast"),
	GIANT("Giant", 53, "Giant Pet", 100D, 0D, "GIANT", "Giant"),
	GUARDIAN("Guardian", 68, "Guardian Pet", 20D, 10D, "GUARDIAN", "Guardian", PetData.ELDER),
	MAGMACUBE("MagmaCube", 62, "Magma Cube Pet", 20D, 5D, "MAGMA_CUBE", "LavaSlime", PetData.SMALL, PetData.MEDIUM, PetData.LARGE),
	PIGZOMBIE("PigZombie", 57, "Pig Zombie Pet", 20D, 6D, "PIG_ZOMBIE", "PigZombie", PetData.BABY),
    // SHULKER("Shulker", 69, "Shulker Pet", 30D, 4D, "SHULKER", "Shulker"),
	SILVERFISH("Silverfish", 60, "Silverfish Pet", 8D, 4D, "SILVERFISH", "Silverfihs"),
	SKELETON("Skeleton", 51, "Skeleton Pet", 20D, 5D, "SKELETON", "Skeleton", PetData.NORMAL, PetData.WITHER, PetData.STRAY),
	SLIME("Slime", 55, "Slime Pet", 20D, 4D, "SLIME", "Slime", PetData.SMALL, PetData.MEDIUM, PetData.LARGE),
	SPIDER("Spider", 52, "Spider Pet", 16D, 5D, "SPIDER", "Spider"),
	WITCH("Witch", 66, "Witch Pet", 26D, 5D, "WITCH", "Witch"),
	WITHER("Wither", 64, "Wither Pet", 300D, 8D, "WITHER", "WitherBoss", PetData.SHIELD),
	ZOMBIE("Zombie", 54, "Zombie Pet", 20D, 5D, "ZOMBIE", "Zombie", PetData.BABY, PetData.BLACKSMITH, PetData.BUTCHER, PetData.FARMER, PetData.LIBRARIAN, PetData.PRIEST, PetData.HUSK),

    // Passive mobs
	BAT("Bat", 65, "Bat Pet", 6D, 3D, "BAT", "Bat"),
	CHICKEN("Chicken", 93, "Chicken Pet", 4D, 3D, "CHICKEN", "Chicken", PetData.BABY),
	COW("Cow", 92, "Cow Pet", 10D, 4D, "COW", "Cow", PetData.BABY),
	HORSE("Horse", 100, "Horse Pet", 30D, 4D, "HORSE", "EntityHorse", PetData.BABY, PetData.CHESTED, PetData.SADDLE,
	        PetData.HORSE, PetData.DONKEY, PetData.MULE, PetData.SKELETON_HORSE, PetData.UNDEAD_HORSE, PetData.WHITE,
	        PetData.CREAMY, PetData.CHESTNUT, PetData.BROWN, PetData.BLACK, PetData.WHITE_SOCKS,
	        PetData.GRAY, PetData.DARK_BROWN, PetData.NONE, PetData.WHITEFIELD, PetData.WHITE_DOTS, PetData.BLACK_DOTS,
          PetData.NOARMOUR, PetData.IRON, PetData.GOLD, PetData.DIAMOND),
	IRONGOLEM("IronGolem", 99, "Iron Golem Pet", 100D, 7D, "IRON_GOLEM", "VillagerGolem"),
	MUSHROOMCOW("MushroomCow", 96, "Mushroom Cow Pet", 10D, 3D, "MUSHROOM_COW", "MushroomCow", PetData.BABY),
	OCELOT("Ocelot", 98, "Ocelot Pet", 10D, 4D, "OCELOT", "Ozelot", PetData.BABY, PetData.BLACK, PetData.RED, PetData.SIAMESE, PetData.WILD),
	PIG("Pig", 90, "Pig Pet", 10D, 3D, "PIG", "Pig", PetData.BABY, PetData.SADDLE),
	POLARBEAR("PolarBear", 102, "Polar Bear Pet", 30D, 9D, "POLAR_BEAR", "PolarBear", PetData.BABY, PetData.STANDING_UP),
	RABBIT("Rabbit", 101, "Rabbit Pet", 8D, 3D, "RABBIT", "Rabbit", PetData.BABY, PetData.BROWN, PetData.WHITE, PetData.BLACK, PetData.BLACK_AND_WHITE, PetData.GOLD, PetData.SALT_AND_PEPPER, PetData.THE_KILLER_BUNNY),
	SHEEP("Sheep", 91, "Sheep Pet", 8D, 3D, "SHEEP", "Sheep", PetData.BABY, PetData.SHEARED,
          PetData.BLACK, PetData.BLUE, PetData.BROWN,
          PetData.CYAN, PetData.GRAY, PetData.GREEN,
          PetData.LIGHTBLUE, PetData.LIME, PetData.MAGENTA,
          PetData.ORANGE, PetData.PINK, PetData.PURPLE, PetData.RED,
          PetData.SILVER, PetData.WHITE, PetData.YELLOW),
	SNOWMAN("Snowman", 97, "Snowman Pet", 4D, 4D, "SNOWMAN", "SnowMan", PetData.SHEARED),
	SQUID("Squid", 94, "Squid Pet", 10D, 4D, "SQUID", "Squid"),
	VILLAGER("Villager", 120, "Villager Pet", 20D, 4D, "VILLAGER", "Villager", PetData.BABY, PetData.BLACKSMITH, PetData.BUTCHER, PetData.FARMER, PetData.LIBRARIAN, PetData.PRIEST),
	WOLF("Wolf", 95, "Wolf Pet", 20D, 6D, "WOLF", "Wolf", PetData.BABY, PetData.TAMED, PetData.ANGRY,
         PetData.BLACK, PetData.BLUE, PetData.BROWN,
         PetData.CYAN, PetData.GRAY, PetData.GREEN,
         PetData.LIGHTBLUE, PetData.LIME, PetData.MAGENTA,
         PetData.ORANGE, PetData.PINK, PetData.PURPLE, PetData.RED,
         PetData.SILVER, PetData.WHITE, PetData.YELLOW),

	HUMAN("Human", 54, "Human Pet", 20D, 6D, "UNKNOWN", "UNKNOWN");

	private String classIdentifier;
    private Class<? extends IEntityPet> entityClass;
    private Class<? extends IPet> petClass;
    private String defaultName;
    private double maxHealth;
    private double attackDamage;
    private WrappedEntityType entityTypeWrapper;
	private String entityTypeFixedName, entityTypeName;
    private List<PetData> allowedData;
    private int id;

	PetType(String classIdentifier, int registrationId, String defaultName, double maxHealth, double attackDamage, String entityType, PetData... allowedData){
		this(classIdentifier, registrationId, defaultName, maxHealth, attackDamage, entityType, null, allowedData);
	}

	@SuppressWarnings({"unchecked", "deprecation"})
	PetType(String classIdentifier, int registrationId, String defaultName, double maxHealth, double attackDamage, String entityType, String entityTypeFixedName, PetData... allowedData){
		this.classIdentifier = classIdentifier;
		try{
            this.entityClass = (Class<? extends IEntityPet>) Class.forName(ReflectionUtil.COMPAT_NMS_PATH + ".entity.type.Entity" + classIdentifier + "Pet");
        } catch (ClassNotFoundException e) {
            // do nothing
        }
        this.petClass = ReflectionUtil.getClass("com.dsh105.echopet.api.pet.type." + classIdentifier + "Pet");
        this.id = registrationId;
        this.allowedData = ImmutableList.copyOf(allowedData);
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
		this.entityTypeWrapper = new WrappedEntityType(entityType);
		this.entityTypeFixedName = entityTypeFixedName;// I think this is the 'minecraft' name
		if(entityTypeWrapper == null || entityTypeWrapper.get() == null){
			this.entityTypeName = entityType;
		}else {
			this.entityTypeFixedName = entityTypeWrapper.get().getName();
			this.entityTypeName = entityTypeWrapper.get().name();
		}
        this.defaultName = defaultName;
    }

	public String getClassIdentifier(){
		return classIdentifier;
	}

    public int getRegistrationId() {
        return this.id;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public String getDefaultName(String name) {
        return EchoPet.getConfig().getString("pets." + this.toString().toLowerCase().replace("_", " ") + ".defaultName", this.defaultName).replace("(user)", name).replace("(userApos)", name + "'s");
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public double getAttackDamage() {
        return EchoPet.getConfig().getDouble("pets." + this.toString().toLowerCase().replace("_", " ") + ".attackDamage", this.attackDamage);
    }

	@Deprecated
	public EntityType getEntityType(){
		return entityTypeWrapper.get();
	}

	public String getEntityTypeFixedName(){
		return entityTypeFixedName;
	}

	public String getFixedSoundEffectEntityName(){
		switch (getClassIdentifier().toLowerCase()){
			case "polarbear":
				return "polar_bear";
			case "mushroomcow":
				return "cow";
			case "cavespider":
				return "spider";
			default:
				return getClassIdentifier().toLowerCase();
		}
	}

	public String getEntityTypeName(){
		return entityTypeName;
	}

    public List<PetData> getAllowedDataTypes() {
        return this.allowedData;
    }

    public boolean isDataAllowed(PetData data) {
        return getAllowedDataTypes().contains(data);
    }

    public IEntityPet getNewEntityPetInstance(Object world, IPet pet) {
        return EchoPet.getPetRegistry().getRegistrationEntry(pet.getPetType()).createEntityPet(world, pet);
    }

    public IPet getNewPetInstance(Player owner) {
        if (owner != null) {
            return EchoPet.getPetRegistry().spawn(this, owner);
        }
        return null;
    }

    public Class<? extends IEntityPet> getEntityClass() {
        return this.entityClass;
    }

    public Class<? extends IPet> getPetClass() {
        return this.petClass;
    }
}