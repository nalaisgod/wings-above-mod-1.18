package net.nalaisgod.wings_above.item.custom;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.annotation.Debug;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.nalaisgod.wings_above.item.ModItems;

public class ModComplexWings extends ArmorItem {
    public ModComplexWings(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
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

                if(player.getInventory().getArmorStack(2).isOf(ModItems.ANGEL_WINGS)) {
tick(player);
isGliding(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public void tick(PlayerEntity player) {
        if (!player.isCreative() && (this.glideTime + 1) % 20 == 0) {
            this.damageTaken++;
        }

        //I did some simplifing of the folowing to reduce the number of negatives and trig functions
        double yawcos = Math.cos(-player.getYaw() - Math.PI);
        double yawsin = Math.sin(-player.getYaw() - Math.PI);
        double pitchcos = Math.cos(player.getPitch());
        double pitchsin = Math.sin(player.getPitch());

        double lookX = yawsin * -pitchcos;
        double lookY = -pitchsin;
        double lookZ = yawcos * -pitchcos;

        double hvel = Math.sqrt(player.prevX * player.prevX + player.prevZ * player.prevZ);
        double hlook = pitchcos; //Math.sqrt(lookX * lookX + lookZ * lookZ)
        double sqrpitchcos = pitchcos * pitchcos; //In MC this is multiplied by Math.min(1.0, Math.sqrt(lookX * lookX + lookY * lookY + lookZ * lookZ) / 0.4), don't ask me why, it should always =1

        //From here on, the code is identical to the code found in net.minecraft.entity.EntityLivingBase.moveEntityWithHeading(float, float) or rq.g(float, float) in obfuscated 15w41b
        player.prevY += -0.08 + sqrpitchcos * 0.06;

        if (player.prevY < 0 && hlook > 0) {
            double yacc = player.prevY * -0.1 * sqrpitchcos;
            player.prevY += yacc;
            player.prevX += lookX * yacc / hlook;
            player.prevZ += lookZ * yacc / hlook;
        }
        if (player.prevPitch < 0) {
            double yacc = hvel * -pitchsin * 0.04;
            player.prevY += yacc * 3.5;
            player.prevX -= lookX * yacc / hlook;
            player.prevZ -= lookZ * yacc / hlook;
        }
        if (hlook > 0) {
            player.prevX += (lookX / hlook * hvel - player.prevX) * 0.1;
            player.prevZ += (lookZ / hlook * hvel - player.prevZ) * 0.1;
        }

        player.setVelocity(0.99,0,0);
        player.setVelocity(0,0.98,0);
        player.setVelocity(0,0,0.99);

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

