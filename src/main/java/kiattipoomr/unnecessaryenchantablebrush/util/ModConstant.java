package kiattipoomr.unnecessaryenchantablebrush.util;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModConstant {
    public static final String MOD_ID = "unnecessaryenchantablebrush";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier Identifier(String name) {
        return Identifier.of(MOD_ID, name);
    }
}
