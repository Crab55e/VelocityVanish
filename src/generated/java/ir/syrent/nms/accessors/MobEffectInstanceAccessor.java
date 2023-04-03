package ir.syrent.nms.accessors;

import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Class generated by NMS Mapper.
 * <p>
 * This class is a reflection accessor for net.minecraft.world.effect.MobEffectInstance
 *
 * @since 2023-04-01 20:04:12
 */
public class MobEffectInstanceAccessor {
  /**
   * This method returns the {@link Class} object of the requested NMS class.
   * <p>
   * This method is safe to call: exception is handled and null is returned in case of failure.
   *
   * @return the resolved class object or null if the class does not exist
   */
  public static Class<?> getType() {
    return AccessorUtils.getType(MobEffectInstanceAccessor.class, mapper -> {

          /* SEARGE */
          mapper.map("SEARGE", "1.8.8", "net.minecraft.potion.PotionEffect"); // 1.8.8 - 1.13.2
          mapper.map("SEARGE", "1.14", "net.minecraft.potion.EffectInstance"); // 1.14 - 1.16.5
          mapper.map("SEARGE", "1.17", "net.minecraft.src.C_498_"); // 1.17 - 1.19.3

          /* SPIGOT */
          mapper.map("SPIGOT", "1.8.8", "net.minecraft.server.${V}.MobEffect"); // 1.8.8 - 1.16.5
          mapper.map("SPIGOT", "1.17", "net.minecraft.world.effect.MobEffect"); // 1.17 - 1.19.3

        });
  }

  /**
   * This method returns the {@link Constructor} object of the requested NMS constructor.
   * <p>
   * Requested constructor: (net.minecraft.world.effect.MobEffect, int, int, boolean, boolean, boolean)
   * <p>
   * Present in versions: 1.19.3, 1.19.2, 1.19.1, 1.19, 1.18.2, 1.18.1, 1.18, 1.17.1, 1.17, 1.16.5, 1.16.4, 1.16.3, 1.16.2, 1.16.1, 1.15.2, 1.15.1, 1.15, 1.14.4, 1.14.3, 1.14.2, 1.14.1, 1.14, 1.13.2, 1.13.1, 1.13
   * <p>
   * This method is safe to call: exception is handled and null is returned in case of failure.
   *
   * @return the resolved constructor object or null if either class does not exist or it does not have this constructor in the specific environment
   */
  public static Constructor<?> getConstructor0() {
    return AccessorUtils.getConstructor(MobEffectInstanceAccessor.class, 0, MobEffectAccessor.getType(), int.class, int.class, boolean.class, boolean.class, boolean.class);
  }

  /**
   * This method returns the {@link Field} object of the requested NMS field.
   * <p>
   * Requested field: effect, mapping: mojang
   * <p>
   * This method is safe to call: exception is handled and null is returned in case of failure.
   *
   * @return the resolved field object or null if either class does not exist or it does not have this field in the specific environment
   */
  public static Field getFieldEffect() {
    return AccessorUtils.getField(MobEffectInstanceAccessor.class, "effect1", mapper -> {

          /* SEARGE */
          mapper.map("SEARGE", "1.9", "field_188420_b"); // 1.9 - 1.16.5
          mapper.map("SEARGE", "1.17", "f_19502_"); // 1.17 - 1.19.3

          /* SPIGOT */
          mapper.map("SPIGOT", "1.9", "b"); // 1.9 - 1.19.3

        });
  }
}
