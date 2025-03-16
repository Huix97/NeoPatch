package neopatch.propertie;

import com.mojang.serialization.Codec;
import neopatch.NeoPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PComponents {
    public static final DeferredRegister.DataComponents P_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, NeoPatch.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> patched =
            P_COMPONENTS.registerComponentType("patched",
                    builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> p_require_tool =
            P_COMPONENTS.registerComponentType("p_require_tool",
                    builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());
}
