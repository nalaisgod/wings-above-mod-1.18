package net.nalaisgod.wings_above.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nalaisgod.wings_above.item.ModItems;

public class ModOtherOtherBasicWings extends ArmorItem {
    public ModOtherOtherBasicWings(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
    public int glideTime;
    public int damageTaken;

    /**
     * Simulates a Minecraft tick (20 per second).
     * The pitch and yaw are the look direction of the player.
     */

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(player.getInventory().getArmorStack(2).isOf(ModItems.FIRE_WINGS)) {
                    tick(player);
                    isGliding(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public void tick(PlayerEntity player) {
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        if (!player.isCreative() && (this.glideTime + 1) % 20 == 0) {
            this.damageTaken++;
        }

        //I did some simplifing of the folowing to reduce the number of negatives and trig functions
        double yawcos = Math.cos(-player.prevYaw - Math.PI);
        double yawsin = Math.sin(-player.prevYaw - Math.PI);
        double pitchcos = Math.cos(player.prevPitch);
        double pitchsin = Math.sin(player.prevPitch);

        double lookX = yawsin * -pitchcos;
        double lookY = -pitchsin;
        double lookZ = yawcos * -pitchcos;

        double hvel = Math.sqrt(x * x + z * z);
        double hlook = pitchcos; //Math.sqrt(lookX * lookX + lookZ * lookZ)
        double sqrpitchcos = pitchcos * pitchcos; //In MC this is multiplied by Math.min(1.0, Math.sqrt(lookX * lookX + lookY * lookY + lookZ * lookZ) / 0.4), don't ask me why, it should always =1

        //From here on, the code is identical to the code found in net.minecraft.entity.EntityLivingBase.moveEntityWithHeading(float, float) or rq.g(float, float) in obfuscated 15w41b
        y += -0.08 + sqrpitchcos * 0.06;

        if (y < 0 && hlook > 0) {
            double yacc = y * -0.1 * sqrpitchcos;
            y += yacc;
            x += lookX * yacc / hlook;
            z += lookZ * yacc / hlook;
        }
        if (player.prevPitch < 0) {
            double yacc = hvel * -pitchsin * 0.04;
            y += yacc * 3.5;
            x -= lookX * yacc / hlook;
            z -= lookZ * yacc / hlook;
        }
        if (hlook > 0) {
            x += (lookX / hlook * hvel - x) * 0.1;
            z += (lookZ / hlook * hvel - z) * 0.1;
        }


        x *= 0.99;
        y *= 0.98;
        z *= 0.99;

        player.setVelocity(x, y, z);



        this.glideTime++;
    }

    /**
     * Checks if the player is currently in a gliding state.
     * As you can see, if the player is in creative, they will remain gliding even if on the ground. They will stop gliding once they move (but that functionality is not shown here).
     */
    public boolean isGliding(PlayerEntity player) {
        if (player.isCreative()) {
            return glideTime > 0;
        } else {
            return !player.isOnGround() && player.fallDistance >= 1.0f;
        }
    }

}

