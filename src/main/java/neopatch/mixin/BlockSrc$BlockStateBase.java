package neopatch.mixin;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;
import neopatch.propertie.PComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class BlockSrc$BlockStateBase {
    @Unique
    private Block p_block;
    @Unique
    private boolean should_patched;

    @Inject(at = @At("RETURN"), method = "<init>")
    private void getSrc(Block owner, Reference2ObjectArrayMap<Property<?>, Comparable<?>> values, MapCodec<BlockState> propertiesCodec, CallbackInfo ci) {
        this.p_block = owner;
        this.should_patched = true;
    }


    @Inject(at = @At("HEAD"), method = "requiresCorrectToolForDrops", cancellable = true)
    private void patchedRequiresTool(CallbackInfoReturnable<Boolean> cir) {
        if (this.should_patched) {
            ItemStack stack = new ItemStack(this.p_block);
            if (stack.has(PComponents.patched) && stack.has(PComponents.p_require_tool))
                cir.setReturnValue(stack.get(PComponents.p_require_tool));
        }
    }
}
