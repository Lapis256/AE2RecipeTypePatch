package io.github.lapis256.ae2_recipe_type_patch;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(AE2RecipeTypePatch.MOD_ID)
public class AE2RecipeTypePatch {
    public static final String MOD_ID = "ae2_recipe_type_patch";
    public static final String MOD_NAME = "AE2 RecipeType Patch";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public AE2RecipeTypePatch() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
