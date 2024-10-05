package io.github.lapis256.ae2_recipe_type_patch.mixin;

import appeng.core.AppEngBase;
import appeng.init.InitRecipeTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = AppEngBase.class, remap = false)
public class AppEngBaseMixin {
    @Inject(method = "lambda$new$0", at = @At("HEAD"), cancellable = true)
    private void ae2_recipe_type_patch$onRegisterEvent(RegisterEvent event, CallbackInfo ci) {
        if(event.getRegistryKey().equals(Registries.RECIPE_TYPE)) {
            InitRecipeTypes.init(ForgeRegistries.RECIPE_TYPES);
            ci.cancel();
        }
    }

    @Redirect(method = "lambda$new$0", at = @At(value = "INVOKE", target = "Lappeng/init/InitRecipeTypes;init(Lnet/minecraftforge/registries/IForgeRegistry;)V"))
    private void ae2_recipe_type_patch$preventOriginalInit(IForgeRegistry<RecipeType<?>> toRegister) {
    }
}
