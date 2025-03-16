package neopatch.util;

import com.mojang.datafixers.util.Function6;
import com.mojang.datafixers.util.Function7;
import com.mojang.datafixers.util.Function8;
import com.mojang.datafixers.util.Function9;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface PStreamCodec<B, V> extends StreamCodec<B, V> {

    static <B, C, T1, T2, T3, T4, T5, T6, T7> StreamCodec<B, C> composite(final StreamCodec<? super B, T1> codec1, final Function<C, T1> getter1, final StreamCodec<? super B, T2> codec2, final Function<C, T2> getter2, final StreamCodec<? super B, T3> codec3, final Function<C, T3> getter3, final StreamCodec<? super B, T4> codec4, final Function<C, T4> getter4, final StreamCodec<? super B, T5> codec5, final Function<C, T5> getter5, final StreamCodec<? super B, T6> codec6, final Function<C, T6> getter6
            , final StreamCodec<? super B, T7> codec7, final Function<C, T7> getter7, final Function7<T1, T2, T3, T4, T5, T6, T7, C> factory) {
        return new StreamCodec<B, C>() {
            @NotNull
            public C decode(B i) {
                T1 t1 = codec1.decode(i);
                T2 t2 = codec2.decode(i);
                T3 t3 = codec3.decode(i);
                T4 t4 = codec4.decode(i);
                T5 t5 = codec5.decode(i);
                T6 t6 = codec6.decode(i);
                T7 t7 = codec7.decode(i);
                return factory.apply(t1, t2, t3, t4, t5, t6, t7);
            }

            public void encode(B o, C t) {
                codec1.encode(o, getter1.apply(t));
                codec2.encode(o, getter2.apply(t));
                codec3.encode(o, getter3.apply(t));
                codec4.encode(o, getter4.apply(t));
                codec5.encode(o, getter5.apply(t));
                codec6.encode(o, getter6.apply(t));
                codec7.encode(o, getter7.apply(t));
            }
        };
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8> StreamCodec<B, C> composite(final StreamCodec<? super B, T1> codec1, final Function<C, T1> getter1, final StreamCodec<? super B, T2> codec2, final Function<C, T2> getter2, final StreamCodec<? super B, T3> codec3, final Function<C, T3> getter3, final StreamCodec<? super B, T4> codec4, final Function<C, T4> getter4, final StreamCodec<? super B, T5> codec5, final Function<C, T5> getter5, final StreamCodec<? super B, T6> codec6, final Function<C, T6> getter6
            , final StreamCodec<? super B, T7> codec7, final Function<C, T7> getter7, final StreamCodec<? super B, T8> codec8, final Function<C, T8> getter8,
                                                                              final Function8<T1, T2, T3, T4, T5, T6, T7, T8, C> factory) {
        return new StreamCodec<B, C>() {
            @NotNull
            public C decode(B i) {
                T1 t1 = codec1.decode(i);
                T2 t2 = codec2.decode(i);
                T3 t3 = codec3.decode(i);
                T4 t4 = codec4.decode(i);
                T5 t5 = codec5.decode(i);
                T6 t6 = codec6.decode(i);
                T7 t7 = codec7.decode(i);
                T8 t8 = codec8.decode(i);
                return factory.apply(t1, t2, t3, t4, t5, t6, t7, t8);
            }

            public void encode(B o, C t) {
                codec1.encode(o, getter1.apply(t));
                codec2.encode(o, getter2.apply(t));
                codec3.encode(o, getter3.apply(t));
                codec4.encode(o, getter4.apply(t));
                codec5.encode(o, getter5.apply(t));
                codec6.encode(o, getter6.apply(t));
                codec7.encode(o, getter7.apply(t));
                codec8.encode(o, getter8.apply(t));
            }
        };
    }

    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9> StreamCodec<B, C> composite(final StreamCodec<? super B, T1> codec1, final Function<C, T1> getter1, final StreamCodec<? super B, T2> codec2, final Function<C, T2> getter2, final StreamCodec<? super B, T3> codec3, final Function<C, T3> getter3, final StreamCodec<? super B, T4> codec4, final Function<C, T4> getter4, final StreamCodec<? super B, T5> codec5, final Function<C, T5> getter5, final StreamCodec<? super B, T6> codec6, final Function<C, T6> getter6
            , final StreamCodec<? super B, T7> codec7, final Function<C, T7> getter7, final StreamCodec<? super B, T8> codec8, final Function<C, T8> getter8
            , final StreamCodec<? super B, T9> codec9, final Function<C, T9> getter9, final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, C> factory) {
        return new StreamCodec<B, C>() {
            @NotNull
            public C decode(B i) {
                T1 t1 = codec1.decode(i);
                T2 t2 = codec2.decode(i);
                T3 t3 = codec3.decode(i);
                T4 t4 = codec4.decode(i);
                T5 t5 = codec5.decode(i);
                T6 t6 = codec6.decode(i);
                T7 t7 = codec7.decode(i);
                T8 t8 = codec8.decode(i);
                T9 t9 = codec9.decode(i);
                return factory.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }

            public void encode(B o, C t) {
                codec1.encode(o, getter1.apply(t));
                codec2.encode(o, getter2.apply(t));
                codec3.encode(o, getter3.apply(t));
                codec4.encode(o, getter4.apply(t));
                codec5.encode(o, getter5.apply(t));
                codec6.encode(o, getter6.apply(t));
                codec7.encode(o, getter7.apply(t));
                codec8.encode(o, getter8.apply(t));
                codec9.encode(o, getter9.apply(t));
            }
        };
    }
}
