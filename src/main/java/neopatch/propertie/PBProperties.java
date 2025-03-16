package neopatch.propertie;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import neopatch.util.PStreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import javax.annotation.Nullable;

public record PBProperties(int lightEmission, boolean useShapeForLightOcclusion, boolean isAir, boolean ignitedByLava,
                           float destroySpeed, boolean requiresCorrectToolForDrops, boolean canOcclude, boolean spawnTerrainParticles, boolean replaceable) {

    public static final Codec<PBProperties> DIRECT_CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("lightEmission").forGetter(PBProperties::lightEmission),
                            Codec.BOOL.fieldOf("useShapeForLightOcclusion").forGetter(PBProperties::useShapeForLightOcclusion),
                            Codec.BOOL.fieldOf("isAir").forGetter(PBProperties::isAir),
                            Codec.BOOL.fieldOf("ignitedByLava").forGetter(PBProperties::ignitedByLava),
                            Codec.FLOAT.fieldOf("destroySpeed").forGetter(PBProperties::destroySpeed),
                            Codec.BOOL.fieldOf("requiresCorrectToolForDrops").forGetter(PBProperties::requiresCorrectToolForDrops),
                            Codec.BOOL.fieldOf("canOcclude").forGetter(PBProperties::canOcclude),
                            Codec.BOOL.fieldOf("spawnTerrainParticles").forGetter(PBProperties::spawnTerrainParticles),
                            Codec.BOOL.fieldOf("replaceable").forGetter(PBProperties::replaceable)
                    )
                    .apply(instance, PBProperties::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, PBProperties> DIRECT_STREAM_CODEC = PStreamCodec.composite(
            ByteBufCodecs.VAR_INT, PBProperties::lightEmission,
            ByteBufCodecs.BOOL, PBProperties::useShapeForLightOcclusion,
            ByteBufCodecs.BOOL, PBProperties::isAir,
            ByteBufCodecs.BOOL, PBProperties::ignitedByLava,
            ByteBufCodecs.FLOAT, PBProperties::destroySpeed,
            ByteBufCodecs.BOOL, PBProperties::requiresCorrectToolForDrops,
            ByteBufCodecs.BOOL, PBProperties::canOcclude,
            ByteBufCodecs.BOOL, PBProperties::spawnTerrainParticles,
            ByteBufCodecs.BOOL, PBProperties::replaceable,
            PBProperties::new
    );

    public static class Builder {
        private int lightEmission;
        private boolean useShapeForLightOcclusion;
        private boolean isAir;
        private boolean ignitedByLava;
        private float destroySpeed;
        private boolean requiresCorrectToolForDrops;
        private boolean canOcclude;
        private boolean spawnTerrainParticles;
        private boolean replaceable;
        public Builder(BlockBehaviour.BlockStateBase stateBase) {
            lightEmission = stateBase.getLightEmission();
            useShapeForLightOcclusion = stateBase.useShapeForLightOcclusion();
            isAir = stateBase.isAir();
            ignitedByLava = stateBase.ignitedByLava();
            destroySpeed = stateBase.getDestroySpeed(null, null);
            requiresCorrectToolForDrops = stateBase.requiresCorrectToolForDrops();
            canOcclude = stateBase.canOcclude();
            spawnTerrainParticles = stateBase.shouldSpawnTerrainParticles();
            replaceable = stateBase.canBeReplaced();
        }

        public Builder useShapeForLightOcclusion(boolean useShapeForLightOcclusion) {
            this.useShapeForLightOcclusion = useShapeForLightOcclusion;
            return this;
        }

        public Builder air(boolean air) {
            isAir = air;
            return this;
        }

        public Builder ignitedByLava(boolean ignitedByLava) {
            this.ignitedByLava = ignitedByLava;
            return this;
        }

        public Builder destroySpeed(float destroySpeed) {
            this.destroySpeed = destroySpeed;
            return this;
        }

        public Builder requiresCorrectToolForDrops(boolean requiresCorrectToolForDrops) {
            this.requiresCorrectToolForDrops = requiresCorrectToolForDrops;
            return this;
        }

        public Builder canOcclude(boolean canOcclude) {
            this.canOcclude = canOcclude;
            return this;
        }

        public Builder spawnTerrainParticles(boolean spawnTerrainParticles) {
            this.spawnTerrainParticles = spawnTerrainParticles;
            return this;
        }

        public Builder replaceable(boolean replaceable) {
            this.replaceable = replaceable;
            return this;
        }

        public Builder lightEmission(int lightEmission) {
            this.lightEmission = lightEmission;
            return this;
        }

        public PBProperties build() {
            return new PBProperties(lightEmission, useShapeForLightOcclusion, isAir, ignitedByLava, destroySpeed
                    , requiresCorrectToolForDrops, canOcclude, spawnTerrainParticles, replaceable);
        }
    }


}
