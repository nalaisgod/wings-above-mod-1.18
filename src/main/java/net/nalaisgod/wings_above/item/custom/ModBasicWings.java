package net.nalaisgod.wings_above.item.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.Object2DoubleArrayMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.ElytraSoundInstance;
import net.minecraft.client.util.InputUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.entity.EntityChangeListener;
import net.minecraft.world.event.GameEvent;
import net.nalaisgod.wings_above.item.ModItems;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ModBasicWings extends ArmorItem {
    public ModBasicWings(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
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

                if(player.getInventory().getArmorStack(2).isOf(ModItems.BROKEN_WINGS)) {
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
        double yawcos = Math.cos(-player.prevYaw - Math.PI);
        double yawsin = Math.sin(-player.prevYaw - Math.PI);
        double pitchcos = Math.cos(player.prevPitch);
        double pitchsin = Math.sin(player.prevPitch);

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

